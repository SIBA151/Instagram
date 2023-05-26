package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseClass;
import com.instagram.qa.pageObjects.CreatPage;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;

public class CreatPageTest extends BaseClass {
	
	
	LoginPage loginPage;
	HomePage homePage;
	CreatPage creatPage;
	
	@BeforeClass(alwaysRun=true)
	public void loginApp() {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		
		if(notific) {
			homePage=loginPage.loginApplication(prop.getEmail(), prop.getPassword());
			homePage.clickInfoNotNowBtn();
			if(notLogout) {
			homePage.clickNotNowBtn();
			}
		}
		//Click Creats Page Button
		creatPage=homePage.clickCreatsBtn();
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