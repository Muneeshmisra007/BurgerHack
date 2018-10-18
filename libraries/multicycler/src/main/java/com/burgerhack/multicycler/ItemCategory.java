package com.burgerhack.multicycler;

/**
 * Created by Amritpal Singh on 28/09/2016.
 */
public enum ItemCategory {
    UNKNOWN(1);

    private int mType;

    private ItemCategory(int type) {
        mType = type;
    }

    public static ItemCategory getCategory(String category) {
        return UNKNOWN;
    }

    public static ItemCategory getCategory(int code) {
        for (ItemCategory itemCategory : values()) {
            if (itemCategory.getCategoryCode() == code) {
                return itemCategory;
            }
        }
        return ItemCategory.UNKNOWN;
    }

    public int getCategoryCode() {
        return mType;
    }
}
