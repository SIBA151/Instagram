package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseTest;
import com.instagram.qa.pageObjects.CreatPage;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;

public class CreatPageTest extends BaseTest {
	
	
	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	CreatPage creatPage = new CreatPage();
	
	String mailID = instaPagesProperties.getProperty("email");
	String password=instaPagesProperties.getProperty("password");
	
	@BeforeClass(alwaysRun=true)
	public void loginApp() {
		
		if(notific) {
			loginPage.loginApplication(mailID, password);
			loginPage.clickOnLoginButton();	
			if(notLogout) {
				homePage.clickInfoNotNowBtn();	
			    homePage.clickNotNowBtn();
			}
		}
		//Click Creats Page Button
		homePage.clickCreatsBtn();
		logger.info("Open Creat Page");
	}
	
	
	
	@Test(priority=1, groups="smoke")
	public void verifyCreatPageLabel() {
		logger.info("********** TestCase Verify Creat Page Label starts **********");
		
		Assert.assertTrue(creatPage.checkCreatPageLabel());
		logger.info("Creat Page Label Pass");
		logger.info("********** TestCase Verify Creat Page Label Ends **********");
	}
	
	@Test(priority=2)
	public void verifyfileUploadInstagaram() {
		logger.info("********** TestCase Verify File Upload Instagaram starts **********");
		creatPage.fileUploadInstagaram("cover.jpg");
		Assert.assertTrue(creatPage.successfulSharedMsg());
		logger.info("********** TestCase Verify File Upload Instagaram Ends **********");
	}
	
	@AfterClass(alwaysRun=true)
	public void closeCreatsPage() {
		
		//Close Creats Page
		creatPage.clickClosePage();
		logger.info("Close Creat Page");
		notific=false;
	}

}