package com.xramos.genericadaptersample;

import android.view.View;
import android.widget.TextView;

import com.xramos.genericadapter.viewholders.GenericViewHolder;

/**
 * Created by xavi on 11/8/17.
 */

public class StringAdapterViewHolder extends GenericViewHolder<String> {

    private TextView txtElementStringAdapter;

    public StringAdapterViewHolder(View itemView) {
        super(itemView);
        txtElementStringAdapter = (TextView)itemView.findViewById(R.id.txtElementStringAdapter);
    }

    @Override
    public void bind(String model) {
        txtElementStringAdapter.setText(model);
    }
}
