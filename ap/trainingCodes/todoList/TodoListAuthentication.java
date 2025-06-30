package ap.trainingCodes.todoList;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TodoListAuthentication {

    public static void signUp(ArrayList<AppUser> users, LinkedHashMap<String, ArrayList<Task>> tasks) {
        String username = JOptionPane.showInputDialog("Enter Username (e.g. @sample123)");
        if (username == null || !username.matches("^@[A-Za-z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Invalid username format!");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter Password");
        if (password == null || !password.matches("^[A-Za-z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Invalid password format!");
            return;
        }

        for (AppUser user : users) {
            if (user.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(null, "Username already exists!");
                return;
            }
        }

        users.add(new AppUser(username, password));
        tasks.put(username, new ArrayList<>());
        try {
            CSVHelper.saveUsers(users);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to save user data!");
        }
        JOptionPane.showMessageDialog(null, "Sign up successful");
    }

    public static String signIn(ArrayList<AppUser> users, LinkedHashMap<String, ArrayList<Task>> tasks) {
        String username = JOptionPane.showInputDialog("Enter Username (e.g. @sample123)");
        if (username == null || !username.matches("^@[A-Za-z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Invalid username format!");
            return null;
        }

        String password = JOptionPane.showInputDialog("Enter Password");
        if (password == null) return null;

        for (AppUser user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return username;
            }
        }
        JOptionPane.showMessageDialog(null, "Invalid username or password!");
        return null;
    }
}
