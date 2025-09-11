package ap.trainingCodes.todoList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelHelper {

    private static final String FILE_PATH = "userdata/task_data.xlsx";

    // Save tasks grouped by username to Excel
    public static void saveTasks(Map<String, ArrayList<Task>> allTasks) {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // Ensure parent dir exists

        try (Workbook workbook = new XSSFWorkbook()) {

            for (Map.Entry<String, ArrayList<Task>> entry : allTasks.entrySet()) {
                String username = entry.getKey();
                String safeUsername = sanitizeSheetName(username);
                Sheet sheet = workbook.createSheet(safeUsername);

                createHeaderRow(sheet);

                int rowNum = 1;
                for (Task task : entry.getValue()) {
                    Row row = sheet.createRow(rowNum++);
                    writeTaskToRow(row, task);
                }

                for (int i = 0; i < 6; i++) {
                    sheet.autoSizeColumn(i);
                }
            }

            // Directly write workbook to file
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load tasks grouped by username from Excel sheets
    public static Map<String, ArrayList<Task>> loadTasks() {
        Map<String, ArrayList<Task>> allTasks = new LinkedHashMap<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) return allTasks;

        try (Workbook workbook = WorkbookFactory.create(file)) {
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                String username = sheet.getSheetName();
                ArrayList<Task> tasks = new ArrayList<>();

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue; // skip header
                    Task task = readTaskFromRow(row);
                    task.setUsername(username);
                    tasks.add(task);
                }

                allTasks.put(username, tasks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allTasks;
    }

    // Header row
    private static void createHeaderRow(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Task Name", "Priority", "Estimated Time", "End Time", "Completed", "User"};

        CellStyle style = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        style.setFont(font);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }
    }

    // Write task to row
    private static void writeTaskToRow(Row row, Task task) {
        row.createCell(0).setCellValue(task.getName());
        row.createCell(1).setCellValue(task.getPriority());
        row.createCell(2).setCellValue(task.getEstimatedTime());
        row.createCell(3).setCellValue(task.getEndTime() != null ? task.getEndTime() : "");
        row.createCell(4).setCellValue(task.isCompleted());
        row.createCell(5).setCellValue(task.getUsername());
    }

    // Read task from row
    private static Task readTaskFromRow(Row row) {
        String name = getCellStringValue(row.getCell(0));
        String priority = getCellStringValue(row.getCell(1));
        String estTime = getCellStringValue(row.getCell(2));
        String endTime = getCellStringValue(row.getCell(3));
        boolean completed = "true".equalsIgnoreCase(getCellStringValue(row.getCell(4)));
        String username = getCellStringValue(row.getCell(5));

        Task task = new Task(name, priority, estTime, endTime);
        task.setCompleted(completed);
        task.setUsername(username);

        return task;
    }

    // Get cell value as string safely
    private static String getCellStringValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA: return cell.getCellFormula();
            default: return "";
        }
    }

    // Sanitize sheet name
    private static String sanitizeSheetName(String sheetName) {
        return sheetName.replaceAll("[\\\\/*?:\\[\\]]", "_");
    }
}
