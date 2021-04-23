package com.qa.test;

import com.qa.base.TestBase;
import com.qa.pages.AdminLogin;
import com.qa.pages.NewCustomer;
import com.qa.utility.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.jetty.html.Page;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewCustomerTest extends TestBase {
    public static AdminLogin adminLogin;
    public static NewCustomer newCustomer;
    public NewCustomerTest()throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp()throws IOException,InterruptedException{
        initialization();

        adminLogin=new AdminLogin();
        adminLogin.setUsername(prop.getProperty("username"));
        adminLogin.setPassword(prop.getProperty("password"));
        adminLogin.clickLoginbtn();
        Thread.sleep(4000);
        newCustomer=new NewCustomer();
    }

@Test()
        public void newCustomerRegistrationLink()throws InvalidFormatException,IOException,InterruptedException{
            newCustomer.clickNewCustomerLink();
         logger.info(":::::New Customer Link Clicked::::::");
         newCustomer.setCustomerName("preetish");
         newCustomer.setRadioButton();
         newCustomer.setDateOfBirth("12-","07-","1990");
         newCustomer.setAddress("Rourkela");
         newCustomer.setCity("Infocity");
         newCustomer.setState("Odisha");
         newCustomer.setPin("768905");
         newCustomer.setEmail("preetxyz@gmail.com");
         newCustomer.setMobile("8790567789");
         newCustomer.setPassword("pass123@");
         newCustomer.setSubmitBtn();
         Thread.sleep(5000);
         newCustomer.checkCustId();
    }



    @AfterMethod
    public void tearDown(){
        driver.close();
}
}

