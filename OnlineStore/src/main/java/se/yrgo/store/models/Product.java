package se.yrgo.store.models;

public class Product {

    private int productId;
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalValue() {
        double theTotalValue = price * quantity;
        return theTotalValue;
    }
}
