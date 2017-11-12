package com.example.edrag.slidingpanelfirebase.fragment;

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
import com.example.edrag.slidingpanelfirebase.adapter.AdapterIconTitle;
import com.example.edrag.slidingpanelfirebase.adapter.AdapterIconsImage;
import com.example.edrag.slidingpanelfirebase.model.IconsListImage;

import java.util.ArrayList;


/**
 * Created by edrag on 11/11/2017.
 */

public class SliderFullListFragment extends Fragment {

    private RecyclerView iconsTitleRecycler;
    private AdapterIconTitle adapterIconTitle;

    public SliderFullListFragment() {
    }

    public static Fragment newInstance() {
        SliderFullListFragment fragment = new SliderFullListFragment();
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_panel_list, container, false);

        iconsTitleRecycler = (RecyclerView) view.findViewById(R.id.icon_title_txt);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        Log.d("debugMode", "The application stopped after this");
        iconsTitleRecycler.setLayoutManager(linearLayoutManager);

        //Inizialiced icons adapter    //////////////////////////////////////////////////
        ArrayList<IconsListImage> elementIcons = new ArrayList<>();
        elementIcons.add(new IconsListImage("Ed_1", "---1---"));
        elementIcons.add(new IconsListImage("Ed_2", "---2---"));
        elementIcons.add(new IconsListImage("Ed_3", "---3---"));
        elementIcons.add(new IconsListImage("Ed_4", "---4---"));
        elementIcons.add(new IconsListImage("Ed_5", "---5---"));
        /////////////////////////////////////////////////////////////////////////////////

        adapterIconTitle = new AdapterIconTitle(this.getActivity(), elementIcons);
        iconsTitleRecycler.setAdapter(adapterIconTitle);

        return view;
    }
}
