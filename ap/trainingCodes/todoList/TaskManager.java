package ap.trainingCodes.todoList;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private ArrayList<Task> tasks;
    private String username; // which user's tasks are managed
    public TaskManager(ArrayList<Task> tasks, String username) {
        this.tasks = tasks;
        this.username = username;
    }
    // Ensure task username is set to this manager's username when adding
    public void addTask(Task task) {
        if (task.getUsername() == null || task.getUsername().isEmpty()) {
            task.setUsername(username);
        }
        tasks.add(task);
    }
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
    // When updating, ensure username remains consistent
    public void updateTask(int index, Task updatedTask) {
        if (index >= 0 && index < tasks.size()) {
            updatedTask.setUsername(username);
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
    public String getUsername() {
        return username;
    }
}
