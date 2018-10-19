package com.recommended.app.utils.ui.multicycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.viewholder.CellViewHolder;
import com.burgerhack.multicycler.viewholder.RowViewHolder;
import com.recommended.app.R;
import com.recommended.app.utils.ui.multicycler.holder.NormalCellViewHolder;
import com.recommended.app.utils.ui.multicycler.holder.NormalRowViewHolder;
import com.recommended.app.utils.ui.multicycler.holder.SliderRowViewHolder;

/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class BHMulticylerFactory extends MultiRecyclerViewFactory {

    @Override
    public View getRowView(ViewGroup parent, int rowID) {

        LayoutType type = LayoutType.getType(rowID);

        switch (type) {
            case LAYOUT_HEADER:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_view_pager, parent, false);
            case LAYOUT_BANNER:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_view_pager, parent, false);
            case LAYOUT_NONE://${Fall-Through}
            case LAYOUT_NORMAL:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recyler_normal_row, parent, false);

        }
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recyler_normal_row, parent, false);
    }

    @Override
    public RowViewHolder getRowViewHolder(View itemView, int rowID) {

        final LayoutType type = LayoutType.getType(rowID);
        switch (type) {
            case LAYOUT_BANNER:
                return new SliderRowViewHolder(itemView);

            case LAYOUT_NORMAL:
                return new NormalRowViewHolder(itemView);
        }
        return null;
    }

    @Override
    public View getCellView(ViewGroup parent, int rowID) {

        LayoutType type = LayoutType.getType(rowID);

        switch (type) {
            case LAYOUT_NONE://${Fall-Through}
            case LAYOUT_NORMAL:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recyler_normal_cell, parent, false);

        }
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recyler_normal_cell, parent, false);

    }

    @Override
    public CellViewHolder getCellViewHolder(View itemView, int rowID) {


        final LayoutType type = LayoutType.getType(rowID);

        switch (type) {
            case LAYOUT_NONE://${Fall-Through}
            case LAYOUT_NORMAL:
                return new NormalCellViewHolder(itemView);
        }
        return new NormalCellViewHolder(itemView);
    }

    public enum LayoutType {
        LAYOUT_NONE(0),
        LAYOUT_NORMAL(1),
        LAYOUT_BANNER(2);

        private int mType;

        LayoutType(int type) {
            mType = type;
        }

        public static LayoutType getType(int type) {
            if (type == LAYOUT_NONE.getCode()) {
                return LAYOUT_NONE;
            } else if (type == LAYOUT_BANNER.getCode()) {
                return LAYOUT_BANNER;
            } else if (type == LAYOUT_NORMAL.getCode()) {
                return LAYOUT_NORMAL;
            }
            return LAYOUT_NORMAL;
        }

        public int getCode() {
            return mType;
        }

    }

}
