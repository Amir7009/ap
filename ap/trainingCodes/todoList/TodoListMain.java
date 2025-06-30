package ap.trainingCodes.todoList;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TodoListMain {

    private static ArrayList<AppUser> users = new ArrayList<>();
    private static LinkedHashMap<String, ArrayList<Task>> tasks = new LinkedHashMap<>();

    public static void main(String[] args) {
        // Load existing data
        loadData();

        SwingUtilities.invokeLater(() -> {
            String loggedInUsername = null;
            while (loggedInUsername == null) {
                int option = JOptionPane.showOptionDialog(
                        null,
                        "Choose an option:",
                        "Todo List Authentication",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Sign In", "Sign Up", "Exit"},
                        "Sign In");

                switch (option) {
                    case 0: // Sign In
                        loggedInUsername = TodoListAuthentication.signIn(users, tasks);
                        if (loggedInUsername != null) {
                            JOptionPane.showMessageDialog(null, "Sign In Successful!");
                            // Pass the entire tasks map to the GUI
                            new TodoListGUI(tasks, loggedInUsername).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sign In Failed. Try again or Sign Up.");
                        }
                        break;
                    case 1: // Sign Up
                        TodoListAuthentication.signUp(users, tasks);
                        // Sign up method shows its own success/failure messages
                        // After sign up, the loop continues, prompting for sign in
                        break;
                    case 2: // Exit
                    case JOptionPane.CLOSED_OPTION: // Dialog closed
                        System.exit(0);
                        break;
                }
            }
        });
    }

    // Load user and task data from files
    private static void loadData() {
        try {
            users = CSVHelper.loadUsers();
            JOptionPane.showMessageDialog(null, "Users loaded successfully.", "Load Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No user data found or failed to load users.", "Load Status", JOptionPane.WARNING_MESSAGE);
            // Initialize with empty list if loading fails
            users = new ArrayList<>();
        }

        try {
            // Load tasks. This will create empty ArrayLists in the map for users with no tasks file.
            tasks = (LinkedHashMap<String, ArrayList<Task>>) ExcelHelper.loadTasks();
            JOptionPane.showMessageDialog(null, "Tasks loaded successfully.", "Load Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No task data found or failed to load tasks.", "Load Status", JOptionPane.WARNING_MESSAGE);
            // Initialize with empty map if loading fails
            tasks = new LinkedHashMap<>();
        }

        // Ensure all loaded users have an entry in the tasks map, even if empty
        for (AppUser user : users) {
            tasks.putIfAbsent(user.getUsername(), new ArrayList<>());
        }
    }

    // Note: Saving happens in TodoListGUI's windowClosing listener
    // This is because the GUI is active when the user decides to close

}
