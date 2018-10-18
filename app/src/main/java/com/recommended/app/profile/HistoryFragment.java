package com.recommended.app.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burgerhack.core.ui.BaseFragment;

import com.recommended.app.R;
import com.recommended.app.model.BHRecommendedGenerator;
import com.recommended.app.utils.ui.RecommendedGridAdapter;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.ArrayList;


/**
 * Created by Amritpal Singh on 5/27/17.
 */

public class HistoryFragment extends BaseFragment {

    RecyclerView mRvHistory;
    RecommendedGridAdapter mHistoryAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvHistory = view.findViewById(R.id.rvHistory);
        mRvHistory.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvHistory.setHasFixedSize(false);
        mHistoryAdapter = new RecommendedGridAdapter(new ArrayList());
        mRvHistory.setAdapter(mHistoryAdapter);
        mRvHistory.setNestedScrollingEnabled(false);
        ArrayList<RecommendedItem> recommendedItems = (ArrayList<RecommendedItem>)
                BHRecommendedGenerator.getInstance().getRecentsList();
        mHistoryAdapter.updateAdapter(recommendedItems);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    protected int getContainerViewGroupId() {
        return R.id.rvHistory;
    }

    @Override
    protected void refreshActiveFragment() {

    }


}
