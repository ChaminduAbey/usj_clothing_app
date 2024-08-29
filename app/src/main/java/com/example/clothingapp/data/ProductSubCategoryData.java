package com.example.clothingapp.data;

import com.example.clothingapp.model.ProductSubCategory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSubCategoryData {
    // initialize the product sub categories list
    static final private List<ProductSubCategory> productSubCategoriesList =
            Arrays.asList(
                    new ProductSubCategory("sub-category-1", "CASUAL WEAR COLLECTION", "@drawable/subcategory_bg_women_casual", "category-1"),
                    new ProductSubCategory("sub-category-2", "FORMAL WEAR COLLECTION", "@drawable/subcategory_bg_women_formal", "category-1"),
                    new ProductSubCategory("sub-category-3", "PARTY WEAR COLLECTION", "@drawable/subcategory_bg_women_party", "category-1"),
                    new ProductSubCategory("sub-category-4", "FORMAL WEAR COLLECTION", "@drawable/subcategory_bg_men_formal", "category-2"),
                    new ProductSubCategory("sub-category-5", "SPORTS WEAR COLLECTION", "@drawable/subcategory_bg_men_sports", "category-2"),
                    new ProductSubCategory("sub-category-6", "SHOES COLLECTION", "@drawable/subcategory_bg_men_shoes", "category-2"),
                    new ProductSubCategory("sub-category-7", "BAGS COLLECTION", "@drawable/subcategory_bg_kids_bag", "category-3"),
                    new ProductSubCategory("sub-category-8", "WATCHES COLLECTION", "@drawable/subcategory_bg_kids_watches", "category-3"),
                    new ProductSubCategory("sub-category-9", "BOOKS COLLECTION", "@drawable/subcategory_bg_kids_books", "category-3")
            );

    // get all product sub categories
    static public List<ProductSubCategory> getAllProductSubCategoriesByCategory(String categoryId) {
        return productSubCategoriesList.stream()
                .filter(productSubCategory -> productSubCategory.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }
    // get product sub category by id
    static  public ProductSubCategory getProductSubCategoryById(String id) {
        return productSubCategoriesList.stream()
                .filter(productSubCategory -> productSubCategory.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
