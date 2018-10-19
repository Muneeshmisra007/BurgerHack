package com.recommended.app.favorites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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


/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class FavoritesFragment extends BaseFragment implements AsyncListener<List<RecommendedItem>> {

    RecyclerView mRvFavorite;
    RecommendedGridAdapter mFavoriteAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvFavorite = view.findViewById(R.id.rvFavorite);
        mRvFavorite.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvFavorite.setHasFixedSize(false);
        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                RecommendedItem item = mFavoriteAdapter.getItemsList().get(position);
                addDetailFragment(item);
            }
        };
        mFavoriteAdapter = new RecommendedGridAdapter(new ArrayList(), listener);
        mRvFavorite.setAdapter(mFavoriteAdapter);
        mRvFavorite.setNestedScrollingEnabled(false);
        BHRecommendedGenerator.getInstance().getFavoritesList(this);
    }


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_favorite;
    }


    @Override
    protected int getContainerViewGroupId() {
        return R.id.rvFavorite;
    }

    @Override
    protected void refreshActiveFragment() {

    }

    @Override
    public void onResponse(Exception exception, List<RecommendedItem> response) {
        mFavoriteAdapter.updateAdapter(response);
    }

    private void addDetailFragment(RecommendedItem recommendedItem) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(BUNDLE_KEY_PRODUCT, recommendedItem);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(arguments);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(((MainActivity) getActivity()).getMainContainerId(), detailFragment, null);
        fragmentTransaction.addToBackStack(TAG_FAVORITES);
        fragmentTransaction.commit();
    }
}
