package com.recommended.app.favorites;

import com.burgerhack.core.ui.BaseFragment;

import com.recommended.app.R;


/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class FavoritesFragment extends BaseFragment {

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_favorite;
    }


    @Override
    protected int getContainerViewGroupId() {
        return R.id.mainContainer;
    }

    @Override
    protected void refreshActiveFragment() {

    }
}
