package se.yrgo.store.ui;

import se.yrgo.store.models.Customer;
import se.yrgo.store.models.Product;
import se.yrgo.store.models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<Product>();

        Product jeans = new Product(1212, "Jeans", 999.90, 20);
        Product sweater = new Product(1244, "Sweater", 850.00, 20);
        Product underwear = new Product(1313, "Underwear", 199.90, 20);
        Product socks = new Product(2211, "Socks", 99.90, 20);
        Product hoodie = new Product(1344, "Hoodie", 599.00, 20);
        Product tshirt = new Product(1414, "Tshirt", 1500.00, 20);

        products.add(jeans);
        products.add(sweater);
        products.add(underwear);
        products.add(socks);
        products.add(hoodie);
        products.add(tshirt);


        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to the online store!");
            System.out.println("Please register, enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Please write your email address");
            String email = scanner.nextLine();
            Customer customer = new Customer(name, email);
            ShoppingCart cart = new ShoppingCart();
            System.out.println("These are our available products: ");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("Please choose an option, press 0 to exit:");
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. View shopping cart");
            System.out.println("4. See the total cost");
            System.out.println("5. Place an order");
            System.out.println("6. View your order history");

            int choice = scanner.nextInt();

            do {

                switch (choice) {
                    case 1:
                        System.out.println("Add a product to your cart");
                        System.out.println("Please enter the name of the product:");
                        String productName = scanner.nextLine();
                        if (productName.equalsIgnoreCase("jeans")) {
                            cart.addProduct(jeans);
                            System.out.println("Jeans added to cart");
                        } else if (productName.equalsIgnoreCase("sweater")) {
                            cart.addProduct(sweater);
                            System.out.println("Sweater added to cart");
                        } else if (productName.equalsIgnoreCase("underwear")) {
                            cart.addProduct(underwear);
                            System.out.println("Underwear added to cart");
                        } else if (productName.equalsIgnoreCase("socks")) {
                            cart.addProduct(socks);
                            System.out.println("Socks added to cart");
                        } else if (productName.equalsIgnoreCase("hoodie")) {
                            cart.addProduct(hoodie);
                            System.out.println("Hoodie added to cart");
                        } else if (productName.equalsIgnoreCase("tshirt")) {
                            cart.addProduct(tshirt);
                            System.out.println("T-shirt added to cart");
                        } else {
                            System.out.println("Sorry, we can't find the specified item");
                        }
                        break;

                    case 2:
                        System.out.println("Remove a product");
                        System.out.println("Please enter the name of the product:");
                        String productNameR = scanner.nextLine();
                        if (productNameR.equalsIgnoreCase("jeans")) {
                            cart.removeProduct(jeans);
                            System.out.println("Jeans removed from cart");
                        } else if (productNameR.equalsIgnoreCase("sweater")) {
                            cart.removeProduct(sweater);
                            System.out.println("Sweater removed from cart");
                        } else if (productNameR.equalsIgnoreCase("underwear")) {
                            cart.removeProduct(underwear);
                            System.out.println("Underwear removed from cart");
                        } else if (productNameR.equalsIgnoreCase("socks")) {
                            cart.removeProduct(socks);
                            System.out.println("Socks removed from cart");
                        } else if (productNameR.equalsIgnoreCase("hoodie")) {
                            cart.removeProduct(hoodie);
                            System.out.println("Hoodie removed from cart");
                        } else if (productNameR.equalsIgnoreCase("tshirt")) {
                            cart.removeProduct(tshirt);
                            System.out.println("T-shirt removed from cart");
                        } else {
                            System.out.println("Sorry, we can't find the specified item");
                        }
                        break;

                    case 3:
                        System.out.println("View shopping cart");
                        cart.getProducts();
                        System.out.println("Your shopping cart contains: " + products);
                        break;

                    case 4:
                        System.out.println("See the total cost");

                        System.out.println("The total cost is: " + cart.calculateTotalCost());
                        break;

                    case 5:
                        customer.placeOrder(cart);
                        System.out.println("Thank you for shopping with us!");
                        break;

                    case 6:
                        System.out.println("Your order history: " + customer.getOrderhistory());
                        break;

                    default:
                        System.out.println("That was a doozy!");

                }

            }   while (choice != 0);
            System.out.println("Goodbye, hope to see you again!");
        }

    }
}

