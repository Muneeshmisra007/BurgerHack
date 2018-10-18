package com.recommended.app.utils.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.recommended.app.R;

import java.util.ArrayList;

/**
 * Created by Amritpal Singh on 7/8/16.
 */
public class RecommendedGridAdapter extends RecyclerView.Adapter<RecommendedGridAdapter.GridViewHolder> {

    private ArrayList gridItems;

    public RecommendedGridAdapter(ArrayList parkingItems) {
        gridItems = parkingItems;
    }

    public void updateAdapter(ArrayList parkingItems) {

        if (gridItems != null) {
            gridItems.clear();
            gridItems.addAll(parkingItems);
            notifyDataSetChanged();
        }
    }


    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recyler_grid_cell, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.setData(/*gridItems.get(position)*/);
    }

    @Override
    public int getItemCount() {
        return gridItems.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTvTitle;
        ImageView mImage;

        public GridViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tvTitle);
            mImage = itemView.findViewById(R.id.imgCell);
        }


        public void setData(/*T Item*/) {
            //tvTitle.setText(parkingItem.getParkingName());
            mImage.setImageDrawable(null);
            Glide.with(itemView.getContext()).load("url here").
                    placeholder(R.drawable.default_placeholder).into(mImage);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            }
        }

        public ArrayList getItemsList() {
            return gridItems;
        }
    }
}
