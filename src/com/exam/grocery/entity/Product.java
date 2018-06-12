package com.exam.grocery.entity;

public class Product {

    private String productName;
    private double price;
    private boolean retail;
    private double weight;
    private boolean onPromo;
    private double weightedPrice;

    public Product() {}

    public Product(String productName, double price, boolean retail, double weight, boolean onPromo, double weightedPrice) {
        this.productName = productName;
        this.price = price;
        this.retail = retail;
        this.weight = weight;
        this.onPromo = onPromo;
        this.weightedPrice = weightedPrice;
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRetail() {
        return retail;
    }

    public void setRetail(boolean retail) {
        this.retail = retail;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isOnPromo() {
        return onPromo;
    }

    public void setOnPromo(boolean onPromo) {
        this.onPromo = onPromo;
    }
    public double getWeightedPrice() {
        return weightedPrice;
    }

    public void setWightedPrice(double weightedPrice) {
        this.weightedPrice = weightedPrice;
    }

}


