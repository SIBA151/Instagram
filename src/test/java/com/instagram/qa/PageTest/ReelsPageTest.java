package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseTest;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;
import com.instagram.qa.pageObjects.ReelsPage;
import com.instagram.qa.TestComponents.RetryTest;

public class ReelsPageTest extends BaseTest {

	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	ReelsPage reelsPage = new ReelsPage();
	
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
		//Click Reels Button
		homePage.clickReelsBtn();
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
		notific=false;
		logger.info("All TestCases tested");
		
	}
}
