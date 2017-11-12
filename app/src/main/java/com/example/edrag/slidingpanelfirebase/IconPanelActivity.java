package com.example.edrag.slidingpanelfirebase;

//import android.app.Fragment;
import android.support.v4.app.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.edrag.slidingpanelfirebase.fragment.FireBaseAnalyticsFragment;
import com.example.edrag.slidingpanelfirebase.fragment.SliderFullListFragment;
import com.example.edrag.slidingpanelfirebase.fragment.SliderPartialListIconsFragment;

public class IconPanelActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_panel);

        //  Aqui se presentan: herramientas, el Slider(1, 2, 3)
        context = this;
/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

*/
        SlidingPaneLayout layout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        layout.setSliderFadeColor(Color.TRANSPARENT);

        //fragment slider 1
        Fragment iconListFragment = SliderPartialListIconsFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_icons, iconListFragment, "FRAGMENT_ICON").commit();

        //fragment slider 2

        Fragment iconDescriptorFragment = SliderFullListFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_icons_title, iconDescriptorFragment, "FRAGMENT_TITLE").commit();


        Fragment fireBaseAnalyticsFragment = FireBaseAnalyticsFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_firebase_analytics, fireBaseAnalyticsFragment, "FRAGMENT_ANALYTICS").commit();


    }

}
