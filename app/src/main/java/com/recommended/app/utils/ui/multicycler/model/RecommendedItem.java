package com.recommended.app.utils.ui.multicycler.model;

import com.burgerhack.multicycler.model.CellBehaviour;

/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class RecommendedItem implements CellBehaviour {
    public String id;
    public String imageUrl;
    public String title;
    public int energyInfo;

    public RecommendedItem(String id, String imageUrl, String title, int energyInfo) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.energyInfo = energyInfo;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getEnergyInfo() {
        return energyInfo;
    }
}
