package se.yrgo.store.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the information needed to setup a customer,
 * complete a purchase and view order history
 * @author Malin Sundberg
 */
public class Customer {
    private String name;
    private String email;
    private List<Product> orderhistory;

    public Customer(String name, String email) {
        this.name = name;
        if(email != null && email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Not a valid email address.");
        }
        this.orderhistory = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orderhistory=" + orderhistory +
                '}';
    }

    /**
     * getOrderhistory allows the user to reach all of the previous purchases from a customer.
     * @returns a List of products
     */
    public List<Product> getOrderhistory() {
        return new ArrayList<>(orderhistory);
    }

    /**
     * the placeOrder method allows the user to take a ShoppingCart as a parameter
     * and it's contents to finalize a purchase.
     * @param cart
     */
    public void placeOrder(ShoppingCart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Your cart is empty.");
        }
        orderhistory.addAll(cart.getProducts());
    }


}
