package com.qa.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.base.TestBase;
import com.qa.pages.AdminLogin;
import com.qa.utility.XLUtils;
public class DataDrivenTest extends TestBase{
	public static XSSFWorkbook wb;
	public static Sheet sh;
	public static AdminLogin adminLogin;
	public DataDrivenTest() throws FileNotFoundException, IOException {
		super();
		}
@BeforeMethod
	public void browserSetup() throws IOException {
	initialization();
	}


	
    @Test(dataProvider="testdata")
	public void testLogin(String username,String password) throws Exception {
		 adminLogin=new AdminLogin();
      adminLogin.setUsername(username);
      logger.info("::::username Entered:::");
      adminLogin.setPassword(password);
      logger.info("::::password Entered:::");
      adminLogin.clickLoginbtn();
      logger.info("::::login clicked:::");
          	
  	if(isAlertPresent()==true)
	{
		driver.switchTo().alert().accept();//close alert
		driver.switchTo().defaultContent();
		//For Failing A test case delibarately due to assertion
		Assert.assertTrue(false);
		//for passing although credentials invalid
		//Assert.assertTrue(true);
		logger.warn("Login failed");
	}
	else
	{
		Assert.assertTrue(true);
		logger.info("Login passed");
		adminLogin.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();//close logout alert
		driver.switchTo().defaultContent();
		
	}
	
	
}


public boolean isAlertPresent() //user defined method created to check alert is presetn or not
{
	try
	{
	driver.switchTo().alert();
	return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
	}
	
}

    
	

	
   @DataProvider(name="testdata")
	public Object[][] getDataFromDataprovider() throws IOException{
    	Object[][] object = null; 
    	XLUtils file = new XLUtils();
        
       
           sh = file.readExcel();
       //Find number of rows in excel file
     	int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
     	object = new Object[rowCount][2];
     	for (int i = 0; i < rowCount; i++) {
    		//Loop over all the rows
    		Row row = sh.getRow(i+1);
    		//Create a loop to print cell values in a row
    		for (int j = 0; j < row.getLastCellNum(); j++) {
    			//Print excel data in console
    			object[i][j] = row.getCell(j).toString();
    		}
         
    	}
     	System.out.println("");
     	  return object;	 
	}
	
   @AfterMethod
   public void closeBrowser() {
	   driver.close();
}
}