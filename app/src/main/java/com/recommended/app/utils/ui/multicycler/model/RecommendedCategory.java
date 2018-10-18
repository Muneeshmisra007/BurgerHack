package com.recommended.app.utils.ui.multicycler.model;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.adapters.CellAdapter;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.burgerhack.multicycler.modelservices.DataList;

import java.util.ArrayList;

public class RecommendedCategory implements RowBehaviour {
    public String category;
    public String title;
    public boolean isSeeAll;
    int layoutId;

    public ArrayList<RecommendedItem> recommendedItems;

    public void setRecommendedItems(ArrayList<RecommendedItem> recommendedItems) {
        this.recommendedItems = recommendedItems;
    }

    private transient CellAdapter recylerCellAdapter;

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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSeeAll(boolean seeAll) {
        isSeeAll = seeAll;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public CellAdapter getRecylerCellAdapter() {
        return recylerCellAdapter;
    }

    public void setRecylerCellAdapter(CellAdapter recylerCellAdapter) {
        this.recylerCellAdapter = recylerCellAdapter;
    }
}
