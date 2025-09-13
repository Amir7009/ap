package ap.projects.finalProject.model;

import ap.projects.midtermProject.constants.BookStatus;

public class Book {

    private String ISBN;
    private String title, author, year;

    // This can be replaced with book count if we will have duplicated books.
    private BookStatus bookStatus = BookStatus.NOT_BORROWED;

    public Book(String title, String author, String year, String ISBN) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }


    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }


    public void setBookStatus(BookStatus status) {
        bookStatus = status;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }


    public String getISBN() {
        return ISBN;
    }

    /**
     * For print the book info.
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
     * Print the book info for guest user.
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
