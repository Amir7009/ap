package ap.finalExam;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Book(ProductType.BOOK, 10000, "Animal Farm", "George Orwell"));
        products.add(new Book(ProductType.BOOK, 10000, "Animal Farm", "George Orwell"));
        products.add(new Book(ProductType.BOOK, 10000, "Alchemist", "Paolo"));
        products.add(new Book(ProductType.BOOK, 30000, "Par Parvaz", "Ali Ahadi"));
        products.add(new Pen(ProductType.PEN, 10000, Color.BLUE));
        products.add(new Pen(ProductType.PEN, 20000, Color.RED));


        ProductTools.printProductInfo(products);

    }

}
