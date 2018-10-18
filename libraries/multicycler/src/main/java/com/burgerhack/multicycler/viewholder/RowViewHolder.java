package com.burgerhack.multicycler.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.RowBehaviour;


/**
 * Created by Amritpal Singh on 19/10/18.
 */
public abstract class RowViewHolder extends RecyclerView.ViewHolder {
    public RowViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(RowBehaviour row, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener);
}
