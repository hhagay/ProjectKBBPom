package com.aut.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * This is to verify that excel interaction works
 *
 */
public class ReadWriteExcel {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		/**
		 * Code to Read from Excel
		 */
		// Creating a file output stream to represent our file
		FileInputStream fis = new FileInputStream("MasterTestDataFile.xlsx");
		// Creating the required data in our wb object
		Workbook wb = WorkbookFactory.create(fis);
		// Using wb.getSheet method to get the sheet name
		Sheet tds = wb.getSheet("TestCaseDataSets");
		
		String cellValue1 = tds.getRow(6).getCell(1).toString();
		String cellValue2 = tds.getRow(7).getCell(0).toString();

		String cellValue3;
		
		try{
			cellValue3 = tds.getRow(6).getCell(11).toString();
		}catch(NullPointerException e){
			System.out.println(cellValue3="Nothing");
		}
		
		System.out.println("Data read from Excel: "+cellValue1);
		System.out.println("Data read from Excel: "+cellValue2);
		
		
//		/**
//		 * Code to Write to Excel
//		 */
//		// Creating a file output stream to represent our file
//		FileOutputStream fos = new FileOutputStream("MasterTestDataFile.xlsx");
//		// Creating the required data in our wb object
//		wb.createSheet("TestSheet1").createRow(5).createCell(2).setCellValue("Hello");
//		tds.getRow(5).getCell(0).setCellValue("Welcome");
//		// Using wb.write method to write to actual file on file system
//		wb.write(fos);
//		// Closing file output stream
//		fos.close();
		

	}

}
