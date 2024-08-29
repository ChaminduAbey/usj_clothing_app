package com.example.clothingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.clothingapp.adapters.MainActivityProductCategoryAdapter;
import com.example.clothingapp.adapters.SubCategoryListActivityAdapter;
import com.example.clothingapp.data.ProductCategoryData;
import com.example.clothingapp.data.ProductSubCategoryData;
import com.example.clothingapp.model.ProductCategory;
import com.example.clothingapp.model.ProductSubCategory;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubCategoryListActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category_list);

        // Set the list view
        listView = findViewById(R.id.listview);

        // Get the id of the product category
        String id = getIntent().getStringExtra("id");

        // Get the product category
        ProductCategory productCategory = ProductCategoryData.getProductCategoryById(id);

        // // Set the title of the activity to the name of the product category
        TextView titleTxtView = findViewById(R.id.titleTxtView);
        titleTxtView.setText(productCategory.getName());

        // Get the sub categories of the product category
        List<ProductSubCategory> subCategories = ProductSubCategoryData.getAllProductSubCategoriesByCategory(id);

        // Create the adapter
        SubCategoryListActivityAdapter subCategoryListActivityAdapter =
                new SubCategoryListActivityAdapter(this, R.layout.product_category_card, subCategories);

        // Set the adapter
        listView.setAdapter(subCategoryListActivityAdapter);
    }



}