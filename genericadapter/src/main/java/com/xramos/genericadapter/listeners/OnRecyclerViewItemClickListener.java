package com.xramos.genericadapter.listeners;

import android.view.View;

/**
 * Created by xramos on 10/8/17.
 */

public interface OnRecyclerViewItemClickListener<T> {

    /**
     * Method to handle item click
     * @param view clicked view
     * @param model clicked view model
     */
    void onItemClick(View view, T model);
}


