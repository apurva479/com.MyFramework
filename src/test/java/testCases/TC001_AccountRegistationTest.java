package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistationTest extends BaseClass {
	
	@Test(groups="Regression")
	public void verify_account_registation() {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver); 
		regPage.SetFirstName(randomeString().toUpperCase());
		regPage.SetLastName(randomeString().toUpperCase());
		regPage.SetEmailID(randomeString()+"@gmail.com");
		regPage.SetMobileNo(randomeNumber());
		
		String password=randomeAlphaNumberic();
		
		regPage.SetPassword(password);
		regPage.SetConfirmPassword(password);
		regPage.SetPrivacyPolicy();
		regPage.ClickContinue();
		
		String confmMsg=regPage.getConfirmationMsg();
		Assert.assertEquals(confmMsg, "Your Account Has Been Created!");
	}
	
	
		
		
	}
	


