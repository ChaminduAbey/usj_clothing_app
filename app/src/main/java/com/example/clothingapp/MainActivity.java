package com.example.clothingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.clothingapp.adapters.MainActivityProductCategoryAdapter;
import com.example.clothingapp.model.Product;
import com.example.clothingapp.model.ProductCategory;
import com.example.clothingapp.data.ProductCategoryData;
import com.example.clothingapp.model.ProductSubCategory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the list view
        listView = findViewById(R.id.listview);

        //retrieve product category data
        List<ProductCategory> productCategories = ProductCategoryData.getAllProductCategories();

        //create the adapter
        MainActivityProductCategoryAdapter productCategoryAdapter = new MainActivityProductCategoryAdapter(this, R.layout.product_category_card, productCategories);

        //set the adapter
        listView.setAdapter(productCategoryAdapter);
    }
}