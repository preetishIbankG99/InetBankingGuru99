package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class NewCustomer extends TestBase {
    @FindBy(how= How.XPATH,using = "//a[text()='New Customer']")
    @CacheLookup
    WebElement NewCustomerLink;

    @FindBy(how=How.CSS,using = "input[name='name']")
    @CacheLookup
    WebElement CustomerName;

    @FindBy(how=How.CSS,using = "input[name='rad1'][ value='m']")
    @CacheLookup
    WebElement RadioButton;

    @FindBy(how=How.CSS,using = "input[name='dob']")
    @CacheLookup
    WebElement DateOfBirth;

    @FindBy(how=How.CSS,using = "textarea[name='addr']")
    @CacheLookup
    WebElement Address;

    @FindBy(how=How.CSS,using = "input[name='city']")
    @CacheLookup
    WebElement City;

    @FindBy(how=How.CSS,using="input[name='state']")
    @CacheLookup
    WebElement State;

    @FindBy(how=How.CSS,using="input[name='pinno']")
    @CacheLookup
    WebElement Pin;

    @FindBy(how=How.CSS,using="input[name='telephoneno']")
    @CacheLookup
    WebElement Mobile;

    @FindBy(how=How.CSS,using ="input[name='emailid']")
    @CacheLookup
    WebElement Email;

    @FindBy(how = How.CSS,using = "input[name='password']")
    @CacheLookup
    WebElement Password;

    @FindBy(how=How.CSS,using = "input[name='sub']")
    @CacheLookup
    WebElement SubmitBtn;
    @FindBy(how=How.XPATH,using = "//td[text()='Customer ID']")
    @CacheLookup
    WebElement CustId;
    //creating Constructor for initializing PageObjects
    public NewCustomer()throws IOException {
        PageFactory.initElements(driver,this);
    }
public void clickNewCustomerLink(){
        NewCustomerLink.click();
}

    public void setCustomerName(String data) {
        CustomerName.sendKeys(data);
    }

    public void setRadioButton() {
        RadioButton.click();
    }
public void setDateOfBirth(String dd,String mm,String yy)throws InterruptedException{
DateOfBirth.sendKeys(dd);
    DateOfBirth.sendKeys(mm);
    DateOfBirth.sendKeys(yy);
}
public void setAddress(String data){
    Address.sendKeys(data);
}

    public void setCity(String data) {
        City.sendKeys(data);
    }

    public void setState(String data) {
        State.sendKeys(data);
    }

    public void setPin(String data) {
        Pin.sendKeys(data);
    }

    public void setMobile(String data) {
        Mobile.sendKeys(data);
    }

    public void setEmail(String data) {
        Email.sendKeys(data);
    }

    public void setPassword(String data) {
        Password.sendKeys(data);
    }

    public void setSubmitBtn() {
        SubmitBtn.click();
    }
     public void checkCustId(){
         System.out.println(CustId.getText());
     }
}
////td[text()='Customer ID']