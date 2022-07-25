package com.testleaf.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {

	public static String[][] readFile(String fileName) throws IOException {

		XSSFWorkbook workBook = new XSSFWorkbook("./Data1/" + fileName + ".xlsx");
		XSSFSheet workSheet = workBook.getSheet("Sheet1");

		int rowCount = workSheet.getLastRowNum();

		int cellCount = workSheet.getRow(0).getLastCellNum();

		String[][] data = new String[rowCount][cellCount];

		for (int r = 1; r <= rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				String cellValue = workSheet.getRow(r).getCell(c).getStringCellValue();
				
				data[r - 1][c] = cellValue;
			}
		}

		workBook.close();
		return data;

	}

	
}