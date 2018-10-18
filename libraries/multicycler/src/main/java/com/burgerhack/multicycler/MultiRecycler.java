package com.burgerhack.multicycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.burgerhack.multicycler.adapters.RowAdapter;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.burgerhack.multicycler.modelservices.DataList;

import java.util.List;

/**
 * Created by Amritpal Singh on 28/09/2016.
 */
public class MultiRecycler extends RecyclerView {
    private DataList<RowBehaviour> mRows;
    private RowAdapter mRowAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    public MultiRecycler(Context context) {
        super(context);
    }

    public MultiRecycler(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiRecycler(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initialize();
    }

    private void initialize() {
        mRows = new DataList<>();
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.setLayoutManager(mLinearLayoutManager);
    }

    public LinearLayoutManager getLayoutManager() {
        return mLinearLayoutManager;
    }

    public void setMultiCyclerData(MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener) {
        if (mRowAdapter == null) {
            mRowAdapter = new RowAdapter(mRows, factory, listener);
            super.setAdapter(mRowAdapter);
        }
    }

    public void addData(List<RowBehaviour> list) {
        mRows.addAll(list);
    }

    public void addData(RowBehaviour row) {
        mRows.add(row);
    }

    public void resetAdapterWith(List<RowBehaviour> list) {
        mRows.resetWith(list);
    }

    public DataList<RowBehaviour> getRows() {
        return mRows;
    }

    public void destroy() {
        if (super.getAdapter() != null) {
            ((RowAdapter) super.getAdapter()).destroy();
        }
    }

}
