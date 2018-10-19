package com.recommended.app.home.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.burgerhack.multicycler.MultiRecycler;
import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.core.ui.BaseFragment;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.recommended.app.detail.DetailFragment;
import com.recommended.app.home.MainActivity;
import com.recommended.app.model.BHRecommendedGenerator;
import com.recommended.app.network.AsyncListener;
import com.recommended.app.utils.ui.multicycler.BHMulticylerFactory;

import com.recommended.app.R;
import com.recommended.app.utils.ui.multicycler.model.RecommendedCategory;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.List;

import static com.recommended.app.utils.AppConstants.BUNDLE_KEY_PRODUCT;
import static com.recommended.app.utils.AppConstants.TAG_FAVORITES;
import static com.recommended.app.utils.AppConstants.TAG_HOME;


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
        RecommendedItem recommendedItem =(RecommendedItem)cellItem;
        addDetailFragment(recommendedItem);
    }

    @Override
    public void onResponse(Exception exception, List<RowBehaviour> response) {
        showStatus(STATUS.STATUS_SUCCESS);
        mMultiRecycler.addData(response);
    }

    private void addDetailFragment(RecommendedItem recommendedItem) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(BUNDLE_KEY_PRODUCT, recommendedItem);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(arguments);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(((MainActivity) getActivity()).getMainContainerId(), detailFragment, null);
        fragmentTransaction.addToBackStack(TAG_HOME);
        fragmentTransaction.commit();
    }
}
