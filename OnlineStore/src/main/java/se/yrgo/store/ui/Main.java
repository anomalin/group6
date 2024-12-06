package se.yrgo.store.ui;

import se.yrgo.store.models.Product;

public class Main {
    public static void main(String[] args) {

        Product jeans = new Product(1212, "Levi's Blue", 999.90, 120);
        Product sweater = new Product(1244, "Lyle & Scott", 850.00, 55);
        Product underwear = new Product(1313, "Calvin Klein", 199.90, 550);
        Product socks = new Product(2211, "Happy socks", 99.90, 220);
        Product hoodie = new Product(1344, "Nike hoodie", 599.00, 85);
        Product tshirt = new Product(1414, "Gucci basic", 1500.00, 20);

        double jeansValue = jeans.totalValue();
        System.out.printf("Total value of Levi's Blue jeans are: %.2f sek\n", jeansValue);

        double sweaterValue = sweater.totalValue();
        System.out.printf("Total value of Lyle & Scott's sweaters are: %.2f sek\n", sweaterValue);

        double underwearValue = underwear.totalValue();
        System.out.printf("Total value of Calvin Kleins underwear are: %.2f sek\n", underwearValue);

        double socksValue = socks.totalValue();
        System.out.printf("Total value of Happy socks are: %.2f sek\n", socksValue);

        double hoodieValue = hoodie.totalValue();
        System.out.printf("Total value of Nike hoodie are: %.2f sek\n", hoodieValue);

        double tshirtValue = tshirt.totalValue();
        System.out.printf("Total value of Gucci basic t-shirt are: %.2f sek\n", tshirtValue);
    }
}
