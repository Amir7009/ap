package ap.projects.finalProject.service;

import ap.projects.finalProject.model.enums.BookStatus;
import ap.projects.finalProject.model.Book;
import ap.projects.finalProject.model.Librarian;
import ap.projects.finalProject.repository.BookRepository;
import ap.projects.finalProject.util.UserInput;

import java.util.Scanner;

public class BookService {

    private final BookRepository repository;
    private Scanner scanner;
    private UserInput userInput;

    public BookService(BookRepository repository) {
        this.repository = repository;
        scanner = new Scanner(System.in);
        userInput = new UserInput();
    }

    /**
     * Simply add a book to the library by getting information from the librarian,
     * and saving the book name as a book registration record for the librarian.
     *
     * @param librarian the librarian who registered new book
     */
    public void addBook(Librarian librarian) {

        System.out.println("\n--- Add New Book ---");

        System.out.print("Book title: ");
        String title = scanner.nextLine();

        System.out.print("Book Author: ");
        String author = scanner.nextLine();

        System.out.print("Book Year: ");
        String year = scanner.nextLine();

        System.out.print("Book ISBN: ");
        String ISBN = scanner.nextLine();

        Book book = new Book(title, author, year, ISBN, BookStatus.NOT_BORROWED);
        repository.add(ISBN, book);

        librarian.addBooksRegisteredHistory(title);

        System.out.println("Successful!");

    }

    /**
     * The librarian can edit the book's information by entering its ISBN.
     */
    public void editBook() {

        System.out.println("\n--- Edit Book Info ---");

        System.out.print("Please enter the ISBN: ");
        String ISBN = scanner.nextLine();

        Book bookToEdit = repository.findByISBN(ISBN);

        System.out.print("New Book title: ");
        bookToEdit.setTitle(scanner.nextLine());

        System.out.print("New Book Author: ");
        bookToEdit.setAuthor(scanner.nextLine());

        System.out.print("New Book Year: ");
        bookToEdit.setYear(scanner.nextLine());

        System.out.println("Successful!");

    }

    /**
     * The user can delete that book from the library book list by entering the ISBN.
     * But this feature has not yet been fully implemented.
     */
    public void removeBook() {

        System.out.println("\n--- Remove Book ---");

        System.out.print("Please enter the ISBN: ");
        String ISBN = scanner.nextLine();

        Book bookToRemove = repository.findByISBN(ISBN);

        if (bookToRemove.getBookStatus() != BookStatus.NOT_BORROWED) {
            System.out.println("The book is already borrowed or reserved!");
            return;
        }

        System.out.println("Do you want to remove this book?\t(y/n)\n" + bookToRemove);
        String input = scanner.nextLine().toLowerCase();
        if (input.contains("y")) {
            repository.remove(ISBN);
            System.out.println("Successful!");
        }

    }

    /**
     * Shows all available options for search a book in library.
     */
    public void searchBook() {
        boolean condition = true;
        while (condition) {
            System.out.println("\n=== Search Book ===");
            System.out.println("1. Search By Title");
            System.out.println("2. Search By Author");
            System.out.println("3. Search By Year");
            System.out.println("4. Back");
            System.out.print("Please enter your choice: ");

            int choice = userInput.getIntInput(1, 4);

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter The Title:");
                    Book book = repository.findByTitle(scanner.nextLine());
                    if (book != null)
                        System.out.println(book);
                    else
                        System.out.println("Not Found!");
                }
                case 2 -> {
                    System.out.println("Enter The Author:");
                    Book book = repository.findByAuthor(scanner.nextLine());
                    if (book != null)
                        System.out.println(book);
                    else
                        System.out.println("Not Found!");
                }
                case 3 -> {
                    System.out.println("Enter The Year:");
                    Book book = repository.findByYear(scanner.nextLine());
                    if (book != null)
                        System.out.println(book);
                    else
                        System.out.println("Not Found!");
                }
                case 4 -> condition = false;
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    /**
     * To exchange the list of registered books.
     *
     * @return the book repository services
     */
    public BookRepository getRepository() {
        return repository;
    }

}
