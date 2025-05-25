package ap.midterm_project.helpers;

import ap.midterm_project.models.Book;
import ap.midterm_project.models.Borrow;
import ap.midterm_project.constants.BookStatus;
import ap.midterm_project.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Printer {

    public <T> void printObjectInfo(ArrayList<T> objects) {

        if (objects.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        for (T object : objects) {

            System.out.println(object.toString());

        }

    }

    public void printStudentUnreturnedBooks(ArrayList<Borrow> borrows, Student student) {

        int i = 0;
        for (Borrow borrow : borrows) {

            if (borrow.getBorrowedBook().getBookStatus() == BookStatus.IS_BORROWED && borrow.getBorrowerStudent().equals(student)) {
                System.out.print(borrow.getBorrowedBook());
                if (borrow.isLate(LocalDate.now()))
                    System.out.println(" --- LATE! ---");
                else
                    System.out.println();
                i++;
            }

        }
        if (i == 0)
            System.out.println("No items found!");

    }

    public void printUnreturnedBooks(ArrayList<Borrow> borrows) {

        int i = 0;
        for (Borrow borrow : borrows) {

            if (borrow.getBorrowedBook().getBookStatus() == BookStatus.IS_BORROWED) {
                System.out.print(borrow.getBorrowedBook());
                if (borrow.isLate(LocalDate.now()))
                    System.out.println(" --- LATE! ---");
                else
                    System.out.println();
                i++;
            }

        }
        if (i == 0)
            System.out.println("No items found!");

    }

    public void showStudentNotifications(Student student) {

        String[] notifications = student.getNotifications().split("-");
        for (String notification : notifications) {
            System.out.println(notification);
        }

    }

    public void printStudentHistory(Student student) {

        String[] history = student.getLoanHistory().split("-");
        for (String string : history) {
            System.out.println(string);
        }

    }

    public void printLibrarianHistory(String history) {

        String[] historyItem = history.split("-");
        for (String string : historyItem) {
            System.out.println(string);
        }

    }

    public void printLateBooks(ArrayList<Borrow> borrows) {
        int counter = 0;
        for (Borrow borrow : borrows) {
            if (borrow.isLate(LocalDate.now())) {
                System.out.println(
                        "Book > " + borrow.getBorrowedBook().getISBN() +
                                " Student > " + borrow.getBorrowerStudent().getUsername() +
                                " is late " + borrow.getDelay() + " days!"
                );
                counter++;
            }
        }
        if (counter == 0)
            System.out.println("Item not found!");
    }

    public void printTopTenBook(ArrayList<Borrow> borrows) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        List<Map.Entry<Book, Long>> list = borrows.stream()
                .filter(s -> s.getLoanStartDate().isAfter(oneYearAgo))
                .collect(Collectors.groupingBy(Borrow::getBorrowedBook, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Book, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + list.get(i).toString());
            if (i == list.size() - 1)
                return;
        }
        System.out.println("Item not found!");
    }

}
