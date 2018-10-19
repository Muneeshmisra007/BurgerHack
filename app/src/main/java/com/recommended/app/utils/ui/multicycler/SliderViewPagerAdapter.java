package com.recommended.app.utils.ui.multicycler;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.recommended.app.R;
import com.recommended.app.utils.ui.RecyclerViewClickListener;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.ArrayList;

/**
 * Created by amritpalsingh on 23/04/15.
 */
public class SliderViewPagerAdapter extends PagerAdapter implements View.OnClickListener {

    private static final String TAG = SliderViewPagerAdapter.class.getSimpleName();
    private ArrayList<RecommendedItem> mRecommendedItem;
    private Context mContext;
    private OnMultiCyclerItemClickListener mOnMultiCyclerItemClickListener;


    public SliderViewPagerAdapter(Context context, ArrayList<RecommendedItem> itemVOList, OnMultiCyclerItemClickListener listener) {
        mRecommendedItem = itemVOList;
        mContext = context;
        mOnMultiCyclerItemClickListener = listener;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.slider_cell_layout, container, false);
        initView(view, mRecommendedItem.get(position), position);
        container.addView(view);

        return view;
    }

    private void initView(View v, RecommendedItem recommendedItem, int position) {

        ImageView imageView = v.findViewById(R.id.imgSliderPoster);
        imageView.setImageDrawable(null);
        Glide.with(v.getContext()).load(recommendedItem.getImageUrl()).
                placeholder(R.drawable.default_placeholder).into(imageView);
        ((TextView) v.findViewById(R.id.tvSliderCellTitle)).setText(recommendedItem.getTitle());
        imageView.setTag(R.id.idViewPagerItem, mRecommendedItem.get(position));
        imageView.setOnClickListener(this);
    }

    @Override
    public int getCount() {
        return mRecommendedItem.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ViewGroup) object);
    }

    @Override
    public void onClick(View v) {
        mOnMultiCyclerItemClickListener.onMultiCyclerItemClick(v, (RecommendedItem) v.getTag(R.id.idViewPagerItem));
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
