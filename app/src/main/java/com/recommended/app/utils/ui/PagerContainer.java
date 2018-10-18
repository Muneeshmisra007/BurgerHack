package com.recommended.app.utils.ui;

import android.content.Context;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.recommended.app.R;

/**
 * PagerContainer: A layout that displays a ViewPager with its children that are outside
 * the typical pager bounds.
 */
public class PagerContainer extends FrameLayout implements ViewPager.OnPageChangeListener, View.OnClickListener {

    boolean _needsRedraw = false;
    private ViewPager _viewPager;
    private View[] _trailersPagingIndicators;
    private Point _center = new Point();
    private Point _initialTouch = new Point();
    private CountDownTimer _pagerTimer;

    public PagerContainer(Context context) {
        super(context);
        init();
    }

    public PagerContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PagerContainer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        //Disable clipping of children so non-selected pages are visible
        setClipChildren(false);

        //Child clipping doesn't work with hardware acceleration in Android 3.x/4.x
        //You need to set this value here if using hardware acceleration in an
        // application targeted at these releases.
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        try {
            _viewPager = (ViewPager) getChildAt(0);
            _viewPager.addOnPageChangeListener(this);
            _pagerTimer = new ViewPagerTimer(5000, 5000);
            _pagerTimer.start();

        } catch (Exception e) {
            throw new IllegalStateException("The root child of PagerContainer must be a ViewPager");
        }
    }

    public ViewPager getViewPager() {
        return _viewPager;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        _center.x = w / 2;
        _center.y = h / 2;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //We capture any touches not already handled by the ViewPager
        // to implement scrolling from a touch outside the pager bounds.
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _initialTouch.x = (int) ev.getX();
                _initialTouch.y = (int) ev.getY();
            default:
                ev.offsetLocation(_center.x - _initialTouch.x, _center.y - _initialTouch.y);
                break;
        }
        return false;
        //return _viewPager.dispatchTouchEvent(ev);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //Force the container to redraw on scrolling.
        //Without this the outer pages render initially and then stay static
        if (_needsRedraw) {
            invalidate();
        }
        if (!_viewPager.isActivated()) {
            _pagerTimer.cancel();
            _pagerTimer.start();
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (_viewPager == null || _viewPager.getAdapter().getCount() == 0) {
            return;
        }
        for (int i = 0; i < _viewPager.getAdapter().getCount(); i++) {
            View v = _viewPager.getChildAt(i);

            if (v == null) {
                return;
            }

            if (i == position) {
                v.setAlpha(1.0f);
                _trailersPagingIndicators[i].setBackgroundResource(R.drawable.slider_page_indicator_active);
            } else {
                _trailersPagingIndicators[i].setBackgroundResource(R.drawable.slider_page_indicator_inactive);
            }
        }
    }

    public void setupPageIndicators(int count) {
        if (count == 0) {
            return;
        }

        LinearLayout pageIndicatorContainer = (LinearLayout) ((ViewGroup) getParent()).getChildAt(1);
        pageIndicatorContainer.removeAllViews();
        _trailersPagingIndicators = new View[count];
        for (int i = 0; i < _trailersPagingIndicators.length; i++) {
            _trailersPagingIndicators[i] = LayoutInflater.from(getContext()).inflate(R.layout.slider_indicator, pageIndicatorContainer, false);
            _trailersPagingIndicators[i].setOnClickListener(this);
            _trailersPagingIndicators[i].setTag(i);
            pageIndicatorContainer.addView(_trailersPagingIndicators[i]);

        }

        _trailersPagingIndicators[_viewPager.getCurrentItem()].setBackgroundResource(R.drawable.slider_page_indicator_active);
        pageIndicatorContainer.invalidate();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        _needsRedraw = (state != ViewPager.SCROLL_STATE_IDLE);
    }

    @Override
    public void onClick(View v) {

    }

    private class ViewPagerTimer extends CountDownTimer {

        public ViewPagerTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        /**
         * Callback fired on regular interval.
         *
         * @param millisUntilFinished The amount of time until finished.
         */
        @Override
        public void onTick(long millisUntilFinished) {
        }

        /**
         * Callback fired when the time is up.
         */
        @Override
        public void onFinish() {
            moveToNext();
            this.start();
        }

    }


    private void moveToNext() {
        if (_viewPager.getCurrentItem() != _viewPager.getChildCount() - 1) {
            _viewPager.setCurrentItem(_viewPager.getCurrentItem() + 1, true);
        } else {
            invalidate();
            _viewPager.setCurrentItem(0, false);
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (_pagerTimer != null) {
            _pagerTimer.cancel();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (_pagerTimer != null) {
            _pagerTimer.start();
        }
    }
}