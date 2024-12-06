package se.yrgo.store.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    void calculateValueOfProduct() {
        Product product = new Product(1212, "Jeans", 599.90, 155);
        double result = product.totalValue();
        assertEquals(92984.50, result);
    }
}
