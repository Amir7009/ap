package ap.finalExam;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProductTools {

    public static void printProductInfo(ArrayList<Product> products) {

        ArrayList<Product> sortedByPrice = new ArrayList<>(products.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList()));

        for (Product p : sortedByPrice)
            System.out.println("Product Name: " + p.getProductName() + " -- Product Price: " + p.getPrice() + " info: " + p);

    }

}
