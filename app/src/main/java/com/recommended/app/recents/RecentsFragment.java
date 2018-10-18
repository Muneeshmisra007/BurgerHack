package com.recommended.app.recents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.burgerhack.core.ui.BaseFragment;
import com.recommended.app.R;
import com.recommended.app.utils.ui.RecommendedGridAdapter;


/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class RecentsFragment extends BaseFragment {

    RecyclerView mRvRecents;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvRecents = view.findViewById(R.id.rvRecents);
        mRvRecents.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvRecents.setHasFixedSize(false);
        //mRvRecents.setAdapter(new RecommendedGridAdapter(new ArrayList<ParkingItem>()));
        mRvRecents.setNestedScrollingEnabled(false);
        //fetch data and set in Recyler
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
