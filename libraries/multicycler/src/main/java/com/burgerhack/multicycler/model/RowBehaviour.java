package com.burgerhack.multicycler.model;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.adapters.CellAdapter;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;

/**
 * Created by Amritpal Singh on 5/13/17.
 */

public interface RowBehaviour {

    int getRowID();

    CellAdapter getCellAdapter(MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener);
}
