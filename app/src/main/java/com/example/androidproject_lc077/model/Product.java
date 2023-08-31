package com.example.androidproject_lc077.model;

public class Product {

    private int id;
    private String title;
    private Integer price;
    private Integer image;

    private String type;

    public Product(int id, String title, Integer price, Integer image, String type) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.image = image;
        this.type = type;
    }

    public Product(){

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
