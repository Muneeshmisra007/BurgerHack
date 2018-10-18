package com.recommended.app.favorites;

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

public class FavoritesFragment extends BaseFragment {

    RecyclerView mRvFavorite;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvFavorite = view.findViewById(R.id.rvFavorite);
        mRvFavorite.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvFavorite.setHasFixedSize(false);
        //mRvFavorite.setAdapter(new RecommendedGridAdapter(new ArrayList<ParkingItem>()));
        mRvFavorite.setNestedScrollingEnabled(false);
        //fetch data and set in Recyler
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
}
