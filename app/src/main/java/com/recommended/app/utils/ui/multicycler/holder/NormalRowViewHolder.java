package com.recommended.app.utils.ui.multicycler.holder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.factory.MultiRecyclerViewFactory;
import com.burgerhack.multicycler.model.RowBehaviour;
import com.recommended.app.R;
import com.recommended.app.utils.ui.multicycler.model.RecommendedCategory;

/**
 * Created by Amritpal Singh on 19/10/18.
 */

public class NormalRowViewHolder extends BaseRecylerRowViewHolder {

    public NormalRowViewHolder(View itemView) {
        super(itemView);
        RecyclerView cellRecyler = findRecyclerView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(super.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        cellRecyler.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void bind(RowBehaviour row, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener) {
        RecommendedCategory category = (RecommendedCategory) row;
        TextView tvRowTitle = (TextView) itemView.findViewById(R.id.tvRowTitle);
        TextView tvSeeMore = (TextView) itemView.findViewById(R.id.tvSeeMore);

        tvRowTitle.setText(category.getTitle().trim());
        if (category.isSeeAll()) {
            tvSeeMore.setVisibility(View.VISIBLE);
        } else {
            tvSeeMore.setVisibility(View.GONE);
        }

        RecyclerView cellRecyler = findRecyclerView();
        cellRecyler.setAdapter(row.getCellAdapter(factory, listener));
    }

    private RecyclerView findRecyclerView() {
        return (RecyclerView) itemView.findViewById(R.id.rvCellView);
    }
}
