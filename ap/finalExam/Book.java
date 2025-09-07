package ap.finalExam;

public class Book extends Product{

    private String title, author;

    public Book(ProductType productName, long price, String title, String author) {

        super(productName, price);

        this.title = title;
        this.author = author;

    }

    public String toString() {

        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';

    }

}
