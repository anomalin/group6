package se.yrgo.store.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
Customer testCustomer = new Customer("Malin Sundberg", "malin@sundberg.se");
Product testProduct = new Product(1, "Sweater", 500, 1);
Product testProduct2 = new Product(2, "Pants", 600, 1);
ShoppingCart testCart = new ShoppingCart();
List<Product> testOrderhistory = new ArrayList<>();

    @Test
    public void placeOrderTest() {
        testCart.addProduct(testProduct);
        testCart.addProduct(testProduct2);
        testCustomer.placeOrder(testCart);
        testOrderhistory.addAll(testCart.getProducts());
        List<Product> expected = new ArrayList<>(List.of(testProduct, testProduct2));
        assertEquals(expected, testOrderhistory);
        assertEquals(2, testOrderhistory.size());

    }

    @Test
    public void getOrderhistoryTest() {
        List<Product> expected = new ArrayList<>();
        expected.add(testProduct);
        expected.add(testProduct2);
        expected.add(testProduct);
        testCart.addProduct(testProduct);
        testCart.addProduct(testProduct2);
        testCustomer.placeOrder(testCart);
        ShoppingCart testCart2 = new ShoppingCart();
        testCart2.addProduct(testProduct);
        testCustomer.placeOrder(testCart2);
        List<Product> actual = testCustomer.getOrderhistory();
        assertEquals(expected, actual);
        assertIterableEquals(expected, actual);
        assertEquals(3, actual.size());

    }

    @Test
    public void customerWithInvalidEmailTest() {
        assertThrows(IllegalArgumentException.class, () -> new Customer("Malin", "malinsundberg.se"));
    }
}
