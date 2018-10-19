package com.recommended.app.core;

import com.recommended.app.model.Product;
import com.recommended.app.utils.ui.multicycler.model.RecommendedItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muneesh on 18/10/18.
 */

public class DataHelper {

    private static DataHelper sInstance;

    public static synchronized DataHelper getInstance() {
        if (sInstance == null) {
            synchronized (DataHelper.class) {
                sInstance = new DataHelper();
            }
        }
        return sInstance;
    }

    private DataHelper() {

    }

    public List<Product> getRecentProducts(List<Product> list) {
        List<Product> recentList = new ArrayList<>();
        for (Product product : list) {
            if (product.isIsRecent()) {
                recentList.add(product);
            }
        }
        return recentList;

    }

    public List<Product> getFavouriteProducts(List<Product> list) {
        List<Product> favouriteList = new ArrayList<>();
        for (Product product : list) {
            if (product.isIsFavourite()) {
                favouriteList.add(product);
            }
        }
        return favouriteList;

    }

    public List<Product> getTrendingProducts(List<Product> list) {
        List<Product> trendingProducts = new ArrayList<>();
        for (Product product : list) {
            if (product.isIsTrending()) {
                trendingProducts.add(product);
            }
        }
        return trendingProducts;
    }

    public List<Product> getCrossSellProducts(RecommendedItem recommendedItem, List<Product> list) {
        ArrayList<String> crossSellProductsList = recommendedItem.getCrossSellProducts();
        List<Product> crossSellProducts = new ArrayList<>();
        for (Product product : list) {
            for (String crossProductID : crossSellProductsList) {
                if (product.getProductId().equalsIgnoreCase(crossProductID)) {
                    crossSellProducts.add(product);
                    break;
                }
            }
        }
        return crossSellProducts;
    }

    public List<Product> getRecommendedProducts(List<Product> list) {
        //top
//        List<Product> recommended = new ArrayList<>();
//        recommended.addAll(getTrendingProducts(list).subList(0, 1));
//        recommended.addAll(getFavouriteProducts(list).subList(0, 1));
//        recommended.addAll(getRecentProducts(list).subList(0, 1));
        return list;

    }

}
