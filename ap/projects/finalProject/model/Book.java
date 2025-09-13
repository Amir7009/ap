package ap.projects.finalProject.model;

import ap.librarySystem.constants.BookStatus;

public class Book {

    private String ISBN;
    private String title, author, year;
    private BookStatus bookStatus = BookStatus.NOT_BORROWED; // This can be replaced with book count if we will have duplicated books

    public Book(String title, String author, String year, String ISBN) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setBookStatus(BookStatus status) {
        bookStatus = status;
    }

    /**
     * For print the book info
     *
     * @return the book info as a string in form of
     * Book{title='...', author='...', year='...', ISBN='...', status='...'}
     */
    @Override
    public String toString() {

        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Status='" + bookStatus + '\'' +
                '}';

    }

    /**
     * Print the book info for guest user
     *
     * @return the book info as a string in form of
     * Book{title='...', author='...', year='...'}
     */
    public String getBookDetailForGuestUser() {

        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';

    }

}
