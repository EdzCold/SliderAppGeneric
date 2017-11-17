package com.example.edrag.slidingpanelfirebase.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edrag.slidingpanelfirebase.R;
import com.example.edrag.slidingpanelfirebase.Utilities.ItemClickListener;
import com.example.edrag.slidingpanelfirebase.model.IconsListImage;

import java.util.ArrayList;

/**
 * Created by edrag on 11/11/2017.
 */

public class AdapterIconTitle extends RecyclerView.Adapter<AdapterIconTitle.ViewHolder> {

    private Context context;
    private ArrayList<IconsListImage> icons;
    private IconsListImage itemIcon;

    public AdapterIconTitle(Context context, ArrayList<IconsListImage> icons) {
        this.context = context;
        this.icons = icons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_descriptor_icon_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    View nameView;

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        itemIcon = icons.get(position);

//        holder.name.setText(itemIcon.getName());
        holder.title.setText(itemIcon.getTitle());
        holder.iconView.setImageResource(itemIcon.getIdIcon());

        holder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                new AdapterIconsImage(context, icons, listener).selectOption();

                view.setBackgroundColor(Color.GREEN);

                if (nameView != null && !view.equals(nameView)) {
                    nameView.setBackgroundColor(Color.TRANSPARENT);
                }

                nameView = view;
            }
        });

    }

    @Override
    public int getItemCount() {
        return icons.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        //        private TextView name;
        private ImageView iconView;
        private TextView title;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);

//            name = (TextView) itemView.findViewById(R.id.icon_element_txt);
            iconView = (ImageView) itemView.findViewById(R.id.name_element_txt);
            title = (TextView) itemView.findViewById(R.id.title_icon_txt);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
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
