package com.example.clothingapp.data;

import com.example.clothingapp.model.ProductSubCategory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSubCategoryData {
    static final private List<ProductSubCategory> productSubCategoriesList =
            Arrays.asList(
                    new ProductSubCategory("sub-category-1", "Dresses1", "@drawable/casual", "category-1"),
                    new ProductSubCategory("sub-category-2", "Dresses2", "@drawable/casual", "category-1"),
                    new ProductSubCategory("sub-category-3", "Dresses3", "@drawable/casual", "category-1"),
                    new ProductSubCategory("sub-category-4", "Dresses4", "@drawable/casual", "category-1"),
                    new ProductSubCategory("sub-category-5", "CASUAL WEAR COLLECTION", "@drawable/casual", "category-2"),
                    new ProductSubCategory("sub-category-6", "FORMAL WEAR COLLECTION", "@drawable/formalzoomed", "category-2"),
                    new ProductSubCategory("sub-category-7", "SPORTSWEAR COLLECTION", "@drawable/sport", "category-2"),
                    new ProductSubCategory("sub-category-8", "SHOES COLLECTION", "@drawable/shoes", "category-2")
            );

    static public List<ProductSubCategory> getAllProductSubCategoriesByCategory(String categoryId) {
        return productSubCategoriesList.stream()
                .filter(productSubCategory -> productSubCategory.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }
}
