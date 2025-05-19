package ap.midterm_project.helpers;

import ap.midterm_project.models.Borrow;
import ap.midterm_project.constants.BookStatus;
import ap.midterm_project.models.Student;

import java.util.ArrayList;

public class Printer {

    public <T> void  printObjectInfo(ArrayList<T> objects){

        if (objects.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        for (T object : objects) {

            System.out.println(object.toString());

        }

    }

    public void printUnreturnedBooks(ArrayList<Borrow> borrows, Student student){

        int i = 0;
        for (Borrow borrow : borrows) {

            if(borrow.getBorrowedBook().getBookStatus() == BookStatus.IS_BORROWED && borrow.getBorrowerStudent().equals(student)) {
                System.out.println(borrow.getBorrowedBook());
                i++;
            }

        }
        if (i == 0)
            System.out.println("No items found!");

    }

    public void showStudentNotifications (Student student){

        System.out.println(student.getNotifications());

    }

}
