package com.xramos.genericadaptersample;

import android.content.Context;
import android.view.View;

import com.xramos.genericadapter.adapters.GenericRecyclerAdapter;

import java.util.List;

/**
 * Created by xavi on 11/8/17.
 */

public class StringRecycler extends GenericRecyclerAdapter<String, StringRecyclerViewHolder> {

    public StringRecycler(Context cxt, int layoutId, List<String> objects) {
        super(cxt, layoutId, objects);
    }

    @Override
    public StringRecyclerViewHolder createViewHolder(View itemView) {
        return new StringRecyclerViewHolder(itemView);
    }
}
