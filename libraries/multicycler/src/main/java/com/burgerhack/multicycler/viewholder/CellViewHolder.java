package com.burgerhack.multicycler.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.model.CellBehaviour;

/**
 * Created by Amritpal Singh on 19/10/18.
 */
public abstract class CellViewHolder extends RecyclerView.ViewHolder {
    public CellViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(CellBehaviour cell, int position, OnMultiCyclerItemClickListener listener);
}
