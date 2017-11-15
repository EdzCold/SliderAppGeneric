package com.example.edrag.slidingpanelfirebase.fragment;

//import android.app.Fragment;

import android.support.v4.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.edrag.slidingpanelfirebase.IconPanelActivity;
import com.example.edrag.slidingpanelfirebase.R;
import com.example.edrag.slidingpanelfirebase.adapter.AdapterIconsImage;
import com.example.edrag.slidingpanelfirebase.adapter.AdapterIconsImage.CallFragment;
import com.example.edrag.slidingpanelfirebase.model.IconsListImage;

import java.util.ArrayList;

/**
 * Created by edrag on 11/11/2017.
 */

public class SliderPartialListIconsFragment extends Fragment {

    private RecyclerView iconsRecycler;
    private AdapterIconsImage adapterIcon;
    private ArrayList<IconsListImage> elementIcons;
    private static CallFragment listener;

//    private static final String ARG_PARAM1 = "listener";


    public SliderPartialListIconsFragment() {

    }

    public static Fragment newInstance(CallFragment callFragment) {
        SliderPartialListIconsFragment fragment = new SliderPartialListIconsFragment();
        listener = callFragment;

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
        View view = inflater.inflate(R.layout.fragment_icons, container, false);

        iconsRecycler = (RecyclerView) view.findViewById(R.id.icons_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        Log.d("debugMode", "The application stopped after this");
        iconsRecycler.setLayoutManager(linearLayoutManager);

        //Inizialiced icons adapter    //////////////////////////////////////////////////
        elementIcons = new ArrayList<>();

        elementIcons.add(new IconsListImage("Ed_1"));
        elementIcons.add(new IconsListImage("Ed_2"));
        elementIcons.add(new IconsListImage("Ed_3"));
        elementIcons.add(new IconsListImage("Ed_4"));
        elementIcons.add(new IconsListImage("Ed_5"));

        /////////////////////////////////////////////////////////////////////////////////

        View element;

        adapterIcon = new AdapterIconsImage(this.getActivity(), elementIcons, listener);
        iconsRecycler.setAdapter(adapterIcon);

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
