package com.example.edrag.slidingpanelfirebase.adapter;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edrag.slidingpanelfirebase.R;
import com.example.edrag.slidingpanelfirebase.Utilities.ItemClickListener;
import com.example.edrag.slidingpanelfirebase.model.IconsListImage;

import java.util.ArrayList;

/**
 * Created by edrag on 11/11/2017.
 */

public class AdapterIconsImage extends RecyclerView.Adapter<AdapterIconsImage.ViewHolder> {

    private Context context;
    private ArrayList<IconsListImage> icons;
    private IconsListImage itemIcon;
    private CallFragment callFragment;

    public AdapterIconsImage(Context context, ArrayList<IconsListImage> icons, CallFragment callFragment) {
        this.context = context;
        this.icons = icons;
        this.callFragment = callFragment;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_icons_image_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    View nameView;

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        itemIcon = icons.get(position);

        holder.name.setText(itemIcon.getName());

        holder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onClick(View view, int position, boolean isLongClick) {
//                nameView != null ? nameView.setBackgroundColor(Color.TRANSPARENT) : view.setBackgroundColor(Color.GREEN);
                view.setBackgroundColor(Color.GREEN);

                if (nameView != null) {
                    nameView.setBackgroundColor(Color.TRANSPARENT);
                }

                nameView = view;

//                Log.d("TagNameData",((TextView) view).getText() + "");
//                Log.d("TagNameData",((TextView) view).getId() + "");

                String tap = ((TextView) view).getText() + "";

                switch (tap) {
                    case "Ed_1":
                        callFragment.callFragmentAnalytics();

                        break;
                    case "Ed_2":
                        callFragment.callFragmentNotification();
                        break;
                }


//                if(isLongClick)
//                    Toast.makeText(context,"Long Click: " + icons.get(position), Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(context,"Long Click: " + icons.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }


//    @Override
//    public void onClick(View v) {


//        if (colorButtonCurrent != -1) {
//            v.findViewById(colorButtonPrevious).setBackgroundColor(Color.TRANSPARENT);
//        }
//
//        v.setBackgroundColor(Color.GREEN);
//        colorButtonPrevious = colorButtonCurrent;
//        Log.d("FormatIdP: ", colorButtonPrevious + "");
//        Log.d("FormatIdC: ", colorButtonCurrent + "");
//    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView name;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_element_txt);

            name.setOnClickListener(this);
//            itemView.setOnClickListener(this);
//            itemView.setOnLongClickListener(this);


        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);

        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }

    }

    public interface CallFragment {
        void callFragmentNotification();
        void callFragmentAnalytics();
    }
}