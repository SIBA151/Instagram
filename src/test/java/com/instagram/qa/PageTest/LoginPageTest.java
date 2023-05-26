package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseClass;
import com.instagram.qa.Utility.ReadExcelFile;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeClass(alwaysRun=true)
	public void loginApp() {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);	
	}
	
	@Test(priority=1, groups="smoke")
	public void verifyLoginPageTitleAndLogo() {
		logger.info("***** TestCase Verify Login Page Title And Logo starts *****");
		
		Assert.assertEquals(loginPage.loginPageTitle(), "Instagram");
		logger.info("Title Test Pass");
		Assert.assertTrue(loginPage.loginPageLogo());
		logger.info("Logo Test Pass");
		logger.info("***** TestCase Verify Login Page Title And Logo Ends *****"); 
	}
	
	@Test(priority=2, groups="smoke")
	public void verifyLoginPageGooglePlayLink() {
		logger.info("***** TestCase Verify Login Page Google Play Link Starts *****");
		Assert.assertTrue(loginPage.loginPageGooglePlayLink());
		logger.info("Google Play Link Pass");
		logger.info("***** TestCase Verify Verify Login Page Google Play Link Ends *****"); 	
	}
	
	@Test(priority=3, groups="smoke")
	public void verifyLoginPageMicrosoftLink() {
		logger.info("***** TestCase Verify Login Page Google Play Link Starts *****");
		Assert.assertTrue(loginPage.loginPageMicrosoftLink());
		logger.info("Google Play Link Pass");
		logger.info("***** TestCase Verify Verify Login Page Google Play Link Ends *****"); 	
	}
	
	@Test(priority=4, groups="smoke", enabled=true)
	public void verifyLoginAppWithValiedCredentials() {
		logger.info("***** TestCase Verify LoginApp With Valied Credentials Starts *****"); 
		
		homePage=loginPage.loginApplication(prop.getEmail(), prop.getPassword());
		homePage.clickInfoNotNowBtn();
		homePage.clickNotNowBtn();
		
		Assert.assertTrue(homePage.homePageLogo());
		//homePage.clickLogoutBtn();
		
		notific=false;
		logger.info("***** TestCase Verify LoginApp With Valied Credentials Ends *****");	
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return ReadExcelFile.getTestData("Login");
	}
	
	@Test(priority=5, dataProvider="getLoginData", enabled=false)
	public void loginWithDifferentCrd(String username, String password, String scenario) {
		logger.info("**********TestCase verify Login Test with multiple data sets Starts**********"); 	
		
		homePage=loginPage.loginApplication(username, password);
		
		if(scenario.equals("bothcorrect")) {
			Assert.assertTrue(homePage.checkSaveYourLoginNotification());
			homePage.clickInfoNotNowBtn();
			homePage.clickNotNowBtn();
			homePage.clickLogoutBtn();
		    loginPage.clearCredentialTxt();
			
		}else if(scenario.equals("wrongcredentials")){
			Assert.assertTrue(loginPage.loginPageErrorMsg());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			loginPage.clearCredentialTxt();
			notific=false;
		}
		logger.info("**********TestCase verify Login Test with multiple data sets Ends**********");
	}
	
	
}
