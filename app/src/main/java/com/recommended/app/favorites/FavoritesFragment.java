package com.recommended.app.favorites;

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

public class FavoritesFragment extends BaseFragment {

    RecyclerView mRvFavorite;
    RecommendedGridAdapter mFavoriteAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRvFavorite = view.findViewById(R.id.rvFavorite);
        mRvFavorite.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRvFavorite.setHasFixedSize(false);
        mFavoriteAdapter = new RecommendedGridAdapter(new ArrayList());
        mRvFavorite.setAdapter(mFavoriteAdapter);
        mRvFavorite.setNestedScrollingEnabled(false);
        ArrayList<RecommendedItem> recommendedItems = (ArrayList<RecommendedItem>)
                BHRecommendedGenerator.getInstance().getRecentsList();
        mFavoriteAdapter.updateAdapter(recommendedItems);
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
