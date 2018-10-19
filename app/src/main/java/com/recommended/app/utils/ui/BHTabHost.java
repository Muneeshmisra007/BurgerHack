package com.recommended.app.utils.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.recommended.app.R;

/**
 * Created by Amritpal Singh on 5/25/17.
 */

public class BHTabHost extends LinearLayout implements View.OnClickListener {


    private ViewGroup mHomeTab, mFavoriteTab, mProfileTab, mDownloadsTab;
    private OnTabClickListener mOnTabClickListener;


    public BHTabHost(Context context) {
        super(context);
    }

    public BHTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BHTabHost(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initViews();
    }

    private void initViews() {
        mHomeTab = (ViewGroup) findViewById(R.id.tabHome);
        mFavoriteTab = (ViewGroup) findViewById(R.id.tabFavorite);
        mProfileTab = (ViewGroup) findViewById(R.id.tabRecents);
        mDownloadsTab = (ViewGroup) findViewById(R.id.tabHistory);

        mHomeTab.setTag(TAB.HOME);
        mFavoriteTab.setTag(TAB.FAVORITES);
        mProfileTab.setTag(TAB.RECENTS);
        mDownloadsTab.setTag(TAB.HISTORY);
    }

    private void propagateClickEvent(TAB tab, ViewGroup viewGroup) {
        if (mOnTabClickListener != null) {
            mOnTabClickListener.onTabClick(tab);
        }
    }

    private void updateViews(ViewGroup viewGroup) {

        for (int i = 0; i < this.getChildCount(); i++) {
            ViewGroup parent = (ViewGroup) getChildAt(i);
            updateChildViews(parent, false);
        }

        updateChildViews(viewGroup, true);
    }

    private void updateChildViews(ViewGroup parent, boolean isSelected) {

        for (int i = 0; i < parent.getChildCount(); i++) {
            parent.getChildAt(i).setSelected(isSelected);
        }
    }

    private void registerForClickEvents() {

        for (int i = 0; i < this.getChildCount(); i++) {
            getChildAt(i).setOnClickListener(this);
        }
    }

    /**
     * callback listener to get Tabs click listener.
     *
     * @param listener @{@link OnTabClickListener}
     */
    public void setOnTabClickListener(OnTabClickListener listener) {
        mOnTabClickListener = listener;
        registerForClickEvents();
        mHomeTab.performClick();
    }

    /**
     * Method to toggle Visibility of Tabhost view.
     *
     * @param toShow
     * @param toAnimate
     */
    public void toggleTabHostVisibility(boolean toShow, boolean toAnimate) {

        if (toShow) {

            if (toAnimate) {
                animate().translationY(0)
                        .alpha(1.0f);
            } else {
                this.setVisibility(View.VISIBLE);
            }

        } else {

            if (toAnimate) {
                animate().translationY(getResources().getDimension(R.dimen.tabHostHeight))
                        .alpha(1.0f);
            } else {
                this.setVisibility(GONE);
            }
        }

    }

    @Override
    public void onClick(View v) {
        if (v instanceof ViewGroup) {
            ViewGroup viewgroup = (ViewGroup) v;
            propagateClickEvent((TAB) v.getTag(), viewgroup);
            updateViews(viewgroup);
        }
    }

    public enum TAB {
        HOME, FAVORITES, RECENTS, HISTORY
    }

    public interface OnTabClickListener {
        void onTabClick(TAB tab);
    }
}
