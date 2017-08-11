package com.xramos.genericadaptersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xramos.genericadaptersample.R;

public class StringMainActivity extends AppCompatActivity {

    private Button btnStringAdapter;
    private Button btnStringRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_main);
        btnStringAdapter = (Button)findViewById(R.id.btnStringAdapter);
        btnStringAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StringMainActivity.this, StringAdapterActivity.class);
                startActivity(intent);
            }
        });
        btnStringRecycler = (Button)findViewById(R.id.btnStringRecycler);
        btnStringRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StringMainActivity.this, StringRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
