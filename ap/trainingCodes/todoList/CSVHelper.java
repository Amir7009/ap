package ap.trainingCodes.todoList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class CSVHelper {
    private static final String FILE_PATH = "userdata/users.csv";


    // Save users into CSV. Ensures parent directory exists and uses UTF-8.
// NOTE: passwords are still stored in plain text here for simplicity.
// In production, you MUST hash passwords (bcrypt/scrypt/argon2).
    public static void saveUsers(ArrayList<AppUser> users) throws IOException {
        Path path = Paths.get(FILE_PATH);
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }


        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (AppUser user : users) {
// simple CSV: username,password
// We use split-limit of 2 when reading so passwords could contain commas later
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        }
    }


    // Load users from CSV. If the file does not exist, return an empty list (no exception).
    public static ArrayList<AppUser> loadUsers() throws IOException {
        Path path = Paths.get(FILE_PATH);
        ArrayList<AppUser> users = new ArrayList<>();


        if (!Files.exists(path)) {
// No users yet
            return users;
        }


        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
// limit to 2 parts so password may contain commas in the future
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    users.add(new AppUser(parts[0], parts[1]));
                }
// malformed lines are skipped silently
            }
        }
        return users;
    }
}