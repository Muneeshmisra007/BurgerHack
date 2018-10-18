package com.burgerhack.multicycler.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.burgerhack.multicycler.modelservices.DataList;
import com.burgerhack.multicycler.modelservices.OnDataListUpdateListener;
import com.burgerhack.multicycler.viewholder.RowViewHolder;

import java.lang.ref.WeakReference;

/**
 * Created by Amritpal Singh on 28/09/2016.
 */
public class RowAdapter extends RecyclerView.Adapter<RowViewHolder> implements OnDataListUpdateListener {

    private static final String TAG = RowAdapter.class.getSimpleName();
    private DataList<RowBehaviour> mRowDataList;
    private MultiRecyclerViewFactory mRecyclerViewFactory;
    private WeakReference<OnMultiCyclerItemClickListener> mMultiCyclerClickListener;


    public RowAdapter(DataList<RowBehaviour> rowDataList, MultiRecyclerViewFactory recyclerViewFactory, OnMultiCyclerItemClickListener listener) {
        mRowDataList = rowDataList;
        mRowDataList.setOnDataListUpdateListener(this);
        mRecyclerViewFactory = recyclerViewFactory;
        mMultiCyclerClickListener = new WeakReference<>(listener);
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = mRecyclerViewFactory.getRowView(viewGroup, viewType);
        return mRecyclerViewFactory.getRowViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RowViewHolder listViewHolder, int position) {
        listViewHolder.bind(mRowDataList.get(position), mRecyclerViewFactory, mMultiCyclerClickListener.get());
    }

    @Override
    public int getItemCount() {
        return mRowDataList.size();
    }

    public void destroy() {
        mRowDataList = null;
        mRecyclerViewFactory = null;
    }

    @Override
    public void onDataListUpdated() {
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mRowDataList == null || mRowDataList.get(position) == null) {
            return 0;
        }
        return mRowDataList.get(position).getRowID();
    }
}
