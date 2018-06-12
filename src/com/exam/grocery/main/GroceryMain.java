package com.exam.grocery.main;

import com.exam.grocery.entity.Product;
import com.exam.grocery.service.GroceryService;
import com.exam.grocery.service.impl.GroceryServiceImpl;

import java.util.Arrays;
import java.util.List;

public class GroceryMain {

    public static void main(String []args) {
        GroceryService service = new GroceryServiceImpl();
        //Define List of Product on Cart
        List<Product> cartProducts =
                Arrays.asList(new Product("Fanta", 10.0,true,0.0,false, 0.0),
                              new Product("Lays", 120.0,true,0.0,true, 0.0),
                              new Product("Coffee Bean", 150.0,false,2.0,false, 0.0),
                              new Product("Baking Powder", 50.0,false,1.0,false, 0.0),
                              new Product("Lays", 120.0,true,0.0,true, 0.0));

        //Check If there are product that are on promo
        List<Product> checkedOutProduct = service.getCheckoutProducts(cartProducts);

        //Check if there are weighted products on the cart
        checkedOutProduct.forEach(product -> {
            if(!product.isRetail()){
                service.getBulkPrice(product);
            }
        });

        // calculate and print the receipt
        service.printReceipt(checkedOutProduct,service.getTotalPrice(checkedOutProduct));

    }
}
