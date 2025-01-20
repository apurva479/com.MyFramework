package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")
	public void verify_LoginDDT(String email,String password,String exp) {
		try {
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	
	//LoginPage
	LoginPage lp=new LoginPage(driver);
	lp.setEmailAddress(email);
	
	lp.setPassword(password);
	lp.ClickLogin();
	
	
	//MyAccountPage
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	
	
	
	/* if data is valid - login success - testcase pass -logout
	 *                                   - login failed- test fail
	 * 
	 * data invalid- login sucess -  test fail -logout
	 *                               - test fail -test case passed
	 */
	
	if(exp.equalsIgnoreCase("Valid")) {
		if(targetPage==true) {
			macc.clickLogout();
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("Invalid")) {
		if(targetPage==true) {
			macc.clickLogout();
			Assert.assertTrue(false);
	}
		else {
			Assert.assertTrue(true);
		}
	}}
	catch(Exception e) {
		Assert.fail();
		
	}}}
	
	
