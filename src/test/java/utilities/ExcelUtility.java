package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private String path;
    private FileInputStream fi;
    private FileOutputStream fo;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    // Constructor to initialize the path of the Excel file
    public ExcelUtility(String path) {
        this.path = path;
    }

    // Method to get the number of rows in a sheet
    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum(); // Returns the last row index (0-based)
        workbook.close();
        fi.close();
        return rowCount;
    }

    // Method to get the number of cells in a specific row
    public int getCellCount(String sheetName, int rownum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        int cellCount = row.getLastCellNum(); // Returns the total number of cells (1-based)
        workbook.close();
        fi.close();
        return cellCount;
    }

    // Method to get the cell data as a string
    public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        cell = row.getCell(colnum);
        String data;
        try {
            data = cell.toString(); // Converts cell content to String
        } catch (Exception e) {
            data = ""; // Returns an empty string if the cell is null
        }
        workbook.close();
        fi.close();
        return data;
    }

    // Method to set data in a cell
    public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        if (row == null) {
            row = sheet.createRow(rownum);
        }
        cell = row.getCell(colnum);
        if (cell == null) {
            cell = row.createCell(colnum);
        }
        cell.setCellValue(data);
        fo = new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}
