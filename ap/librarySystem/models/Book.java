package ap.librarySystem.models;

import ap.librarySystem.constants.BookStatus;

public class Book{

    private String ISBN;
    private String title, author, pages, year;
    private BookStatus bookStatus; // this can be replaced with book count if we will have duplicated books

    public Book(String title, String author, String pages, String year, String ISBN) {

        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.ISBN = ISBN;
        this.bookStatus = BookStatus.NOT_BORROWED;

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

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    // ISBN getter method for borrow a book
    public String getISBN() {
        return ISBN;
    }

    // title getter method for search a book
    public String getTitle() {
        return title;
    }

    // for lending system
    public BookStatus getBookStatus() {
        return bookStatus;
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

}