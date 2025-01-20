package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;


@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;
	

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEmailID;


@FindBy(xpath="//input[@id='input-telephone']") 
WebElement txtphnNo;

@FindBy(xpath="//input[@id='input-password']") 
WebElement txtpasswrd;


@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtconfirmpwd;

@FindBy(xpath="//input[@name='agree']") 
WebElement btnagreechk;

@FindBy(xpath="//input[@value='Continue']") 

WebElement btncontinue;


@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;


public void SetFirstName(String fname) {
	txtFirstName.sendKeys(fname);
}
public void SetLastName(String lname) {
	txtLastName.sendKeys(lname);
}
public void SetEmailID(String email) {
	txtEmailID.sendKeys(email);
	}
public void SetMobileNo(String mobileNo) {
	txtphnNo.sendKeys(mobileNo);
	}

public void SetPassword(String password) {
	txtpasswrd.sendKeys(password);}
public void SetConfirmPassword(String confirmpassword) {
	txtconfirmpwd.sendKeys(confirmpassword);
}
public void SetPrivacyPolicy() {
	btnagreechk.click();
}
public void ClickContinue() {
	btncontinue.click();
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}
	catch(Exception e) {
		return (e.getMessage());
	}
}






	
	


	

}
