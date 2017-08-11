package com.xramos.genericadaptersample;

import android.content.Context;
import android.view.View;

import com.xramos.genericadapter.adapters.GenericAdapter;

import java.util.List;

/**
 * Created by xramos on 11/8/17.
 */

public class StringAdapter extends GenericAdapter<String, StringAdapterViewHolder> {

    public StringAdapter(Context cxt, int layoutId, List<String> objs) {
        super(cxt, layoutId, objs);
    }

    @Override
    public StringAdapterViewHolder createViewHolder(View itemView) {
        return new StringAdapterViewHolder(itemView);
    }
}
