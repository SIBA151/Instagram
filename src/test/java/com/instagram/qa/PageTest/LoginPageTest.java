package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseTest;
import com.instagram.qa.Utility.ReadExcelFile;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;

public class LoginPageTest extends BaseTest{
	
	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	
	String mailID = instaPagesProperties.getProperty("email");
	String password=instaPagesProperties.getProperty("password");
	
	@Test(priority=1, groups="smoke")
	public void verifyLoginPage() {
		logger.info("***** Verify Login Page start *****");
		
		Assert.assertEquals(loginPage.loginPageTitle(), "Instagram");
		logger.info("Title Test Pass");
		Assert.assertTrue(loginPage.loginPageLogo());
		logger.info("Logo Test Pass");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(loginPage.loginPageGooglePlayLink());
		logger.info("Google Play Link Pass");
		
		Assert.assertTrue(loginPage.loginPageMicrosoftLink());
		logger.info("Google Play Link Pass");
		
		loginPage.loginApplication(mailID, password);
		loginPage.clickOnLoginButton();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.clickInfoNotNowBtn();
		homePage.clickNotNowBtn();
		
		Assert.assertTrue(homePage.homePageLogo());
		
		homePage.clickMoreBtn();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.clickLogoutBtn();
		
		notific=false;
		logger.info("***** Verify Login Page Ends *****");	
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return ReadExcelFile.getTestData("Login");
	}
	
	@Test(priority=5, dataProvider="getLoginData", enabled=false)
	public void loginWithDifferentCrd(String username, String password, String scenario) {
		logger.info("********* Verify Login Test with multiple data sets Starts**********"); 	
		
		loginPage.loginApplication(username, password);
		homePage=loginPage.clickOnLoginButton();
		
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
		logger.info("********** Verify Login Test with multiple data sets Ends**********");
	}
	
	
}
