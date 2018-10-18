package com.recommended.app.home.ui.multicycler.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.burgerhack.multicycler.OnMultiCyclerItemClickListener;
import com.burgerhack.multicycler.model.CellBehaviour;
import com.burgerhack.multicycler.viewholder.CellViewHolder;
import com.recommended.app.home.ui.multicycler.model.RecommendedItem;

import com.recommended.app.R;

/**
 * Created by Amritpal Singh on 5/26/17.
 */

public abstract class BaseRecylerCellViewHolder extends CellViewHolder implements View.OnClickListener {
    private OnMultiCyclerItemClickListener listener;
    private RecommendedItem item;

    public BaseRecylerCellViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(CellBehaviour cell, int position, OnMultiCyclerItemClickListener listener) {
        this.listener = listener;
        RecommendedItem stream = (RecommendedItem) cell;
        item = stream;
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgCell);

        TextView tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvTitle.setText(stream.getTitle());

        imageView.setImageDrawable(null);
        Glide.with(itemView.getContext()).load(stream.getImageUrl()).
                placeholder(R.drawable.default_placeholder).into(imageView);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listener.onMultiCyclerItemClick(view, item);
    }
}
