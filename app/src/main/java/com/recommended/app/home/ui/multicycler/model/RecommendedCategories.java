package com.recommended.app.home.ui.multicycler.model;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.adapters.CellAdapter;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.burgerhack.multicycler.modelservices.DataList;

import java.util.ArrayList;

public class RecommendedCategories implements RowBehaviour {
    public String category;
    public String title;
    public boolean isSeeAll;
    int layoutId;

    public ArrayList<RecommendedItem> recommendedItems;

    public void setRecommendedItems(ArrayList<RecommendedItem> recommendedItems) {
        this.recommendedItems = recommendedItems;
    }

    private transient CellAdapter recylerCellAdapter;

    /*public class RecommendedItem implements CellBehaviour {
        @SerializedName("id")
        public String id;
        @SerializedName("imageUrl")
        public String imageUrl;
        @SerializedName("title")
        public String title;

        public RecommendedItem(String id, String imageUrl, String title, boolean energyInfo) {
            this.id = id;
            this.imageUrl = imageUrl;
            this.title = title;
            this.energyInfo = energyInfo;
        }

        @SerializedName("energyInfo")

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
    }*/

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSeeAll() {
        return isSeeAll;
    }

    public ArrayList<RecommendedItem> getRecommendedItems() {
        return recommendedItems;
    }

    public int getLayoutId() {
        return layoutId;
    }

    @Override
    public int getRowID() {
        return getLayoutId();
    }

    @Override
    public CellAdapter getCellAdapter(MultiRecyclerViewFactory factory,
                                      OnMultiCyclerItemClickListener listener) {
        if (recylerCellAdapter == null) {
            recylerCellAdapter = new CellAdapter(toItemsRow(), factory, getRowID(), listener);
        }
        return recylerCellAdapter;
    }

    private DataList<CellBehaviour> toItemsRow() {
        DataList<CellBehaviour> cellBehaviours = new DataList<>();
        for (RecommendedItem item : getRecommendedItems()) {
            cellBehaviours.add(item);
        }
        return cellBehaviours;
    }
}
