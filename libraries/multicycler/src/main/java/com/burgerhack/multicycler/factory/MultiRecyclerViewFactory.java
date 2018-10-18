package com.burgerhack.multicycler.factory;

import android.view.View;
import android.view.ViewGroup;

import com.burgerhack.multicycler.viewholder.CellViewHolder;
import com.burgerhack.multicycler.viewholder.RowViewHolder;

/**
 * Created by Amritpal Singh on 28/09/2016.
 */
public abstract class MultiRecyclerViewFactory {
    public abstract View getRowView(ViewGroup parent, int rowID);

    public abstract RowViewHolder getRowViewHolder(View itemView, int rowID);

    public abstract View getCellView(ViewGroup parent, int rowID);

    public abstract CellViewHolder getCellViewHolder(View itemView, int rowID);

}
