package ap.trainingCodes.todoList;

import java.io.*;
import java.util.ArrayList;

public class CSVHelper {
    private static final String FILE_PATH = "userdata/users.csv";

    public static void saveUsers(ArrayList<AppUser> users) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (AppUser user : users) {
                writer.println(user.getUsername() + "," + user.getPassword());
            }
        }
    }

    public static ArrayList<AppUser> loadUsers() throws IOException {
        ArrayList<AppUser> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new AppUser(parts[0], parts[1]));
                }
            }
        }
        return users;
    }
}
