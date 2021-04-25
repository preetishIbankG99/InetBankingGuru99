package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
public Sheet readExcel() throws IOException{
		File file =	new File("C:\\Users\\GUDU\\Downloads\\InternetGuru99Bank\\src\\main\\java\\com\\qa\\testdata\\LoginData.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
				wb = new XSSFWorkbook(inputStream);
		
		
		sh = wb.getSheet("Sheet1");
		 return sh;	
		}
}
