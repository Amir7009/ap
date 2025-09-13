package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Book;

import java.util.LinkedHashMap;

public class BookRepository {

    private LinkedHashMap<String, Book> books = new LinkedHashMap<>();

    /**
     * A method for add a new book to library
     *
     * @param book the new book
     */
    public void add(String ISBN, Book book) {
        books.put(ISBN, book);
    }

    /**
     * A method for remove a book from library
     *
     * @param ISBN the ISBN of removing book
     */
    public void remove(String ISBN) {
        books.remove(ISBN);
    }

    /**
     * To search a book by its title
     *
     * @param title the title that entered by user
     * @return if book exists returns the book
     */
    public Book findByTitle(String title) {
        return books.values().stream()
                .filter(s -> s.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    /**
     * To search a book by its author
     *
     * @param author the author that entered by user
     * @return if book exists returns the book
     */
    public Book findByAuthor(String author) {
        return books.values().stream()
                .filter(s -> s.getAuthor().equals(author))
                .findFirst()
                .orElse(null);
    }

    /**
     * To search a book by its year
     *
     * @param year the year that entered by user
     * @return if book exists returns the book
     */
    public Book findByYear(String year) {
        return books.values().stream()
                .filter(s -> s.getYear().equals(year))
                .findFirst()
                .orElse(null);
    }

    /**
     * To search a book by its ISBN
     * Just for edit book info
     *
     * @param ISBN the ISBN that entered by user
     * @return if book exists returns the book
     */
    public Book findByISBN(String ISBN) {
        return books.values().stream()
                .filter(s -> s.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    /**
     * To access all books in library
     *
     * @return a map of all books
     */
    public LinkedHashMap<String, Book> findAll() {
        return books;
    }

    /**
     * To access to count of books that registered in the library
     *
     * @return the count of books
     */
    public int count() {
        return books.size();
    }

}
