package com.example.edrag.slidingpanelfirebase.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.edrag.slidingpanelfirebase.R;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by EN501863 on 17/11/2017.
 */

public class MapsFragment extends Fragment {

    private FirebaseAnalytics mFirebaseAnalytics;
    private Button information_btn;
    private Button activity_btn;
    private Button preferences_btn;
    private Button event_btn;
    private Button crash_report_btn;
    private TextView show_information_txt;

    public MapsFragment() {
    }

    public static Fragment newInstance() {
        MapsFragment fragment = new MapsFragment();
        return fragment;
    }

    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());


    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmet_firebase_analytics, container, false);
//
//        int PLACE_PICKER_REQUEST = 1;
//        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//
//        startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);


/*
        information_btn = (Button) view.findViewById(R.id.information_btn).setOnClickListener(this);
        activity_btn = (Button) view.findViewById(R.id.activity_btn).setOnClickListener(this);
        preferences_btn = (Button) view.findViewById(R.id.preferences_btn).setOnClickListener(this);
        event_btn = (Button) view.findViewById(R.id.event_btn).setOnClickListener(this);
        crash_report_btn = (Button) view.findViewById(R.id.crash_report_btn).setOnClickListener(this);
*/

        return view;
    }
//
//    @Override
//    public void onClick(View v) {
//    }
}
