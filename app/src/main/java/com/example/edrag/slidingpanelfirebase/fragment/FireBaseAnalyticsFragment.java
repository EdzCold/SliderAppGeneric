package com.example.edrag.slidingpanelfirebase.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.edrag.slidingpanelfirebase.R;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by edrag on 11/11/2017.
 */

public class FireBaseAnalyticsFragment extends Fragment implements View.OnClickListener {

    private FirebaseAnalytics mFirebaseAnalytics;
    private Button information_btn;
    private Button activity_btn;
    private Button preferences_btn;
    private Button event_btn;
    private Button crash_report_btn;
    private TextView show_information_txt;

    public FireBaseAnalyticsFragment() {
    }

    public static Fragment newInstance() {
        FireBaseAnalyticsFragment fragment = new FireBaseAnalyticsFragment();
        return fragment;
    }

    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());


    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_firebase_analytics, container, false);

/*
        information_btn = (Button) view.findViewById(R.id.information_btn).setOnClickListener(this);
        activity_btn = (Button) view.findViewById(R.id.activity_btn).setOnClickListener(this);
        preferences_btn = (Button) view.findViewById(R.id.preferences_btn).setOnClickListener(this);
        event_btn = (Button) view.findViewById(R.id.event_btn).setOnClickListener(this);
        crash_report_btn = (Button) view.findViewById(R.id.crash_report_btn).setOnClickListener(this);
*/
        view.findViewById(R.id.information_btn).setOnClickListener(this);
        view.findViewById(R.id.activity_btn).setOnClickListener(this);
        view.findViewById(R.id.preferences_btn).setOnClickListener(this);
        view.findViewById(R.id.event_btn).setOnClickListener(this);
        view.findViewById(R.id.crash_report_btn).setOnClickListener(this);
        show_information_txt = (TextView) view.findViewById(R.id.show_information_txt);

        return view;
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        String btnName = "";

        switch (v.getId()) {
            case R.id.activity_btn:
                btnName = "activity_btn";
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "activity_btn");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Activity");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "string");
                show_information_txt.setText("activity_btn");
                break;
            case R.id.information_btn:
                btnName = "information_btn";
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "information_btn");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Information");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "string");
                show_information_txt.setText("information_btn");
                break;
            case R.id.preferences_btn:
                btnName = "preferences_btn";
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "preferences_btn");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Preferences");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "string");
                show_information_txt.setText("preferences_btn");
                break;
            case R.id.event_btn:
                btnName = "event_btn";
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "event_btn");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Event");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "string");
                show_information_txt.setText("event_btn");
                break;
            case R.id.crash_report_btn:
                btnName = "crash_report_btn";
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "crash_report_btn");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Crash_report");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "string");
                show_information_txt.setText("crash_report_btn");
                break;

        }

        Log.d("FIREBASE", "Button information: " + btnName);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
