package com.recommended.app.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
import com.recommended.app.utils.AppConstants;
import com.recommended.app.utils.ui.multicycler.BHMulticylerFactory;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.List;

import static com.recommended.app.utils.AppConstants.BUNDLE_KEY_PRODUCT;


public class DetailFragment extends BaseFragment implements OnMultiCyclerItemClickListener, AsyncListener<List<RowBehaviour>> {

    MultiRecycler mMultiRecycler;
    RecommendedItem mRecommendedItem;
    TextViewYMBold title;
    TextViewYMBold calories;
    TextViewYMBold rating;
    ImageView productImage;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMultiRecycler = view.findViewById(R.id.rvCrossSell);
        mMultiRecycler.setMultiCyclerData(new BHMulticylerFactory(), this);
        Bundle arguments = getArguments();
        mRecommendedItem = (RecommendedItem) arguments.getSerializable(BUNDLE_KEY_PRODUCT);
        initializeLayout(view);
        loadFragmentView();
    }

    private void initializeLayout(View view) {
        showStatus(STATUS.STATUS_SUCCESS);
        title = view.findViewById(R.id.tvTitle);
        calories = view.findViewById(R.id.tvCal);
        rating = view.findViewById(R.id.tvRating);
        productImage = view.findViewById(R.id.imgImage);
        view.setOnClickListener(null);
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
        RecommendedItem recommendedItem = (RecommendedItem)cellItem;
        mRecommendedItem = recommendedItem;
        loadFragmentView();

    }

    private void setDetailData()
    {
        if (mRecommendedItem != null) {
            title.setText(mRecommendedItem.getTitle());
            rating.setText(mRecommendedItem.getRating() + "");
            calories.setText(mRecommendedItem.getCalories() + " Cal");
            Glide.with(this).load(mRecommendedItem.getImageUrl()).
                    placeholder(R.drawable.default_placeholder).into(productImage);
        }
    }

    private void loadFragmentView()
    {
        setDetailData();
        executeWebService();
    }

    @Override
    public void onResponse(Exception exception, List<RowBehaviour> response) {
        showStatus(STATUS.STATUS_SUCCESS);
        mMultiRecycler.resetAdapterWith(response);
    }

    private void executeWebService() {
        showStatus(STATUS.STATUS_LOADING);
        BHRecommendedGenerator.getInstance().customerAlsoBought(mRecommendedItem, this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}