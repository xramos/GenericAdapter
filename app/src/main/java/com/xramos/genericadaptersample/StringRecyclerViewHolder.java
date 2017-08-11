package com.xramos.genericadaptersample;

import android.view.View;
import android.widget.TextView;

import com.xramos.genericadapter.viewholders.GenericViewHolder;

/**
 * Created by xavi on 11/8/17.
 */

public class StringRecyclerViewHolder extends GenericViewHolder<String> {

    public TextView textView;

    public StringRecyclerViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.txtElementStringRecycler);
    }

    @Override
    public void bind(String model) {
        textView.setText(model);
    }
}
