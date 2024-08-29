package com.example.clothingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clothingapp.adapters.ProductListActivityAdapter;
import com.example.clothingapp.data.ProductSubCategoryData;
import com.example.clothingapp.model.Product;
import com.example.clothingapp.model.ProductSubCategory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private GridView gridView;
    private LinearLayout loadingIndicatorView;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // Get the subcategory id
        String id = getIntent().getStringExtra("id");

        ProductSubCategory subCategory = ProductSubCategoryData.getProductSubCategoryById(id);

        // Set the title textview
        TextView titleTxtView = findViewById(R.id.titleTxtView);
        titleTxtView.setText(subCategory.getName());

        mDatabase = FirebaseDatabase.getInstance().getReference();
        getProductsFromFirebase(id);

        // Set the grid view
        gridView = findViewById(R.id.gridview);

        //set the loading indicator view
        loadingIndicatorView = findViewById(R.id.progress_bar_layout);
    }

    private void getProductsFromFirebase(String subCategoryId) {
        Log.d("firebase", "Getting products from Firebase");
        mDatabase.child("products").orderByChild("subCategoryId").equalTo(subCategoryId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));

                    List<Product> products = new ArrayList<>();
                    DataSnapshot dataSnapshot = task.getResult();
                    for (DataSnapshot productSnapshot : dataSnapshot.getChildren()) {
                        Product product = productSnapshot.getValue(Product.class);
                        products.add(product);
                    }

                    // Create the adapter
                    ProductListActivityAdapter productListActivityAdapter = new ProductListActivityAdapter(ProductListActivity.this, R.layout.product_card, products);

                    // Set the adapter
                    gridView.setAdapter(productListActivityAdapter);

                    //hide the loading indicator view
                    loadingIndicatorView.setVisibility(View.GONE);

                    //show the gridview
                    gridView.setVisibility(View.VISIBLE);

                }
            }
        });
    }
}
