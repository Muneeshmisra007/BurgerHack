package com.recommended.app.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.burgerhack.core.ui.customfontview.TextViewYMBold;
import com.burgerhack.core.ui.BaseFragment;
import com.recommended.app.R;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;


public class DetailFragment extends BaseFragment {

    RecyclerView mRecommededAdapter;
    RecommendedItem mRecommendedItem;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecommededAdapter = view.findViewById(R.id.rvCrossSell);
        mRecommededAdapter.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecommededAdapter.setHasFixedSize(false);
        //mRvFavorite.setAdapter(new RecommendedGridAdapter(new ArrayList<ParkingItem>()));
        mRecommededAdapter.setNestedScrollingEnabled(false);
        initializeLayout(view);
    }

    private void initializeLayout(View view) {
        TextViewYMBold title= view.findViewById(R.id.tvTitle);
        TextViewYMBold calories= view.findViewById(R.id.tvCal);
        TextViewYMBold rating= view.findViewById(R.id.tvRating);
        ImageView productImage=view.findViewById(R.id.imgImage);
        if(mRecommendedItem!=null) {
            title.setText(mRecommendedItem.title);
            rating.setText(mRecommendedItem.getRating() + "");
            calories.setText(mRecommendedItem.getCalories() + " Cal");
            Glide.with(this).load(mRecommendedItem.getImageUrl()).
                    placeholder(R.drawable.default_placeholder).into(productImage);

        }
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_detail;
    }


    @Override
    protected int getContainerViewGroupId() {
        return R.id.rvProductDetails;
    }

    @Override
    protected void refreshActiveFragment() {

    }
}