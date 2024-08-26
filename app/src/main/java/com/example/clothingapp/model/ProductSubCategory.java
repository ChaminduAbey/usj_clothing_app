package com.example.clothingapp.model;

public class ProductSubCategory {
    private String id;
    private String name;
    private String image;

    private String categoryId;

    public ProductSubCategory(String id, String name, String image, String categoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getCategoryId() {
        return categoryId;
    }


}
