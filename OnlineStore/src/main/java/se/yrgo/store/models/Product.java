package se.yrgo.store.models;

public class Product {
    int productId;
    String name;
    double price;
    int quantity;

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
