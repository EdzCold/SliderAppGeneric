package com.example.edrag.slidingpanelfirebase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView firstActivity;
    private TextView secondActivity;
    private TextView thirdAtivity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        //Lista de actividades
        firstActivity = (TextView) findViewById(R.id.first_activity_txt);
        secondActivity = (TextView) findViewById(R.id.second_activity_txt);
        thirdAtivity = (TextView) findViewById(R.id.third_activity_txt);

        firstActivity.setOnClickListener(this);

    }

    public void onClick(View v) {
        //Error Remplazar el comportamiento default de la primera opcion
        switch(v.getId()){
            case R.id.first_activity_txt:
                startActivity(new Intent(context, IconPanelActivity.class));
                break;
            case R.id.second_activity_txt:
                break;
            case R.id.third_activity_txt:
                break;
        }
    }
}
