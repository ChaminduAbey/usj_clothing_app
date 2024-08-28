package com.example.clothingapp.model;

public class Product {
    private  String id;
    private  String name;
    private  String image;
    private int price;
    private String subCategoryId;





    public Product(String id, String name, String image,int price,String subCategoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.subCategoryId = subCategoryId;
    }

    public  String getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public  String getImage() {
        return image;
    }
    public int getPrice() {
        return price;
    }
    public String getSubCategoryId() {
        return subCategoryId;
    }



}
