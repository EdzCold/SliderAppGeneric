package com.example.edrag.slidingpanelfirebase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.edrag.slidingpanelfirebase.R;
import com.example.edrag.slidingpanelfirebase.model.IconsListImage;

import java.util.ArrayList;

/**
 * Created by edrag on 11/11/2017.
 */

public class AdapterIconsImage extends RecyclerView.Adapter<AdapterIconsImage.ViewHolder> {

    private Context context;
    private ArrayList<IconsListImage> icons;
    private IconsListImage itemIcon;

    public AdapterIconsImage(Context context, ArrayList<IconsListImage> icons) {
        this.context = context;
        this.icons = icons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_icons_image_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        itemIcon = icons.get(position);

        holder.name.setText(itemIcon.getName());

    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_element_txt);
        }
    }
}
