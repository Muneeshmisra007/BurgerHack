package com.recommended.app.utils.ui.multicycler.holder;

import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.recommended.app.R;
import com.recommended.app.utils.ui.PagerContainer;
import com.recommended.app.utils.ui.multicycler.SliderViewPagerAdapter;
import com.recommended.app.utils.ui.multicycler.model.RecommendedCategory;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by Amritpal.Makkar on 10-Apr-15.
 */
public class SliderRowViewHolder extends BaseRecylerRowViewHolder {
    private static final String TAG = SliderRowViewHolder.class.getSimpleName();
    private PagerContainer _pagerContainer;

    public SliderRowViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(RowBehaviour row, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener) {
        RecommendedCategory category = (RecommendedCategory) row;
        _pagerContainer = getSliderContainer();
        _pagerContainer.setupPageIndicators(category.getRecommendedItems().size());

        ViewPager pager = _pagerContainer.getViewPager();
        float[] displayMetrices = getDeviceDisplayMetrices();
        ViewGroup.LayoutParams params = pager.getLayoutParams();
        params.width = (int) displayMetrices[0];
        params.height = (int) displayMetrices[0] * 9 / 16;
        pager.setLayoutParams(params);

        if (pager.getAdapter() == null) {
            SliderViewPagerAdapter sliderViewPagerAdapter = new SliderViewPagerAdapter(super.itemView.getContext(), category.getRecommendedItems(), listener);

            pager.setAdapter(sliderViewPagerAdapter);

            //Necessary or the pager will only have one extra page to show
            // make this at least however many pages you can see
            pager.setOffscreenPageLimit(sliderViewPagerAdapter.getCount());
            //A little space between pages
            pager.setPageMargin(2);
            pager.setCurrentItem(0);
            //If hardware acceleration is enabled, you should also remove
            // clipping on the pager for its children.
            pager.setClipChildren(false);
        }
    }

    private PagerContainer getSliderContainer() {
        return (PagerContainer) super.itemView.findViewById(R.id.pagerContainer);
    }

    public void destroyHolder() {
        _pagerContainer = null;
    }

    public float[] getDeviceDisplayMetrices() {

        float[] dimens = new float[2];
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) _pagerContainer.getContext().getSystemService(WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);

        dimens[0] = metrics.widthPixels;
        dimens[1] = metrics.heightPixels;
        return dimens;

    }
}

