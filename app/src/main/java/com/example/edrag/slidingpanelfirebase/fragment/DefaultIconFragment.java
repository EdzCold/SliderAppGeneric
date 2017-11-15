package com.example.edrag.slidingpanelfirebase.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edrag.slidingpanelfirebase.R;
import com.example.edrag.slidingpanelfirebase.adapter.AdapterIconsImage;
import com.example.edrag.slidingpanelfirebase.model.IconsListImage;

import java.util.ArrayList;

/**
 * Created by EN501863 on 15/11/2017.
 */

public class DefaultIconFragment extends Fragment {


    public DefaultIconFragment() {

    }

    public static Fragment newInstance() {
        DefaultIconFragment fragment = new DefaultIconFragment();

//        Bundle args = new Bundle();
/*
        args.putString(ARG_PARAM2, name);
        args.putString(ARG_PARAM3, base64);
        args.putString(ARG_PARAM4, mlastName);
        args.putString(ARG_PARAM5, mtelefono);
        args.putString(ARG_PARAM6, mcodigPostal);
        args.putString(ARG_PARAM7, mdireccion);
*/
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_icon_default, container, false);

        return view;
    }


//    new AdapterIconsImage.OnItemClicked() {
//        void onItemClick(View view) {
//            view.setBackgroundColor(Color.GREEN);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

}
