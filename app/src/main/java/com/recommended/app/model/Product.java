package com.recommended.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muneesh on 18/10/18.
 */

public class Product {

    private String productId;
    private String imageUrl;
    private String categoryId;
    private ArrayList<String> crossSellProducts;
    private String productName;
    private boolean isTrending;
    private boolean isFavourite;
    private boolean isRecommended;
    private int viewCount;
    private ArrayList<Integer> dayParts;
    private int calories;
    private float rating;

    public Product() {
    }


    public ArrayList<String> getCrossSellProducts() {
        return crossSellProducts;
    }

    public void setCrossSellProducts(ArrayList<String> crossSellProducts) {
        this.crossSellProducts = crossSellProducts;
    }

    public ArrayList<Integer> getDayParts() {
        return dayParts;
    }

    public void setDayParts(ArrayList<Integer> dayParts) {
        this.dayParts = dayParts;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isTrending() {
        return isTrending;
    }

    public void setTrending(boolean trending) {
        isTrending = trending;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }



    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String toString() {
        return "Product: " + productId +
                "\n" + imageUrl +
                "\n" + categoryId +
                "\n" + crossSellProducts +
                "\n" + productName +
                "\n" + isTrending +
                "\n" + isFavourite +
                "\n" + isRecommended +
                "\n" + viewCount +
                "\n" + dayParts.toString() +
                "\n" + calories +
                "\n" + rating;
    }
}
