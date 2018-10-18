package com.recommended.app.downloads;

import com.burgerhack.core.ui.BaseFragment;
import com.recommended.app.R;


/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class RecentsFragment extends BaseFragment {

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_recents;
    }


    @Override
    protected int getContainerViewGroupId() {
        return R.id.mainContainer;
    }

    @Override
    protected void refreshActiveFragment() {

    }
}
