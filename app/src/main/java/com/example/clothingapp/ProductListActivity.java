package com.example.clothingapp;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clothingapp.adapters.ProductListActivityAdapter;

public class ProductListActivity extends AppCompatActivity {

    private GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gridView = findViewById(R.id.gridview1);
//        ProductListActivityAdapter adapter = new ProductListActivityAdapter(this, imageIds);
//        gridView.setAdapter(adapter);
    }
}
