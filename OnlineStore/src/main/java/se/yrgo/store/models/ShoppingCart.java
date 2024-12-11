package se.yrgo.store.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Damir Dominkovic
 */

/**
 * this class represent a class that holds a list of products
 */
public class ShoppingCart {
    private final List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();

    }

    /**
     * constructor to initialize an empty shopping cart
     */
    public ShoppingCart(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("products cannot be null");
        }
        this.products = new ArrayList<>(products);
    }



    /**
     * adds a product to the shopping cart
     * @param productId is the product to be added to the cart
     */
    public void addProduct(Product productId) {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        products.add(productId);
    }

    /**
     * removes a product from the shopping cart
     * @param productId is the product to be removed from the cart
     * @return returns true if the product was successfully removed and false if not
     */
    public boolean removeProduct(Product productId) {
        return products.remove(productId);
    }

    /**
     * calculating the total cost of products in the shopping cart
     * @return the total cost of all the products in the cart
     */
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Product product : products) {
            totalCost += product.getPrice() * product.getQuantity();
        }
        return totalCost;
    }

    /**
     *
     * @return a list of products currently in the cart
     */
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
