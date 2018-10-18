package com.recommended.app.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.burgerhack.core.ui.customfontview.TextViewYMBold;
import com.burgerhack.core.ui.BaseFragment;
import com.burgerhack.multicycler.MultiRecycler;
import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.recommended.app.R;
import com.recommended.app.model.BHRecommendedGenerator;
import com.recommended.app.network.AsyncListener;
import com.recommended.app.utils.ui.multicycler.BHMulticylerFactory;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.List;


public class DetailFragment extends BaseFragment implements OnMultiCyclerItemClickListener,AsyncListener<List<RowBehaviour>> {

    MultiRecycler mMultiRecycler;
    RecommendedItem mRecommendedItem;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMultiRecycler = view.findViewById(R.id.rvCrossSell);
        mMultiRecycler.setMultiCyclerData(new BHMulticylerFactory(), this);
        executeWebService();
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

    @Override
    public void onMultiCyclerItemClick(View view, CellBehaviour cellItem) {

    }

    @Override
    public void onResponse(Exception exception, List<RowBehaviour> response) {
        mMultiRecycler.addData(response);
    }

    private void executeWebService() {
        showStatus(STATUS.STATUS_LOADING);
        BHRecommendedGenerator.getInstance().customerAlsoBought(this);
    }
}