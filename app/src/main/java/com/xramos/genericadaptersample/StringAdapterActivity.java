package com.xramos.genericadaptersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.xramos.genericadapter.listeners.OnListViewScrollListener;

import java.util.ArrayList;
import java.util.List;

public class StringAdapterActivity extends AppCompatActivity {

    private ListView stringAdapterlistView;
    private StringAdapter stringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_adapter);
        stringAdapterlistView = (ListView)findViewById(R.id.stringAdapterlistView);
        final List<String> objects = new ArrayList<>();
        objects.add("One");
        objects.add("Two");
        objects.add("Three");
        objects.add("Four");
        objects.add("Five");
        objects.add("Six");
        objects.add("Seven");
        objects.add("Eight");
        objects.add("Nine");
        objects.add("Ten");
        objects.add("Eleven");
        objects.add("Twelve");
        objects.add("Thirteen");
        objects.add("Fourteen");
        objects.add("Fifteen");
        stringAdapter = new StringAdapter(this, R.layout.element_string_adapter, objects);
        stringAdapterlistView.setAdapter(stringAdapter);
        stringAdapterlistView.setOnScrollListener(new OnListViewScrollListener() {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                objects.add("New Item");
                stringAdapter.updateObjects(objects);
            }
        });
    }
}
