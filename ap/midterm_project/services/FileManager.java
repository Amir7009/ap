package ap.midterm_project.services;

import ap.midterm_project.database.Library;
import ap.midterm_project.helpers.LoadFromFile;
import ap.midterm_project.helpers.SaveToFile;

public class FileManager {

    SaveToFile save = new SaveToFile();
    LoadFromFile load = new LoadFromFile();

    public void save(Library library){

        save.save(library.getLibraryStudents(), "students.txt");
        save.save(library.getLibrarians(), "librarians.txt");
        save.save(library.getBooks(), "books.txt");
        save.save(library.getLoans(), "loans.txt");
        save.save(library.getLoanRequests(), "loanRequests.txt");
        save.save(library.getReturnRequests(), "returnRequests.txt");

    }

    public void Load(Library library){

        library.setLibraryStudents(load.loadStudents("students.txt"));
        library.setLibrarians(load.loadLibrarians("librarians.txt"));
        library.setBooks(load.loadBooks("books.txt"));
        library.setLoans(load.loadLoans("loans.txt"));
        library.setLoanRequests(load.loadLoanRequests("loanRequests.txt"));
        library.setReturnRequests(load.loadReturnRequests("returnRequests.txt"));

    }

}
