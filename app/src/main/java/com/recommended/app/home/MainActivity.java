package com.recommended.app.home;

import android.os.Bundle;

import com.recommended.app.core.BHBaseActivity;
import com.recommended.app.downloads.RecentsFragment;
import com.recommended.app.favorites.FavoritesFragment;
import com.recommended.app.home.fragments.HomeFragment;
import com.recommended.app.profile.HistoryFragment;
import com.recommended.app.utils.ui.BHTabHost;

import com.recommended.app.R;

/**
 * Created by Amritpal Singh on 5/13/17.
 */

public class MainActivity extends BHBaseActivity implements BHTabHost.OnTabClickListener {

    private BHTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    protected int getSubActivityLayoutId() {
        return R.layout.activity_main;
    }

    private void initViews() {
        mTabHost = (BHTabHost) findViewById(R.id.tabHostBottom);
        mTabHost.setOnTabClickListener(this);
        setHeaderText(getResources().getString(R.string.app_name));
        toggleSearchVisibility(true);
    }

    public void navigateToTabFragment(BHTabHost.TAB tab) {
        switch (tab) {
            case HOME:
                if (!isFragmentAlreadyLoaded(getMainContainerId(), HomeFragment.class)) {
                    launchFragmentInMainContainer(new HomeFragment(), getMainContainerId(), true, false);
                }
                break;
            case FAVORITES:
                if (!isFragmentAlreadyLoaded(getMainContainerId(), FavoritesFragment.class)) {
                    launchFragmentInMainContainer(new FavoritesFragment(), getMainContainerId(), true, false);
                }
                break;
            case DOWNLOADS:
                if (!isFragmentAlreadyLoaded(getMainContainerId(), RecentsFragment.class)) {
                    launchFragmentInMainContainer(new RecentsFragment(), getMainContainerId(), true, false);
                }
                break;
            case PROFILE:
                if (!isFragmentAlreadyLoaded(getMainContainerId(), HistoryFragment.class)) {
                    launchFragmentInMainContainer(new HistoryFragment(), getMainContainerId(), true, false);
                }
            default:

        }
    }

    @Override
    public void onTabClick(BHTabHost.TAB tab) {
        navigateToTabFragment(tab);
    }

    private int getMainContainerId() {
        return R.id.mainFragmentContainer;
    }
}
