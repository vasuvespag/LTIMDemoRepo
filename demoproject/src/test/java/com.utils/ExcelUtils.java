package com.utils;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public void setExcelFile(String filePath, String sheetName)
    {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook

    }

}
