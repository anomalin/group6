package se.yrgo.store.ui;

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


        Scanner scanner = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();



            System.out.println("Welcome to the online store!");
            System.out.println("Please choose an option:");
            System.out.println("1. View available products");
            System.out.println("2. Add a new product");
            System.out.println("3. Remove a product");
            System.out.println("4. View shopping cart");
            System.out.println("5. See the total cost");
            System.out.println("6. Exit to pay");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available products:");
                    for (Product product : products) {
                        System.out.println(product);
                        break;
                    }
                    case 2:
                        System.out.println("Add a new product");
                        System.out.println("Please enter the name of the product:");
                        String name  = scanner.next();
                        cart.addProduct(product);
                        break;

                        case 3:
                            System.out.println("Remove a product");
                            System.out.println("Please enter the name of the product:");
                            String name1 = scanner.nextLine();
                            cart.removeProduct();
                            break;

                            case 4:
                                System.out.println("View shopping cart");
                                cart.getProducts();
                                System.out.println("Your shopping cart contains: " + products);
                                break;

                                case 5:
                                    System.out.println("See the total cost");
                                    cart.calculateTotalCost();
                                    System.out.println("The total cost is: " );
                                    break;

                                    case 6:
                                        System.out.println("Thank you for shopping with us!");


            }
        }

    }

