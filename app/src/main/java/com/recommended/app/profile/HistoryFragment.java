package com.recommended.app.profile;

import com.burgerhack.core.ui.BaseFragment;

import com.recommended.app.R;


/**
 * Created by Amritpal Singh on 5/27/17.
 */

public class HistoryFragment extends BaseFragment {

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_history;
    }

    @Override
    protected int getContainerViewGroupId() {
        return R.id.mainContainer;
    }

    @Override
    protected void refreshActiveFragment() {

    }
}
