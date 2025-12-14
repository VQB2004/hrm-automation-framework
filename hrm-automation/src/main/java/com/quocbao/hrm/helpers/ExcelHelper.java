package com.quocbao.hrm.helpers;

import com.quocbao.hrm.utils.LogUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

public class ExcelHelper {
    private Sheet sheet;

    public ExcelHelper(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(fis);
            this.sheet = wb.getSheet(sheetName);
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
        }

    }

    private String getDataCell(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }

    public Object[][] getDataAsMap() {
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[totalRows - 1][1];
        Row header = sheet.getRow(0);

        for (int rowIndex = 1; rowIndex < totalRows; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            Map<String, String> map = new HashMap<>(totalCols);
            for (int colIndex = 0; colIndex < totalCols; colIndex++) {
                map.put(getDataCell(header.getCell(colIndex)),
                        getDataCell(row.getCell(colIndex)));


            }
            data[rowIndex-1][0]=map;
        }
        return  data;
    }
}
