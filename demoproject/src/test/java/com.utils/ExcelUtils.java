package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.*;
//import org.apache.poi.ss.usermodel.DataFormatter.formatter;

public class ExcelUtils {

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

    public void setExcelFile(String filePath, String sheetName) throws FileNotFoundException, IOException
    {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet(sheetName);
        
    }

    public Object[][] getDataProv()
    {
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int cellCount = sheet.getRow(1).getLastCellNum();

        String data[][] = new String[rowCount][cellCount];

        for (int i=0; i<rowCount-1; i++)
        {
            
            for(int j = 0; j<cellCount; j++)
            {
                
                //String val = formatter.formatCellValue(cell);
                data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

}
