package ap.projects.finalProject.storage;

import ap.projects.finalProject.LibrarySystem;
import ap.projects.finalProject.storage.tabSplit.*;


public class TabSplitStorage {

    String path = "E:\\Java\\Advanced-Programming\\ap\\projects\\finalProject";

    public void saveAll(LibrarySystem librarySystem) {

        try {
            TabSplitBookIO.save(librarySystem.getBookService().getRepository().findAll(), path + "\\libraryData\\Books.txt");
        } catch (Exception e) {
            System.out.println("Save book to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitStudentIO.save(librarySystem.getStudentService().getRepository().findAll(), path + "\\libraryData\\Students.txt");
        } catch (Exception e) {
            System.out.println("Save student to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitLibrarianIO.save(librarySystem.getLibrarianService().getRepository().findAll(), path + "\\libraryData\\Librarians.txt");
        } catch (Exception e) {
            System.out.println("Save librarian to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitLoanIO.save(librarySystem.getLoanService().getRepository().getAllLoans(), path + "\\libraryData\\Loans.txt");
        } catch (Exception e) {
            System.out.println("Save Loan to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitRequestIO.save(librarySystem.getLoanService().getRepository().getAllLoanRequests(), path + "\\libraryData\\LoanRequests.txt");
        } catch (Exception e) {
            System.out.println("Save loan request to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitRequestIO.save(librarySystem.getLoanService().getRepository().getAllReturnRequests(), path + "\\libraryData\\ReturnRequests.txt");
        } catch (Exception e) {
            System.out.println("Save return request to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitMostLateStudentsIO.save(librarySystem.getStudentService().getRepository().getMostLateStudents(), path + "\\libraryData\\MostLateStudents.txt");
        } catch (Exception e) {
            System.out.println("Save most late students to tab-split file ERROR:" + e.getMessage());
        }
        try {
            TabSplitPastLoanHistoryIO.save(librarySystem.getLoanService().getRepository().getPastLoansHistory(), path + "\\libraryData\\PastLoansHistory.txt");
        } catch (Exception e) {
            System.out.println("Save past loans history to tab-split file ERROR:" + e.getMessage());
        }

    }

    public void loadAll(LibrarySystem librarySystem) {

        try {
            librarySystem.getBookService().getRepository().setBooks(TabSplitBookIO.load(path + "\\libraryData\\Books.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit book file ERROR:" + e.getMessage());
        }
        try {
           librarySystem.getStudentService().getRepository().setStudents(TabSplitStudentIO.load(path + "\\libraryData\\Students.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit student file ERROR:" + e.getMessage());
        }
        try {
           librarySystem.getLibrarianService().getRepository().setLibrarians(TabSplitLibrarianIO.load(path + "\\libraryData\\Librarians.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit librarian file ERROR:" + e.getMessage());
        }
        try {
            librarySystem.getLoanService().getRepository().setCurrentLoans(TabSplitLoanIO.load(path + "\\libraryData\\Loans.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit loan file ERROR:" + e.getMessage());
        }
        try {
            librarySystem.getLoanService().getRepository().setLoanRequests(TabSplitRequestIO.load(path + "\\libraryData\\LoanRequests.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit loan request file ERROR:" + e.getMessage());
        }
        try {
            librarySystem.getLoanService().getRepository().setReturnRequests(TabSplitRequestIO.load(path + "\\libraryData\\ReturnRequests.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit return request file ERROR:" + e.getMessage());
        }
        try {
            librarySystem.getStudentService().getRepository().setMostLateStudents(TabSplitMostLateStudentsIO.load(path + "\\libraryData\\MostLateStudents.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit most late students file ERROR:" + e.getMessage());
        }
        try {
            librarySystem.getLoanService().getRepository().setPastLoansHistory(TabSplitPastLoanHistoryIO.load(path + "\\libraryData\\PastLoansHistory.txt"));
        } catch (Exception e) {
            System.out.println("TabSplit past loans history file ERROR:" + e.getMessage());
        }

    }

}
