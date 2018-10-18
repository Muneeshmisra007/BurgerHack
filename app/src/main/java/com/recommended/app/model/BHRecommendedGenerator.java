package com.recommended.app.model;

import com.burgerhack.multicycler.model.RowBehaviour;
import com.recommended.app.utils.ui.multicycler.model.RecommendedCategory;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.ArrayList;
import java.util.List;

public class BHRecommendedGenerator {

    private static BHRecommendedGenerator mBhRecommendedGenerator;

    public static BHRecommendedGenerator getInstance() {
        if (mBhRecommendedGenerator == null) {
            synchronized (BHRecommendedGenerator.class) {
                mBhRecommendedGenerator = new BHRecommendedGenerator();
            }
        }
        return mBhRecommendedGenerator;
    }

    public List<RowBehaviour> getHomeScreenContent() {
        List<RowBehaviour> recommendedCategories = new ArrayList<>();
        recommendedCategories.add(getRecommendedContent());
        recommendedCategories.add(getTrendingContent());
        recommendedCategories.add(getYouMayLikeContent());
        return recommendedCategories;
    }

    public List<RecommendedItem> getRecentsList() {
        return getItemsList(new ArrayList<Product>());
    }

    public List<RecommendedItem> getFavoritesList() {
        return getItemsList(new ArrayList<Product>());
    }

    public List<RecommendedItem> getBrowseHistory() {
        return getItemsList(new ArrayList<Product>());
    }

    private RecommendedCategory getRecommendedContent() {
        RecommendedCategory category = new RecommendedCategory();
        category.setCategory("recommended");
        category.setLayoutId(1);
        category.setSeeAll(false);
        category.setTitle("Recommended For You");
        List<Product> productsList = new ArrayList<>();
        category.setRecommendedItems(getItemsList(productsList));
        return category;
    }

    private RecommendedCategory getTrendingContent() {
        RecommendedCategory category = new RecommendedCategory();
        category.setCategory("trending");
        category.setLayoutId(1);
        category.setSeeAll(false);
        category.setTitle("Trending Macs");
        List<Product> productsList = new ArrayList<>();
        category.setRecommendedItems(getItemsList(productsList));
        return category;
    }

    private RecommendedCategory getYouMayLikeContent() {
        RecommendedCategory category = new RecommendedCategory();
        category.setCategory("ymal");
        category.setLayoutId(1);
        category.setSeeAll(false);
        category.setTitle("You May Also Like");
        List<Product> productsList = new ArrayList<>();
        category.setRecommendedItems(getItemsList(productsList));
        return category;
    }

    private ArrayList<RecommendedItem> getItemsList(List<Product> productsList) {
        ArrayList<RecommendedItem> recommendedItems = new ArrayList<>();
        for (Product recommendedProduct : productsList) {
            RecommendedItem recommendedItem = new RecommendedItem(recommendedProduct.getProductId(),
                    recommendedProduct.getImageUrl(),
                    recommendedProduct.getProductName(),
                    recommendedProduct.getCalories());
            recommendedItems.add(recommendedItem);
        }
        return recommendedItems;
    }
}
