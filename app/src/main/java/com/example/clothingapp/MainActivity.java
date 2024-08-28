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

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<ProductCategory> productCategories = ProductCategoryData.getAllProductCategories();

        listView = findViewById(R.id.listview);

        MainActivityProductCategoryAdapter productCategoryAdapter = new MainActivityProductCategoryAdapter(this, R.layout.product_category_card, productCategories);

        listView.setAdapter(productCategoryAdapter);
//        FirebaseConnectionChecker firebaseConnectionChecker=new FirebaseConnectionChecker();
//        firebaseConnectionChecker.main(null);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("products");

       // Product subData = new Product("ST01", "pencil pack", "https://firebasestorage.googleapis.com/v0/b/usjclothingapp-4614f.appspot.com/o/pencilPack.webp?alt=media",1650,"sub-category-11");
       // Product subData1 = new Product("BG01", "nick nack bagpack", "https://firebasestorage.googleapis.com/v0/b/usjclothingapp-4614f.appspot.com/o/bagpack.webp?alt=media",2750,"sub-category-12");
        //Product subData2 = new Product("SH01", "leather shoe", "https://firebasestorage.googleapis.com/v0/b/usjclothingapp-4614f.appspot.com/o/shoes.webp?alt=media",10200,"sub-category-8");
//        Product subData3 = new Product("SW01", "Sport pant ", "https://firebasestorage.googleapis.com/v0/b/usjclothingapp-4614f.appspot.com/o/sports-1.webp?alt=media",3500,"sub-category-4");
//        Product subData4 = new Product("SM01", "Sports skinny", "https://firebasestorage.googleapis.com/v0/b/usjclothingapp-4614f.appspot.com/o/sports-b-1.jpg?alt=media",2750,"sub-category-7");
//        myRef.push().setValue(subData);
//        myRef.push().setValue(subData1);




        Query query = myRef.orderByChild("name").equalTo("Danilka");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<ProductCategory>
                newProductCategories = new ArrayList<>(); // Create a new list

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    ProductCategory productCategory = childSnapshot.getValue(ProductCategory.class);
                    newProductCategories.add(productCategory); // Add to the new list
                }

                // Update the adapter with the new list
//                MainActivityProductCategoryAdapter productCategoryAdapter = new MainActivityProductCategoryAdapter(MainActivity.this, R.layout.product_category_card, newProductCategories);
//                listView.setAdapter(productCategoryAdapter);
                System.out.println(newProductCategories.get(0));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Firebase", "Failed to read value.", databaseError.toException());

            }
        });
    }






}