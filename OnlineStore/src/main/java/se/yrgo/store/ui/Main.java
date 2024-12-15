package se.yrgo.store.ui;

import se.yrgo.store.models.Customer;
import se.yrgo.store.models.Product;
import se.yrgo.store.models.ShoppingCart;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Product> products = new HashMap<>();

        Product jeans = new Product(1212, "Jeans", 999.90, 20);
        Product sweater = new Product(1244, "Sweater", 850.00, 20);
        Product underwear = new Product(1313, "Underwear", 199.90, 20);
        Product socks = new Product(2211, "Socks", 99.90, 20);
        Product hoodie = new Product(1344, "Hoodie", 599.00, 20);
        Product tshirt = new Product(1414, "Tshirt", 1500.00, 20);

        products.put("jeans", jeans);
        products.put("sweater", sweater);
        products.put("underwear", underwear);
        products.put("socks", socks);
        products.put("hoodie", hoodie);
        products.put("tshirt", tshirt);


        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to the online store!");
            System.out.println("Please register, enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Please write your email address");
            String email = scanner.nextLine();
            Customer customer = new Customer(name, email);
            ShoppingCart cart = new ShoppingCart();
            System.out.println("These are our available products: ");
            System.out.println(products);
            System.out.println("Please choose an option, press 0 to exit:");
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. View shopping cart");
            System.out.println("4. See the total cost");
            System.out.println("5. Place an order");
            System.out.println("6. View your order history");

            int choice;

            storeLoop: while (true) {
                System.out.println("What do you want to do? Press 0 to exit.");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                            String productName;
                        do {
                            System.out.println("Add a product to your cart");
                            System.out.println("Please enter the name of the product:");
                            productName = scanner.nextLine().toLowerCase();
                            if (productName.equalsIgnoreCase("0")) {
                                break;
                            }
                            Product productToAdd = products.get(productName);
                            if (productToAdd != null) {
                                cart.addProduct(productToAdd);
                                System.out.println(productName + " added to cart");
                            } else {
                                System.out.println("Sorry, we can't find the specified item in our stock");
                            }
                        } while (!productName.equals("0"));
                        break;
                    case 2:
                        System.out.println("Remove a product");
                        System.out.println("Please enter the name of the product:");
                        String productNameR = scanner.nextLine().toLowerCase();
                        Product productToRemove = products.get(productNameR);
                        if (productToRemove != null) {
                            if (cart.getProducts().contains(productToRemove)) {
                            cart.removeProduct(productToRemove);
                            System.out.println(productNameR + " removed from cart.");
                            } else {
                                System.out.println("Sorry, we can't find the specified item in your cart");
                            }
                        } else {
                                System.out.println("Sorry, we can't find the specified item in our stock.");
                            }
                        break;

                    case 3:
                        System.out.println("View shopping cart");
                        System.out.println("Your shopping cart contains: " + cart.getProducts());
                        break;

                    case 4:
                        System.out.println("See the total cost");

                        System.out.println("The total cost is: " + cart.calculateTotalCost() + " SEK.");
                        break;

                    case 5:
                        customer.placeOrder(cart);
                        System.out.println("Order confirmed! Thank you for shopping with us!");
                        break;

                    case 6:
                        System.out.println("Your order history: " + customer.getOrderhistory());
                        break;
                    case 0:
                        break storeLoop;

                    default:
                        System.out.println("That was a doozy!");
                        continue;

                }

            }
            System.out.println("Goodbye, hope to see you again!");
        }

    }
}

