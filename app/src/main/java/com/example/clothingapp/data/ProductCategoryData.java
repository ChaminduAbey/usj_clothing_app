package com.example.clothingapp.data;

import com.example.clothingapp.model.ProductCategory;

import java.util.Arrays;
import java.util.List;

public class ProductCategoryData {
    static final private List<ProductCategory> productCategoryList = Arrays.asList(
            new ProductCategory("category-1", "WOMEN COLLECTION", "@drawable/womenmain"),
                new ProductCategory("category-2", "MEN COLLECTION", "@drawable/men"),
                new ProductCategory("category-3", "KIDS COLLECTION", "@drawable/kids")
        );

   static public List<ProductCategory> getAllProductCategories() {
        return productCategoryList;
    }

    static public ProductCategory getProductCategoryById(String id) {
        return productCategoryList.stream()
                .filter(productCategory -> productCategory.getId().equals(id))
                .findFirst().orElse(null);
    }
}
