package ap.trainingCodes.todoList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class TodoListGUI extends JFrame {
    private TaskManager taskManager;
    private DefaultTableModel tableModel;
    private boolean showingCompleted = false;
    // originalTasks is the live list stored in the global tasks map (TaskManager holds a reference)
    private ArrayList<Task> originalTasks;
    // Keep reference to the full tasks map so saving does not overwrite other users
    private LinkedHashMap<String, ArrayList<Task>> allTasks;
    // The list of tasks currently shown in the table (used for mapping selection -> task)
    private List<Task> displayedTasks = new ArrayList<>();
    private String username;
    private enum ViewMode { INCOMPLETE_ONLY, ALL, COMPLETED_ONLY }
    public TodoListGUI(LinkedHashMap<String, ArrayList<Task>> tasks, String username) {
        // keep a reference to the master tasks map
        this.allTasks = tasks;
        this.username = username;
// Ensure the user has an entry in the map
        tasks.putIfAbsent(username, new ArrayList<>());
        taskManager = new TaskManager(tasks.get(username), username);
        originalTasks = taskManager.getAllTasks();
        setTitle("Todo List - " + username);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setupUI();
    }
    private void setupUI() {
        setLayout(new BorderLayout());
// Table for tasks
        String[] columns = {"Task Name", "Priority", "Estimated Time", "End Time", "Completed"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
            // make the Completed column render as checkbox
            public Class<?> getColumnClass(int column) {
                if (column == 4) return Boolean.class;
                return String.class;
            }
        };
        JTable taskTable = new JTable(tableModel);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskTable);
        add(scrollPane, BorderLayout.CENTER);
// Panel for buttons
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAdd = new JButton("Add Task");
        JButton btnEdit = new JButton("Edit Task");
        JButton btnRemove = new JButton("Remove Task");
        JButton btnMarkDone = new JButton("Mark as Done");
        JButton btnToggleView = new JButton("Show Completed");
        JButton btnBack = new JButton("Back to Incomplete");
        btnBack.setVisible(false);
        panel.add(btnAdd);
        panel.add(btnEdit);
        panel.add(btnRemove);
        panel.add(btnMarkDone);
        panel.add(btnToggleView);
        panel.add(btnBack);
        add(panel, BorderLayout.SOUTH);
// Button actions
        btnAdd.addActionListener(e -> addTask());
        btnEdit.addActionListener(e -> editTask(taskTable));
        btnRemove.addActionListener(e -> removeTask(taskTable));
        btnMarkDone.addActionListener(e -> markTaskAsDone(taskTable));
        btnToggleView.addActionListener(e -> toggleCompletedView(btnToggleView, btnBack));
        btnBack.addActionListener(e -> returnToIncompleteView(btnToggleView, btnBack));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    // Save ALL users' tasks so we don't wipe data for others
                    ExcelHelper.saveTasks(allTasks);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(TodoListGUI.this, "Failed to save tasks: " + error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        refreshTable(ViewMode.INCOMPLETE_ONLY);
        pack();
        setLocationRelativeTo(null);
    }
    private void toggleCompletedView(JButton toggleButton, JButton backButton) {
        showingCompleted = !showingCompleted;
        if (showingCompleted) {
            refreshTable(ViewMode.COMPLETED_ONLY);
            toggleButton.setText("Show All Tasks");
            backButton.setVisible(true);
        } else {
            refreshTable(ViewMode.ALL);
            toggleButton.setText("Show Completed");
            backButton.setVisible(false);
        }
    }
    private void returnToIncompleteView(JButton toggleButton, JButton backButton) {
        refreshTable(ViewMode.INCOMPLETE_ONLY);
        toggleButton.setText("Show Completed");
        backButton.setVisible(false);
        showingCompleted = false;
    }
    private void addTask() {
        JTextField nameField = new JTextField();
        JTextField priorityField = new JTextField();
        JTextField timeField = new JTextField();
        Object[] message = {
                "Task Name:", nameField,
                "Priority:", priorityField,
                "Estimated Time:", timeField
        };
        int option = JOptionPane.showConfirmDialog(this, message, "Add New Task", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Task task = new Task(nameField.getText(), priorityField.getText(), timeField.getText(), "");
            // ensure username is set
            task.setUsername(username);
            taskManager.addTask(task);
            // originalTasks references the same list held by the global map, so it's updated
            refreshTableWithCurrentView();
        }
    }
    private void editTask(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Task selectedTask = displayedTasks.get(selectedRow);
            if (!selectedTask.isCompleted()) {
                JTextField nameField = new JTextField(selectedTask.getName());
                JTextField priorityField = new JTextField(selectedTask.getPriority());
                JTextField timeField = new JTextField(selectedTask.getEstimatedTime());
                Object[] message = {
                        "New Task Name:", nameField,
                        "New Priority:", priorityField,
                        "New Estimated Time:", timeField
                };
                int option = JOptionPane.showConfirmDialog(this, message, "Edit Task", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    selectedTask.setName(nameField.getText());
                    selectedTask.setPriority(priorityField.getText());
                    selectedTask.setEstimatedTime(timeField.getText());
// find index in the original list and update there
                    int originalIndex = originalTasks.indexOf(selectedTask);
                    if (originalIndex >= 0) {
                        taskManager.updateTask(originalIndex, selectedTask);
                    }
                    refreshTableWithCurrentView();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Completed tasks cannot be edited.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to edit");
        }
    }
    private void removeTask(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to remove this task?",
                    "Confirm Removal",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Task task = displayedTasks.get(selectedRow);
                int originalIndex = originalTasks.indexOf(task);
                if (originalIndex >= 0) {
                    taskManager.removeTask(originalIndex);
                }
                refreshTableWithCurrentView();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to remove");
        }
    }
    private void markTaskAsDone(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Task task = displayedTasks.get(selectedRow);
            if (!task.isCompleted()) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Mark this task as completed?",
                        "Confirm Completion",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    task.setCompleted(true);
                    task.setEndTime(String.valueOf(LocalDate.now()));
                    int originalIndex = originalTasks.indexOf(task);
                    if (originalIndex >= 0) taskManager.updateTask(originalIndex, task);
                    refreshTableWithCurrentView();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Task is already marked as completed.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to mark as done");
        }
    }
    private void refreshTableWithCurrentView() {
        if (showingCompleted) refreshTable(ViewMode.COMPLETED_ONLY);
        else refreshTable(ViewMode.INCOMPLETE_ONLY);
    }
    private void refreshTable(ViewMode viewMode) {
        tableModel.setRowCount(0);
        ArrayList<Task> tasksToDisplay = new ArrayList<>();
        switch (viewMode) {
            case INCOMPLETE_ONLY:
                for (Task t : originalTasks) if (!t.isCompleted()) tasksToDisplay.add(t);
                break;
            case COMPLETED_ONLY:
                for (Task t : originalTasks) if (t.isCompleted()) tasksToDisplay.add(t);
                break;
            case ALL:
                tasksToDisplay.addAll(originalTasks);
                break;
        }
// Sort tasks by priority (null-safe). You may want a custom priority ordering later.
        tasksToDisplay.sort(Comparator.comparing(t -> t.getPriority() == null ? "" : t.getPriority()));
// Store the displayed tasks so selection maps to the correct task object
        displayedTasks = tasksToDisplay;
        for (Task task : tasksToDisplay) {
            Object[] row = {
                    task.getName(),
                    task.getPriority(),
                    task.getEstimatedTime(),
                    task.getEndTime(),
                    task.isCompleted()
            };
            tableModel.addRow(row);
        }
    }
    // Return the live tasks map (not just the current user's tasks) so saver writes all users.
    private Map<String, ArrayList<Task>> getAllTasksWithUsers() {
        return allTasks;
    }
}
