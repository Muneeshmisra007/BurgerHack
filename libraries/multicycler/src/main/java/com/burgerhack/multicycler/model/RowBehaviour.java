package com.burgerhack.multicycler.model;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.adapters.CellAdapter;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;

/**
 * Created by Amritpal Singh on 19/10/18.
 */

public interface RowBehaviour {

    int getRowID();

    CellAdapter getCellAdapter(MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener);
}
