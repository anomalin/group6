package se.yrgo.store.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart cart;
    private Product product1;
    private Product product2;
    private Product product3;

    /**
     * initializing values to use for each test
     */
    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product(1, "Jeans", 599.90, 1);
        product2 = new Product(2, "Shirt", 649.50, 2);
        product3 = new Product(3, "Undershirt", 149.00, 3);
    }

    /**
     * test for adding products to the cart
     */
    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        List<Product> products = cart.getProducts();

        assertEquals(2, products.size(),
                "Cart should contain 2 products.");
        assertEquals("Jeans", products.get(0).getName(), "First product should be Jeans");
        assertEquals("Shirt", products.get(1).getName(), "Second product should be Shirt.");
    }

    /**
     * test for removing products from the cart
     */
    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        assertTrue(cart.removeProduct(product1), "Removing existing product should return true.");
        List<Product> products = cart.getProducts();
        assertEquals(1, products.size(), "Cart should contain 1 products.");
        assertEquals("Shirt", products.get(0).getName(), "Remaining product should be Shirt.");

        assertFalse(cart.removeProduct(product3), "Removing non-existing product should return false.");

    }

    /**
     * test for calculating the total cost of the cart
     */
    @Test
    public void testCalculateTotalCost() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

        //599.90 + 2*649.50 + 3*149 = 2345.90
        double totalCost = cart.calculateTotalCost();
        assertEquals(2345.90, totalCost, 0.1,"Total cost should be 2345.90");

    }

    /**
     * test to check the products that are in the cart
     */
    @Test
    public void testGetProducts() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        List<Product> products = cart.getProducts();
        assertEquals(2, products.size(), "Cart should contain 2 products.");
        assertEquals("Jeans", products.get(0).getName(), "First product should be Jeans");
        assertEquals("Shirt", products.get(1).getName(), "Second product should be Shirt.");

        //making sure that returned list is a copy
        products.remove(0);
        assertEquals(2, cart.getProducts().size(), "Cart should remain unchanged");
    }

}
