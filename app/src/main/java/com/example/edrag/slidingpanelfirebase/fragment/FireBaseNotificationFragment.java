package com.example.edrag.slidingpanelfirebase.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.edrag.slidingpanelfirebase.FireBaseExecution.FireBaseNotifications;
import com.example.edrag.slidingpanelfirebase.MainActivity;
import com.example.edrag.slidingpanelfirebase.R;
import com.example.edrag.slidingpanelfirebase.Utilities.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EN501863 on 13/11/2017.
 */

public class FireBaseNotificationFragment extends Fragment implements View.OnClickListener {

    public Button noti;
    private static String titulo = "", mensa = "";
    Context context;

    // JSON CON CUERPO DE LA NOTIFICACION
    public static JSONObject updateTokenRequestJSON(String token) {
        JSONObject jsonRQT = new JSONObject();
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("body", mensa);
            jsonParams.put("title", titulo);
            jsonRQT.put("to", token);
            jsonRQT.put("notification", jsonParams);
        } catch (Exception e) {
            Log.e("Service rqtJSON Error: ", e.getMessage());
        }
        return jsonRQT;
    }


    public FireBaseNotificationFragment() {
    }

    public static Fragment newInstance() {
        FireBaseNotificationFragment fragment = new FireBaseNotificationFragment();
        return fragment;
    }

    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_firebase_notification, container, false);
        super.onCreate(savedInstanceState);

        noti = (Button) view.findViewById(R.id.btn_not);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

///////////////////////////////SE CREA ALERT DIALOG QUE RECIBE CUERPO DE LA NOTIFICACION///////////////
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Datos de Notificación");

                // Set up the input
                final EditText input = new EditText(getActivity());
                final EditText title = new EditText(getActivity());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                title.setInputType(InputType.TYPE_CLASS_TEXT);


                LinearLayout layout = new LinearLayout(getActivity());
                layout.setOrientation(LinearLayout.VERTICAL);
                input.setHint("Titulo");
                layout.addView(input);
                title.setHint("Descripción");
                layout.addView(title);
                builder.setView(layout);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        titulo = title.getText().toString();
                        mensa = input.getText().toString();
                        // ENVÍA PETICION
                        final String mRequestBody = updateTokenRequestJSON(FirebaseInstanceId.getInstance().getToken()).toString();

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_FIREBASE,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                        JSONObject rqtResponse = new JSONObject();

                                        try {

                                            rqtResponse = new JSONObject(response);

                                            if (rqtResponse.has("status")) {
                                                String status = rqtResponse.getString("status");
                                            }

                                            if (rqtResponse.has("statusText")) {
                                                String statusText = rqtResponse.getString("statusText");
                                            }

                                            if (rqtResponse.has("mensaje")) {
                                                String mensaje = rqtResponse.getString("mensaje");
                                            }

                                        } catch (JSONException e) {
                                            Log.d("Exception RT:", e.toString());
                                        }
                                    }
                                }, new Response.ErrorListener()

                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Service Error: ", error.toString());
                                Toast.makeText(getActivity(), "Error Conexion Internet", Toast.LENGTH_LONG).show();
                            }
                        })

                        {
                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                HashMap<String, String> header = new HashMap<String, String>();
                                header.put("Content-Type", "application/json");
                                header.put("Authorization", "key=AIzaSyBJnzbCpCaZgxWbPa80f2MXgnSviqSJ7jY");

                                return header;
                            }

                            @Override
                            public byte[] getBody() throws AuthFailureError {
                                try {
                                    return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                                } catch (UnsupportedEncodingException uee) {
                                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                                    return null;
                                }
                            }
                        };

                        //stringRequest.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

//                        VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {

    }
}

