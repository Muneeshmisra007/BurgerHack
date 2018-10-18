package com.recommended.app.recents;

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
 * Created by Amritpal Singh on 19/10/18.
 */

public class RecentsFragment extends BaseFragment {

    RecyclerView mRvRecents;
    RecommendedGridAdapter mRecentsAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvRecents = view.findViewById(R.id.rvRecents);
        mRvRecents.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvRecents.setHasFixedSize(false);
        mRecentsAdapter = new RecommendedGridAdapter(new ArrayList());
        mRvRecents.setAdapter(mRecentsAdapter);
        mRvRecents.setNestedScrollingEnabled(false);
        ArrayList<RecommendedItem> recommendedItems = (ArrayList<RecommendedItem>)
                BHRecommendedGenerator.getInstance().getRecentsList();
        mRecentsAdapter.updateAdapter(recommendedItems);
    }
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_recents;
    }


    @Override
    protected int getContainerViewGroupId() {
        return R.id.rvHistory;
    }

    @Override
    protected void refreshActiveFragment() {

    }
}
