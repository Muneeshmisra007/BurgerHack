package com.recommended.app.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burgerhack.core.ui.BaseFragment;

import com.recommended.app.R;
import com.recommended.app.utils.ui.RecommendedGridAdapter;


/**
 * Created by Amritpal Singh on 5/27/17.
 */

public class HistoryFragment extends BaseFragment {

    RecyclerView mRvHistory;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvHistory = view.findViewById(R.id.rvHistory);
        mRvHistory.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvHistory.setHasFixedSize(false);
        //mRvHistory.setAdapter(new RecommendedGridAdapter(new ArrayList<ParkingItem>()));
        mRvHistory.setNestedScrollingEnabled(false);
        //fetch data and set in Recyler
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
