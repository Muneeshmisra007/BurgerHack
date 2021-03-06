package com.recommended.app.home;

import android.os.Bundle;

import com.recommended.app.core.BHBaseActivity;
import com.recommended.app.recents.RecentsFragment;
import com.recommended.app.favorites.FavoritesFragment;
import com.recommended.app.home.fragments.HomeFragment;
import com.recommended.app.history.HistoryFragment;
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
        mTabHost = findViewById(R.id.tabHostBottom);
        mTabHost.setOnTabClickListener(this);
    }

    public void navigateToTabFragment(BHTabHost.TAB tab) {
        switch (tab) {
            case HOME:
                setHeaderText(getResources().getString(R.string.homeHeader));
                if (!isFragmentAlreadyLoaded(getMainContainerId(), HomeFragment.class)) {
                    launchFragmentInMainContainer(new HomeFragment(), getMainContainerId(), false, false);
                }
                break;
            case FAVORITES:
                setHeaderText(getResources().getString(R.string.favHeader));
                if (!isFragmentAlreadyLoaded(getMainContainerId(), FavoritesFragment.class)) {
                    launchFragmentInMainContainer(new FavoritesFragment(), getMainContainerId(), false, false);
                }
                break;
            case HISTORY:
                setHeaderText(getResources().getString(R.string.historyHeader));
                if (!isFragmentAlreadyLoaded(getMainContainerId(), HistoryFragment.class)) {
                    launchFragmentInMainContainer(new HistoryFragment(), getMainContainerId(), false, false);
                }
                break;
            case RECENTS:
                setHeaderText(getResources().getString(R.string.recHeader));
                if (!isFragmentAlreadyLoaded(getMainContainerId(), RecentsFragment.class)) {
                    launchFragmentInMainContainer(new RecentsFragment(), getMainContainerId(), false, false);
                }
            default:

        }
    }

    @Override
    public void onTabClick(BHTabHost.TAB tab) {
        navigateToTabFragment(tab);
    }

    public int getMainContainerId() {
        return R.id.mainFragmentContainer;
    }
}
