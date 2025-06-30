package ap.trainingCodes.todoList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelHelper {

    private static final String FILE_PATH = "userdata/task_data.xlsx";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Save tasks grouped by username to Excel with per-user sheets
    public static void saveTasks(Map<String, ArrayList<Task>> allTasks) {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // Ensure parent dir exists

        try (Workbook workbook = new XSSFWorkbook()) { // Auto-close Workbook
            for (Map.Entry<String, ArrayList<Task>> entry : allTasks.entrySet()) {
                String username = entry.getKey();
                String safeUsername = sanitizeSheetName(username);
                Sheet sheet = workbook.createSheet(safeUsername);

                createHeaderRow(sheet);

                int rowNum = 1;
                for (Task task : entry.getValue()) {
                    writeTaskToRow(sheet.createRow(rowNum++), task);
                }

                // Auto-size all columns
                for (int i = 0; i < 6; i++) {
                    sheet.autoSizeColumn(i);
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                workbook.write(outputStream);
                System.out.println("Tasks saved to " + FILE_PATH);
            }
        } catch (IOException e) {
            System.err.println("Error saving to Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Load tasks grouped by username from Excel sheets
    public static Map<String, ArrayList<Task>> loadTasks() {
        Map<String, ArrayList<Task>> allTasks = new HashMap<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No existing file found at: " + FILE_PATH);
            return allTasks; // Return empty map if file doesn't exist
        }

        try (Workbook workbook = WorkbookFactory.create(file)) {
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                String username = sheet.getSheetName();
                ArrayList<Task> tasks = new ArrayList<>();

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue; // Skip header
                    Task task = readTaskFromRow(row);
                    task.setUsername(username);
                    tasks.add(task);
                }
                allTasks.put(username, tasks);
            }
        } catch (IOException e) {
            System.err.println("Error reading from Excel: " + e.getMessage());
            e.printStackTrace();
        }

        return allTasks;
    }

    // Create header row with styling
    private static void createHeaderRow(Sheet sheet) {
        CellStyle headerStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        Row headerRow = sheet.createRow(0);
        String[] headers = {"Task Name", "Priority", "Estimated Time", "End Time", "Completed", "User"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
    }

    // Write task data to a row
    private static void writeTaskToRow(Row row, Task task) {
        row.createCell(0).setCellValue(task.getName());
        row.createCell(1).setCellValue(task.getPriority());
        row.createCell(2).setCellValue(task.getEstimatedTime());
        row.createCell(3).setCellValue(task.getEndTime() != null ? task.getEndTime().format(String.valueOf(DATE_TIME_FORMATTER)) : "");
        row.createCell(4).setCellValue(task.isCompleted());
        row.createCell(5).setCellValue(task.getUsername());
    }

    // Read task data from a row
    private static Task readTaskFromRow(Row row) {
        String name = getCellStringValue(row.getCell(0));
        String priority = getCellStringValue(row.getCell(1));
        String estimatedTime = getCellStringValue(row.getCell(2));
        String endTime = getCellStringValue(row.getCell(3));
        boolean isCompleted = "true".equalsIgnoreCase(getCellStringValue(row.getCell(4)));
        String username = getCellStringValue(row.getCell(5));

        Task task = new Task(name, priority, estimatedTime, endTime);
        task.setCompleted(isCompleted);
        task.setUsername(username);

        return task;

    }

    // Safely extract cell value as string
    private static String getCellStringValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    // Sanitize sheet name for Excel compatibility
    private static String sanitizeSheetName(String sheetName) {
        return sheetName.replaceAll("[\\\\/*?:\\[\\]]", "_");
    }
}
