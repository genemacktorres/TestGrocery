package com.exam.grocery.service.impl;

import com.exam.grocery.entity.Product;
import com.exam.grocery.service.GroceryService;

import java.util.ArrayList;
import java.util.List;

public class GroceryServiceImpl implements GroceryService {


    private Double totalPrice = 0.0;

    /**
     *
     * @param product
     * @return product with a weighted price
     */
    @Override
    public Product getBulkPrice(Product product) {
        product.setWightedPrice(product.getPrice() * product.getWeight());
        return product;
    }

    /**
     *
     * @param cartProducts
     * @return Returns an updated productList after validating promo buy one take one
     */
    @Override
    public List<Product> getCheckoutProducts(List<Product> cartProducts) {
        List<Product> checkoutProducts = new ArrayList<>();
        List<String> promoProducts = new ArrayList<>();

        cartProducts.forEach(product -> {
            if (product.isOnPromo()) {
                if (promoProducts.contains(product.getProductName())) {
                    product.setPrice(0.0); // product item set to free;
                } else {
                    promoProducts.add(product.getProductName());
                }
            }
            checkoutProducts.add(product);
        });

        return checkoutProducts;
    }

    /**
     *
     * @param checkedOutProduct
     * @return Returns an total price
     */
    @Override
    public Double getTotalPrice(List<Product> checkedOutProduct) {

        checkedOutProduct.forEach(product -> {
            if (product.getWeight() != 0.0) {
                totalPrice += product.getWeightedPrice();
            } else {
                totalPrice += product.getPrice();
            }
        });

        return totalPrice;
    }

    @Override
    public void printReceipt(List<Product> checkedOutProduct, double totalPrice) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("========Official Receipt=========\n");
        buffer.append("\n");
        checkedOutProduct.forEach(product ->{
            if(product.isRetail()){
                buffer.append(product.getProductName()+" \t\t "+ product.getPrice());
            } else {
                buffer.append(product.getProductName()+" \t\t "+ product.getWeightedPrice());
            }
            buffer.append("\n");
        });
        buffer.append("\n");
        buffer.append("Total"+" \t\t "+ totalPrice);
        buffer.append("\n");
        buffer.append("============== End ==============");
        System.out.println(buffer.toString());
    }
}
