package com.example.clothingapp.data;

import com.example.clothingapp.model.ProductCategory;

import java.util.Arrays;
import java.util.List;

public class ProductCategoryData {
    static final private List<ProductCategory> productCategoryList = Arrays.asList(
            new ProductCategory("category-1", "WOMEN COLLECTION", "@drawable/category_bg_women"),
                new ProductCategory("category-2", "MEN COLLECTION", "@drawable/category_bg_men"),
                new ProductCategory("category-3", "KIDS COLLECTION", "@drawable/category_bg_kids")
        );

    // This method returns a list of all product categories
   static public List<ProductCategory> getAllProductCategories() {
        return productCategoryList;
    }

    // This method returns a product category by its id
    static public ProductCategory getProductCategoryById(String id) {
        return productCategoryList.stream()
                .filter(productCategory -> productCategory.getId().equals(id))
                .findFirst().orElse(null);
    }
}
