package com.example.edrag.slidingpanelfirebase.adapter;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    String title;

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        itemIcon = icons.get(position);

//        holder.name.setText(itemIcon.getName());
        holder.iconView.setImageResource(itemIcon.getIdIcon());

//        holder.iconView.setImageDrawable(context.getResources().getDrawable(itemIcon.getIdIcon()));
        holder.setItemClickListener(selectOption());

    }

    public ItemClickListener selectOption() {
        return new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                view.setBackgroundColor(Color.GREEN);
                if (nameView != null && !view.equals(nameView)) {
                    nameView.setBackgroundColor(Color.TRANSPARENT);
                }
                nameView = view;
                String tap = icons.get(position).getTitle();
                switch (tap) {
                    case "FireBase Analitics":
                        callFragment.callFragmentAnalytics();
                        break;
                    case "FireBase Notification":
                        callFragment.callFragmentNotification();
                        break;
                }
            }

        };
    }


    @Override
    public int getItemCount() {
        return icons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private ImageView iconView;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            iconView = (ImageView) itemView.findViewById(R.id.name_element_txt);

            iconView.setOnClickListener(this);
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

    public void unionClickable() {

    }
}