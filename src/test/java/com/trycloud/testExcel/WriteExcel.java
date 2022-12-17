package com.trycloud.testExcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    String filePath="SampleData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    @Test
    public void excel_write() throws IOException {
        FileInputStream fileInput= new FileInputStream(filePath);
        workbook= new XSSFWorkbook(fileInput);
        sheet= workbook.getSheet("Employees");


        XSSFCell salaryCell= sheet.getRow(0).createCell(3);
        XSSFCell salary1= sheet.getRow(1).createCell(3);
        XSSFCell salary2= sheet.getRow(2).createCell(3);
        XSSFCell salary3= sheet.getRow(3).createCell(3);
        XSSFCell salary4= sheet.getRow(4).createCell(3);
        salaryCell.setCellValue("Salary");
        salary1.setCellValue("200000");
        salary2.setCellValue("170000");
        salary3.setCellValue("1650000");
        salary4.setCellValue("1450000");

        for(int rowNum=0; rowNum<sheet.getLastRowNum();rowNum++){

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mary")){
                sheet.getRow(rowNum).getCell(1).setCellValue("Jones");
                break;
            }

        }






        FileOutputStream outputStream= new FileOutputStream(filePath);


        workbook.write(outputStream);


        workbook.close();
        fileInput.close();
        outputStream.close();


    }


}
