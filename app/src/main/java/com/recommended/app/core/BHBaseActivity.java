package com.recommended.app.core;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.burgerhack.core.ui.BaseActivity;
import com.burgerhack.core.ui.BaseFragment;
import com.burgerhack.core.ui.FragmentLauncher;
import com.recommended.app.R;


/**
 * Created by Amritpal Singh on 19/10/18.
 */

public abstract class BHBaseActivity extends BaseActivity {

    ViewGroup mMainToolBar;
    View mSearchIcon;
    View mHomeIcon;
    TextView mTvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        attachSubActivityView();
        initialiseViews();
    }

    protected void launchFragment(FragmentLauncher launcherObject) {
        replaceContentFragment(getSupportFragmentManager(), launcherObject);
    }

    protected boolean isFragmentAlreadyLoaded(int containerId, Class frgamentClass) {
        return getFragmentInContainer(containerId) == null ? false :
                getFragmentInContainer(containerId).getClass() == frgamentClass;
    }

    private void attachSubActivityView() {
        ViewGroup subActivityContainer = (ViewGroup) findViewById(R.id.subActivityContainer);
        View subView = LayoutInflater.from(this).inflate(getSubActivityLayoutId(), subActivityContainer, false);
        subActivityContainer.removeAllViews();
        subActivityContainer.addView(subView);
    }

    private void initialiseViews() {
        mMainToolBar = (ViewGroup) findViewById(R.id.mainToolBar);
        mSearchIcon = findViewById(R.id.tvSearch);
        mHomeIcon = findViewById(R.id.tvHome);
        mTvHeader = (TextView) findViewById(R.id.tvHeader);
    }

    protected abstract int getSubActivityLayoutId();

    protected void setHeaderText(String text) {
        if (!TextUtils.isEmpty(text)) {
            mTvHeader.setText(text);
        }
    }

    protected void toggleSearchVisibility(boolean toShow) {

        if (toShow) {
            mSearchIcon.setVisibility(View.VISIBLE);
        } else {
            mSearchIcon.setVisibility(View.GONE);
        }
    }

    public void launchFragmentInMainContainer(BaseFragment fragment, int containerId, boolean isAdded, boolean isAddToBackStack) {

        FragmentLauncher.FragmentLaunchBuilder fragmentLaunchBuilder = new FragmentLauncher.FragmentLaunchBuilder();
        FragmentLauncher fragmentLauncher = fragmentLaunchBuilder.setContainerId(containerId).
                setFragment(fragment).
                setAddReplace(isAdded).
                setAddToBackStack(isAddToBackStack).build();
        launchFragment(fragmentLauncher);
    }

}

