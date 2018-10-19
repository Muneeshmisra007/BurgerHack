package com.recommended.app.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.burgerhack.core.ui.BaseFragment;

import com.recommended.app.R;
import com.recommended.app.detail.DetailFragment;
import com.recommended.app.home.MainActivity;
import com.recommended.app.model.BHRecommendedGenerator;
import com.recommended.app.network.AsyncListener;
import com.recommended.app.utils.ui.RecommendedGridAdapter;
import com.recommended.app.utils.ui.RecyclerViewClickListener;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.ArrayList;
import java.util.List;

import static com.recommended.app.utils.AppConstants.BUNDLE_KEY_PRODUCT;
import static com.recommended.app.utils.AppConstants.TAG_FAVORITES;
import static com.recommended.app.utils.AppConstants.TAG_HISTORY;


/**
 * Created by Amritpal Singh on 5/27/17.
 */

public class HistoryFragment extends BaseFragment implements AsyncListener<List<RecommendedItem>>{

    RecyclerView mRvHistory;
    RecommendedGridAdapter mHistoryAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvHistory = view.findViewById(R.id.rvHistory);
        mRvHistory.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvHistory.setHasFixedSize(false);
        RecyclerViewClickListener listener=new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                RecommendedItem item = mHistoryAdapter.getItemsList().get(position);
                addDetailFragment(item);
            }
        };
        mHistoryAdapter = new RecommendedGridAdapter(new ArrayList(), listener);
        mRvHistory.setAdapter(mHistoryAdapter);
        mRvHistory.setNestedScrollingEnabled(false);
        BHRecommendedGenerator.getInstance().getBrowseHistory(this);

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

    @Override
    public void onResponse(Exception exception, List<RecommendedItem> response) {
        mHistoryAdapter.updateAdapter(response);
    }

    private void addDetailFragment(RecommendedItem recommendedItem) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(BUNDLE_KEY_PRODUCT, recommendedItem);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(arguments);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(((MainActivity) getActivity()).getMainContainerId(), detailFragment, null);
        fragmentTransaction.addToBackStack(TAG_HISTORY);
        fragmentTransaction.commit();
    }
}
