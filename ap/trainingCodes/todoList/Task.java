package ap.trainingCodes.todoList;

public class Task {
    private String name;
    private String priority;
    private String estimatedTime;
    private String endTime;
    private boolean isCompleted;
    private String username;

    public Task(String name, String priority, String estimatedTime, String endTime) {
        this.name = name;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
        this.endTime = endTime;
        this.isCompleted = false;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getEstimatedTime() { return estimatedTime; }
    public void setEstimatedTime(String estimatedTime) { this.estimatedTime = estimatedTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }}
