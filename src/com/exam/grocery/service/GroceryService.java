package com.exam.grocery.service;

import com.exam.grocery.entity.Product;

import java.util.List;

public interface GroceryService {

    Product getBulkPrice(Product product);
    List<Product> getCheckoutProducts(List<Product> cartProducts);
    Double getTotalPrice(List<Product> checkedOutProduct);
    void printReceipt(List<Product> checkedOutProduct, double totalPrice);
}
