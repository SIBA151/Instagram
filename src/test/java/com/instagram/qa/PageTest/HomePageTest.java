package com.instagram.qa.PageTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.instagram.qa.TestComponents.BaseTest;
import com.instagram.qa.pageObjects.HomePage;
import com.instagram.qa.pageObjects.LoginPage;

public class HomePageTest extends BaseTest {

	LoginPage loginPage=new LoginPage();
	HomePage homePage=new HomePage();
	
	String mailID = instaPagesProperties.getProperty("email");
	String password=instaPagesProperties.getProperty("password");
	String userName=instaPagesProperties.getProperty("username");
	
	@BeforeClass(alwaysRun=true)
	public void loginApp() {		
		if(notific) {
		loginPage.loginApplication(mailID, password);
		loginPage.clickOnLoginButton();	
		homePage.clickInfoNotNowBtn();
		homePage.clickNotNowBtn();
		}
		
	}
	
	@Parameters("HPnumOfScroll")
	@Test(groups="smoke")
	public void verifyHomePageTC(int numScrool) {
		logger.info("***** TestCase verifyHomePageTC start *****");
		
		Assert.assertEquals(homePage.homePageTitle(), "Instagram");
		logger.info("HomePage Title Test pass");
		
		Assert.assertTrue(homePage.homePageLogo());	
		logger.info("HomePage Logo Test pass");
		
		Assert.assertEquals(homePage.getUserName(), userName);
		logger.info("***** TestCase Verify User Name End *****"); 

		homePage.postLikeBtn(1);
		//homePage.commentTextField(1, "Hii.");
		Assert.assertEquals(homePage.getLikeColor(1),"0 0 48 48");
		
		homePage.scrollAndLike(numScrool);
		Assert.assertEquals(homePage.getLikeColor(numScrool),"rgb(255, 48, 64)");
		
		homePage.clickLogoutBtn();
		Assert.assertTrue(loginPage.LoginPageLoginBtn());
		notLogout=false;
		logger.info("***** TestCase verifyHomePageTC End *****"); 
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
