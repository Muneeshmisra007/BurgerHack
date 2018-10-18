package com.burgerhack.multicycler;

import android.view.View;

import com.burgerhack.multicycler.model.CellBehaviour;


/**
 * Created by Amritpal Singh on 19/10/18.
 */
public interface OnMultiCyclerItemClickListener {

    void onMultiCyclerItemClick(View view, CellBehaviour cellItem);
}
