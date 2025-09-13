package ap.projects.midtermProject.models;

import ap.projects.midtermProject.constants.BookStatus;

public class Book{

    private String ISBN;
    private String title, author, pages, year;
    private BookStatus bookStatus; // this can be replaced with book count if we will have duplicated books

    public Book(String title, String author, String pages, String year, String ISBN, BookStatus status) {

        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.ISBN = ISBN;
        this.bookStatus = status;

    }

    // setter methods (for edit attributes)
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setPages(String pages) {
//        this.pages = pages;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//
//    public void setISBN(String ISBN) {
//        this.ISBN = ISBN;
//    }

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

    public String getAuthor() {
        return author;
    }

    public String getPages() {
        return pages;
    }

    public String getYear() {
        return year;
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

    public String tabSplit(){
        return this.title + "\t" +
                this.author + "\t" +
                this.pages + "\t" +
                this.year + "\t" +
                this.ISBN + "\t" +
                this.bookStatus + "\t";
    }

}