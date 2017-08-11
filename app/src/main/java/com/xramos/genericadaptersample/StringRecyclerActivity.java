package com.xramos.genericadaptersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xramos.genericadaptersample.R;
import com.xramos.genericadapter.listeners.OnRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

public class StringRecyclerActivity extends AppCompatActivity {

    private RecyclerView stringRecyclerView;
    private StringRecycler stringRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_recycler);
        stringRecyclerView = (RecyclerView)findViewById(R.id.stringRecyclerView);
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
        stringRecycler = new StringRecycler(this, R.layout.element_string_recycler, objects);
        LinearLayoutManager stringLayoutManager = new LinearLayoutManager(this);
        stringRecyclerView.setLayoutManager(stringLayoutManager);
        stringRecyclerView.setAdapter(stringRecycler);
        stringRecyclerView.setHasFixedSize(true);
        stringRecyclerView.addOnScrollListener(new OnRecyclerViewScrollListener(stringLayoutManager) {
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
                stringRecycler.updateObjects(objects);
            }
        });
    }
}
