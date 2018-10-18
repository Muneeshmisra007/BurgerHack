package com.recommended.app.home.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.burgerhack.multicycler.MultiRecycler;
import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.core.ui.BaseFragment;
import com.recommended.app.home.ui.multicycler.BHMulticylerFactory;

import com.recommended.app.R;


/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class HomeFragment extends BaseFragment implements OnMultiCyclerItemClickListener {

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
        mMultiRecycler = (MultiRecycler) view.findViewById(R.id.rvHomeMulticyler);
        mMultiRecycler.setMultiCyclerData(new BHMulticylerFactory(), this);
        executeWebService();
    }


    private void executeWebService() {
        showStatus(STATUS.STATUS_LOADING);
        //Get Data
    }

    @Override
    protected void refreshActiveFragment() {


    }

//    @Override
//    public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
//
//        if (getView() == null) return;
//
//        if (response != null) {
//            HomeResponse homeResponse = response.body();
//            if (ResponseUtils.isSuccessResponse(homeResponse)) {
//                showStatus(STATUS.STATUS_SUCCESS);
//                mMultiRecycler.addData(homeResponse.toCoursesRow());
//            } else if (ResponseUtils.isEmptyResponse(homeResponse)) {
//                showStatus(STATUS.STATUS_EMPTY);
//            } else {
//                showStatus(STATUS.STATUS_ERROR);
//            }
//        }
//
//    }
//
//    @Override
//    public void onFailure(Call<HomeResponse> call, Throwable t) {
//        showStatus(STATUS.STATUS_ERROR);
//    }

    @Override
    public void onMultiCyclerItemClick(View view, CellBehaviour cellItem) {

    }
}
