package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseClass;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;
import com.instagram.qa.pageObjects.ReelsPage;
import com.instagram.qa.TestComponents.RetryTest;

public class ReelsPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ReelsPage reelsPage;
	
	@BeforeClass(alwaysRun=true)
	public void loginApp() {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		
		if(notific) {
			homePage=loginPage.loginApplication(prop.getUsername(), prop.getPassword());
			homePage.clickInfoNotNowBtn();
			homePage.clickNotNowBtn();
			}
		//Click Reels Button
		reelsPage=homePage.clickReelsBtn();
		logger.info("Open Reels Page");
	}
	
	//retryAnalyzer=RetryTest.class
	@Test(priority=1,groups="smoke")
	public void verifyLikeFirstReel() {	
		logger.info("********** TestCase Verify Like FirstReel Start **********"); 
		reelsPage.clicklikeBtn();
		logger.info("Click Like Button");
		Assert.assertEquals(reelsPage.likeBtnColor(), "Unlike");
		logger.info("********** TestCase Verify Home Page Title Ends **********"); 
		
	}
	
	@Test(priority=2, retryAnalyzer=RetryTest.class)
	public void VerifytheScroolReels() {
		logger.info("********** TestCase Verify The Scrool Reels Starts **********");
		reelsPage.scrollReels(5);
		logger.info("********** TestCase Verify The Scrool Reels Ends **********"); 
		
	}
	
	@AfterClass(alwaysRun=true)
	public void logoutApp() {
		if(notific) {
			homePage.clickLogoutBtn();
		}else {
			logger.info("All TestCases tested");
		}
	}
}
