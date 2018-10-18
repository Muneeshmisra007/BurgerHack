package com.recommended.app.home.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.burgerhack.multicycler.MultiRecycler;
import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.core.ui.BaseFragment;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.recommended.app.model.BHRecommendedGenerator;
import com.recommended.app.network.AsyncListener;
import com.recommended.app.utils.ui.multicycler.BHMulticylerFactory;

import com.recommended.app.R;
import com.recommended.app.utils.ui.multicycler.model.RecommendedCategory;

import java.util.List;


/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class HomeFragment extends BaseFragment implements OnMultiCyclerItemClickListener,AsyncListener<List<RowBehaviour>> {

    private MultiRecycler mMultiRecycler;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected int getContainerViewGroupId() {
        return R.id.rvHomeMulticyler;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMultiRecycler = view.findViewById(R.id.rvHomeMulticyler);
        mMultiRecycler.setMultiCyclerData(new BHMulticylerFactory(), this);
        executeWebService();
    }


    private void executeWebService() {
        showStatus(STATUS.STATUS_LOADING);
        BHRecommendedGenerator.getInstance().getHomeScreenContent(this);
    }

    @Override
    protected void refreshActiveFragment() {

    }

    @Override
    public void onMultiCyclerItemClick(View view, CellBehaviour cellItem) {

    }

    @Override
    public void onResponse(Exception exception, List<RowBehaviour> response) {
        mMultiRecycler.addData(response);
    }
}
