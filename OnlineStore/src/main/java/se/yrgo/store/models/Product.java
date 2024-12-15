package se.yrgo.store.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Product {

    /**
     * class that determines the objects properties.
     */
    private int productId;
    private String name;
    private double price;
    private int stockQuantity;


    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Constructor to initialize a new object.
     */
    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }

    /**
     *
     * @return Method to return total value of a specified product.
     */
    public double totalValue() {
        return price * stockQuantity;
    }

    @Override
    public String toString() {
        return "Product: " + name +
                ", price: " + price + ". ";
    }
}




