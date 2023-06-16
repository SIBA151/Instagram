package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseClass;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;

public class HomePageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeClass(alwaysRun=true)
	public void loginApp() {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		
		if(notific) {
		homePage=loginPage.loginApplication(prop.getEmail(), prop.getPassword());
		homePage.clickInfoNotNowBtn();
		homePage.clickNotNowBtn();
		}
		
	}
	
	@Test(priority=1, groups="smoke")
	public void verifyHomePageTitleAndLogo() {
		logger.info("***** TestCase Verify HomePage Title And Logo starts *****");
		
		Assert.assertEquals(homePage.homePageTitle(), "IInstagram");
		logger.info("HomePage Title Test pass");
		
		Assert.assertTrue(homePage.homePageLogo());	
		logger.info("HomePage Logo Test pass");
		
		logger.info("***** TestCase Verify HomePageTitle And Logo Ends *****"); 
	}
	
	
	@Test(priority=3, groups="smoke")
	public void verifyUserName() {
		logger.info("***** TestCase Verify User Name starts *****"); 
		Assert.assertEquals(homePage.getUserName(), prop.getUsernam());
		logger.info("***** TestCase Verify User Name Ends *****"); 
	}
	
	
	
	@Test(priority=4, groups="smoke")
	public void verifyHomePagefirstPostLikeBtn() {

		logger.info("***** TestCase verify HomePage first Post LikeBtn starts *****"); 
		homePage.postLikeBtn(1);
		//homePage.commentTextField(1, "Hii.");
		Assert.assertEquals(homePage.getLikeColor(1),"rgb(255, 48, 64)");
		logger.info("***** TestCase verify HomePage first Post LikeBtn Ends *****"); 
	}
	
	@Test(priority=5)
	@Parameters("HPnumOfScroll")
	public void verifyScrollAndLikePost(int numScrool) {
		logger.info("***** TestCase verify Scroll And Like Post starts *****"); 
		homePage.scrollAndLike(numScrool);
		Assert.assertEquals(homePage.getLikeColor(numScrool),"rgb(255, 48, 64)");
		logger.info("***** TestCase verify Scroll And Like Post Ends *****"); 
		
	}
	
	@Test(priority=6, enabled=true)
	public void verifyLogoutButtonTest() {
		logger.info("***** TestCase Verify Logout Button Test starts *****"); 
		homePage.clickLogoutBtn();
		Assert.assertTrue(loginPage.LoginPageLoginBtn());
		notLogout=false;
		logger.info("***** TestCase Verify Logout Button Test Ends *****"); 
	}
	
	@AfterClass(alwaysRun=true)
	public void logoutApp() {
		if(notLogout) {
			notific=false;
		}else {
			notific=true;
		}
		
		logger.info("All TestCases tested");
	}
	
}
