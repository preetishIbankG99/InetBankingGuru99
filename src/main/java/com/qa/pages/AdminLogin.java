package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.utility.ElementHighlighter;
import com.qa.utility.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class AdminLogin extends TestBase {
//WebObjects Of LoginPage
    @FindBy(how= How.CSS,using = "input[name='uid']")
    @CacheLookup
    WebElement username;

    @FindBy(how= How.CSS,using = "input[name='password']")
    @CacheLookup
    WebElement password;

    @FindBy(how= How.CSS,using = "input[name='btnLogin']")
    @CacheLookup
    WebElement loginbtn;

    @FindBy(how= How.CSS,using = "input[name='btnReset']")
    @CacheLookup
    WebElement resetbtn;

    @FindBy(how=How.XPATH,using = "/html/body/div[1]/div[1]/div[1]/div[1]/a/img")
    @CacheLookup
    WebElement checklogo;

    @FindBy(how=How.XPATH,using = "//a[text()='Agile Project']")
    @CacheLookup
    WebElement linkverification;
    //creating Constructor for initializing PageObjects
    public AdminLogin()throws IOException{
        PageFactory.initElements(driver,this
        );
    }

    //Actions On LoginPage
    public void setUsername(String un) {
        username.sendKeys(un);
        ElementHighlighter.highLightElement(driver,username);
    }

    public void setPassword(String pwd) {

        password.sendKeys(pwd);
        ElementHighlighter.highLightElement(driver,password);
    }

    public void clickLoginbtn() {

        loginbtn.click();

    }

    public void clickResetbtn() {
        resetbtn.click();
    }

    public void Checklogo()throws IOException {
       boolean b= checklogo.isDisplayed();
     // Assert.assertTrue(false);//making deliberately false to check extentreport
       Assert.assertTrue(b);
        System.out.println("LogoVerified");

    }

    public void linkVerification() {
       String text= linkverification.getText();
        if(text.contains("Agile Project"));
        System.out.println("Link Verified successfully");
    }
}
