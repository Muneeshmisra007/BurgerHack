package com.recommended.app.utils.ui.multicycler.model;

import com.burgerhack.multicycler.model.CellBehaviour;

/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class RecommendedItem implements CellBehaviour {
    public String id;
    public String imageUrl;
    public String title;
    private int calories;
    private float rating;

    public RecommendedItem(String id, String imageUrl, String title, int calories, float rating) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.calories = calories;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
