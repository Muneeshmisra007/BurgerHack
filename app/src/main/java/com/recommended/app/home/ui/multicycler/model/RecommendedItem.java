package com.recommended.app.home.ui.multicycler.model;

import com.burgerhack.multicycler.model.CellBehaviour;

/**
 * Created by Muneesh on 16/10/18.
 */

public class RecommendedItem implements CellBehaviour {
    public String id;
    public String imageUrl;
    public String title;

    public RecommendedItem(String id, String imageUrl, String title, boolean energyInfo) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.energyInfo = energyInfo;
    }

    public boolean energyInfo;

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public boolean isEnergyInfo() {
        return energyInfo;
    }
}
