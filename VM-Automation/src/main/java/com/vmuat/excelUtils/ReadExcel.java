package com.vmuat.excelUtils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	@SuppressWarnings("resource")
	public static Object[][] readExcelForTestNG(String excelFileName) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./dataFile/"+excelFileName+".xlsx");	// Open the excel using the file path
		XSSFSheet sheet = book.getSheetAt(0);	//Get into the sheet using book reference
		int rowCount = sheet.getLastRowNum();	//Get the row count using sheet reference
		System.out.println("Row Count: "+rowCount);
		short colCount = sheet.getRow(0).getLastCellNum();	//Get the column using the header row
		System.out.println("Column Count: "+ colCount);
		
		String[][] data = new String[rowCount][colCount];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				data[i-1][j] = value;
			} 
		}
		return data;
	}
	
	
}
