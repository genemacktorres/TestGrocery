package com.exam.grocery.service.impl;

import com.exam.grocery.entity.Product;
import com.exam.grocery.service.GroceryService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GroceryServiceImplTest {


    GroceryService service;

    @Before
    public void start(){
       service = new GroceryServiceImpl();
    }

    @Test
    public void testCheckOutRetailProduct() {
        List<Product> cartProducts =
                Arrays.asList(new Product("Fanta", 10.0,true,0.0,false, 0.0),
                        new Product("Lays", 120.0,true,0.0,false, 0.0));

        assertTrue(service.getTotalPrice(cartProducts) == 130.0);
    }

    @Test
    public void testCheckOutWeightedProducts() {
        List<Product> cartProducts =
                Arrays.asList(new Product("Coffee Bean", 150.0,false,2.0,false, 0.0),
                        new Product("Baking Powder", 50.0,false,1.0,false, 0.0));

        List<Product> checkOutProducts = new ArrayList<>();

        cartProducts.forEach(product -> {
            if(!product.isRetail()){
                checkOutProducts.add(service.getBulkPrice(product));
            }
        });
        assertTrue(service.getTotalPrice(checkOutProducts) == 350.0);
    }

    @Test
    public void testCheckOutRetailProductOnPromo() {
        List<Product> cartProducts =
                Arrays.asList(new Product("Fanta", 10.0,true,0.0,true, 0.0),
                        new Product("Lays", 120.0,true,0.0,false, 0.0),
                        new Product("Fanta", 10.0,true,0.0,true, 0.0));


        List<Product> checkOutProduct = service.getCheckoutProducts(cartProducts);
        assertTrue(service.getTotalPrice(checkOutProduct) == 130.0);
    }

    @Test
    public void testPrintReceipt(){
        List<Product> cartProducts =
                Arrays.asList(new Product("Fanta", 10.0,true,0.0,false, 0.0),
                        new Product("Lays", 120.0,true,0.0,false, 0.0));
        double total = service.getTotalPrice(cartProducts);
        service.printReceipt(cartProducts,total);
    }


}