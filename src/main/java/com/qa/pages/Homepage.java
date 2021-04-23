package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
//Guru99 Bank Manager HomePage

public class Homepage extends TestBase {

@FindBy(how=How.XPATH,using = "//a[text()='New Account']")
@CacheLookup
WebElement NewAccount;





    public Homepage()throws IOException,FileNotFoundException{
        PageFactory.initElements(driver,this);
    }


public void checkNewAccountLink(){
NewAccount.click();
logger.info("::New Account Clicked::");
}





}
