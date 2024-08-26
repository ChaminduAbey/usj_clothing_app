package com.example.clothingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.clothingapp.adapters.MainActivityProductCategoryAdapter;
import com.example.clothingapp.model.ProductCategory;
import com.example.clothingapp.data.ProductCategoryData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<ProductCategory> productCategories = ProductCategoryData.getAllProductCategories();

        listView = findViewById(R.id.listview);

        MainActivityProductCategoryAdapter productCategoryAdapter = new MainActivityProductCategoryAdapter(this, R.layout.product_category_card, productCategories);

        listView.setAdapter(productCategoryAdapter);
    }


}