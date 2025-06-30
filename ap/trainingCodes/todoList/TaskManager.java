package ap.trainingCodes.todoList;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private ArrayList<Task> tasks;
    private String username; // Added to know which user's tasks are managed

    public TaskManager(ArrayList<Task> tasks, String username) {
        this.tasks = tasks;
        this.username = username;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    // Added to update an existing task
    public void updateTask(int index, Task updatedTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, updatedTask);
        }
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getCompletedTasks() {
        List<Task> completed = new ArrayList<>();
        for (Task t : tasks) {
            if (t.isCompleted()) {
                completed.add(t);
            }
        }
        return completed;
    }

    // Getter for the username
    public String getUsername() {
        return username;
    }
}