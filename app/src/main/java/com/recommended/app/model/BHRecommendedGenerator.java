package com.recommended.app.model;

import com.burgerhack.multicycler.model.RowBehaviour;
import com.recommended.app.core.DataHelper;
import com.recommended.app.core.FireBaseDataProvider;
import com.recommended.app.network.AsyncListener;
import com.recommended.app.network.FireBaseDataProviderImpl;
import com.recommended.app.utils.ui.multicycler.model.RecommendedCategory;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.ArrayList;
import java.util.List;

public class BHRecommendedGenerator {

    private static BHRecommendedGenerator mBhRecommendedGenerator;
    private static List<Product> mAllProducts;

    public static BHRecommendedGenerator getInstance() {
        if (mBhRecommendedGenerator == null) {
            synchronized (BHRecommendedGenerator.class) {
                mBhRecommendedGenerator = new BHRecommendedGenerator();
            }
        }
        return mBhRecommendedGenerator;
    }

    private void getAllProducts(final AsyncListener<List<Product>> asyncListener) {
        if (mAllProducts == null) {
            FireBaseDataProvider provider = new FireBaseDataProviderImpl();
            provider.getAllProducts(new AsyncListener<List<Product>>() {
                @Override
                public void onResponse(Exception exception, List<Product> response) {
                    mAllProducts = response;
                    asyncListener.onResponse(exception,response);
                }
            });
        } else {
            //process data and return via asynclistener
            asyncListener.onResponse(null, mAllProducts);
        }
    }

    public void getHomeScreenContent(final AsyncListener<List<RowBehaviour>> asyncListener) {
        getAllProducts(new AsyncListener<List<Product>>() {
            @Override
            public void onResponse(Exception exception, List<Product> products) {
                mAllProducts = products;
                List<RowBehaviour> recommendedCategories = new ArrayList<>();
                recommendedCategories.add(getRecommendedContent());
                recommendedCategories.add(getTrendingContent());
                recommendedCategories.add(getYouMayLikeContent());
                asyncListener.onResponse(exception, recommendedCategories);
            }
        });
    }

    public void getRecentsList(final AsyncListener<List<RecommendedItem>> asyncListener) {
        getAllProducts(new AsyncListener<List<Product>>() {
            @Override
            public void onResponse(Exception exception, List<Product> products) {
                List<Product> filteredRecentList = DataHelper.getInstance().getRecentProducts(products);
                List<RecommendedItem> recentList = getItemsList(filteredRecentList);
                asyncListener.onResponse(exception, recentList);
            }
        });
    }

    public void getFavoritesList(final AsyncListener<List<RecommendedItem>> asyncListener) {
        getAllProducts(new AsyncListener<List<Product>>() {
            @Override
            public void onResponse(Exception exception, List<Product> products) {
                List<Product> filteredFavoriteItems = DataHelper.getInstance().getFavouriteProducts(products);
                List<RecommendedItem> favoriteItems = getItemsList(filteredFavoriteItems);
                asyncListener.onResponse(exception, favoriteItems);
            }
        });
    }

    public void getBrowseHistory(final AsyncListener<List<RecommendedItem>> asyncListener) {
        getAllProducts(new AsyncListener<List<Product>>() {
            @Override
            public void onResponse(Exception exception, List<Product> products) {
                List<Product> filteredBrowseItems = DataHelper.getInstance().getRecentProducts(products);
                List<RecommendedItem> browseItems = getItemsList(filteredBrowseItems);
                asyncListener.onResponse(exception, browseItems);
            }
        });
    }

    private RecommendedCategory getRecommendedContent() {
        RecommendedCategory category = new RecommendedCategory();
        category.setCategory("recommended");
        category.setLayoutId(1);
        category.setSeeAll(false);
        category.setTitle("Recommended For You");
        List<Product> filteredRecommendedProducts = DataHelper.getInstance().getRecommendedProducts(mAllProducts);
        category.setRecommendedItems(getItemsList(filteredRecommendedProducts));
        return category;
    }

    private RecommendedCategory getTrendingContent() {
        RecommendedCategory category = new RecommendedCategory();
        category.setCategory("trending");
        category.setLayoutId(1);
        category.setSeeAll(false);
        category.setTitle("Trending Macs");
        List<Product> filteredTrendingProducts = DataHelper.getInstance().getTrendingProducts(mAllProducts);
        category.setRecommendedItems(getItemsList(filteredTrendingProducts));
        return category;
    }

    private RecommendedCategory getYouMayLikeContent() {
        RecommendedCategory category = new RecommendedCategory();
        category.setCategory("ymal");
        category.setLayoutId(1);
        category.setSeeAll(false);
        category.setTitle("You May Also Like");
        List<Product> filteredYAMLItems = DataHelper.getInstance().getTrendingProducts(mAllProducts);
        category.setRecommendedItems(getItemsList(filteredYAMLItems));
        return category;
    }

    private ArrayList<RecommendedItem> getItemsList(List<Product> productList) {
        ArrayList<RecommendedItem> recommendedItems = new ArrayList<>();
        for (Product recommendedProduct : productList) {
            RecommendedItem recommendedItem = new RecommendedItem(recommendedProduct.getProductId(),
                    recommendedProduct.getImageUrl(),
                    recommendedProduct.getProductName(),
                    recommendedProduct.getCalories(),
                    recommendedProduct.getRating()
                    );
            recommendedItems.add(recommendedItem);
        }
        return recommendedItems;
    }
}
