package ap.midterm_project.models;

import java.util.HashMap;
import java.util.Map;

public class Book{

    private String title, author, pages, year, ISBN;
    boolean isBorrowed; // this can be replaced with book count if we will have duplicated books

    public Book(String title, String author, String pages, String year, String ISBN) {

        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.ISBN = ISBN;
        this.isBorrowed = false;

    }

    // setter methods (for edit attributes)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // ISBN getter method for borrow a book
    public String getISBN() {
        return ISBN;
    }

    // title getter method for search a book
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {

        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages='" + pages + '\'' +
                ", year='" + year + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';

    }

    // fromString method to parse the input string and return a Book object
    public static Book fromString(String str) {
        str = str.replace("Book{", "")
                .replace("}", "");

        String[] parts = str.split(", ");
        Map<String, String> values = new HashMap<>();

        for (String part : parts) {
            String[] keyValue = part.split("='");
            String key = keyValue[0].trim();
            String value = keyValue[1].substring(0, keyValue[1].length() - 1); // Remove the trailing '
            values.put(key, value);
        }

        return new Book(
                values.get("title"),
                values.get("author"),
                values.get("pages"),
                values.get("year"),
                values.get("ISBN")
        );

    }

}