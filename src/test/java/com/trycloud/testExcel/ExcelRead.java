package com.trycloud.testExcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.FileAssert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExcelRead {
    @Test
    public void read_from_excel_file(){
        String path="SampleData.xlsx";
        //to read from excel we need to lead it to FileImput Strea
        try {
            File file= new File(path);

            FileInputStream fileInput= new FileInputStream(file);
            XSSFWorkbook workBook = new XSSFWorkbook(fileInput);
            XSSFSheet sheet = workBook.getSheet("Employees");


            System.out.println(sheet.getRow(0).getCell(0));
            System.out.println("---------------------------------------");
            System.out.println(sheet.getRow(4).getCell(0));
            System.out.println("----------------------------------------");

            System.out.println(sheet.getRow(3).getCell(2));
            System.out.println(sheet.getRow(1).getCell(1));

            System.out.println(sheet.getRow(1).getCell(0));

            System.out.println(sheet.getPhysicalNumberOfRows());
            System.out.println(sheet.getLastRowNum());

            for (int i=0;i<sheet.getPhysicalNumberOfRows();i++){
                if (sheet.getRow(i).getCell(0).toString().equals("Manssor")){
                    System.out.println(sheet.getRow(i).getCell(0));
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }






    }

}
