package ap.trainingCodes.quiz;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Pen> pens = new ArrayList<>();

        books.add(new Book("kimiaghar", 1000, 20));
        books.add(new Book("Animal farm", 2000, 3));

        pens.add(new Pen("kian", 1000, Color.BLUE, 23));
        pens.add(new Pen("panter", 2000, Color.RED, 33));

        for(Book i : books){
            System.out.println(i.getName());
            System.out.println(i.getPrice());
            System.out.println(i.getDiscount());
            System.out.println("final price=" +(i.getPrice()- i.getDiscount()));
        }

        for(Pen j : pens){
            System.out.println(j.getBrand());
            System.out.println(j.getPrice());
            System.out.println(j.getColor());
        }

    }
}
