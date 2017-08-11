package com.xramos.genericadapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Generic ViewHolder
 *
 * Created by xramos on 10/8/17.
 */

public abstract class GenericViewHolder<T> extends RecyclerView.ViewHolder {

    /**
     * Constructor
     * @param itemView View
     */
    public GenericViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Method to bind model with view
     * @param model model to bind
     */
    public abstract void bind(T model);
}
