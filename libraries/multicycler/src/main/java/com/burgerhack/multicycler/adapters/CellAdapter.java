package com.burgerhack.multicycler.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.multicycler.modelservices.DataList;
import com.burgerhack.multicycler.modelservices.OnDataListUpdateListener;
import com.burgerhack.multicycler.viewholder.CellViewHolder;

import java.lang.ref.WeakReference;


/**
 * Created by Amritpal Singh on 28/09/2016.
 */
public class CellAdapter extends RecyclerView.Adapter<CellViewHolder> implements OnDataListUpdateListener {
    protected DataList<CellBehaviour> mItems;
    protected MultiRecyclerViewFactory mRecyclerViewFactory;
    private int mRowId;
    private WeakReference<OnMultiCyclerItemClickListener> mMultiCyclerClickListener;


    public CellAdapter(DataList<CellBehaviour> items, MultiRecyclerViewFactory recyclerViewFactory, int rowType, OnMultiCyclerItemClickListener listener) {
        mItems = items;
        mItems.setOnDataListUpdateListener(this);
        mRowId = rowType;
        mRecyclerViewFactory = recyclerViewFactory;
        mMultiCyclerClickListener = new WeakReference<>(listener);
    }

    @Override
    public CellViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = mRecyclerViewFactory.getCellView(viewGroup, mRowId);
        return mRecyclerViewFactory.getCellViewHolder(view, mRowId);
    }

    @Override
    public void onBindViewHolder(CellViewHolder holder, int position) {
        holder.bind(mItems.get(position), position, mMultiCyclerClickListener.get());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onDataListUpdated() {
        notifyDataSetChanged();
    }
}
