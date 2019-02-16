package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook xsw;
	XSSFSheet xss;
	public ExcelDataProvider() {
		File src=new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			
				xsw	=new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Excel is not loaded "+e.getMessage());
		}
	
			
		
		
	}

	public String getstringgetdata(String sheetname ,int rownum,int cellnum) {
	return xsw.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	
	}
	public double getnumericdata(String sheetname ,int rownum,int cellnum) {
		return xsw.getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
}
}