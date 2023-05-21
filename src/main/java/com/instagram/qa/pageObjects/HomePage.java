package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instagram.qa.AbstractComponents.AbstractCompnent;

public class HomePage extends AbstractCompnent{

	WebDriver driver;
	
	@FindBy(css="svg[aria-label='Instagram']")
	WebElement homePageLogo;
	
	@FindBy(linkText="Reels")
	WebElement reels;
	
	@FindBy(linkText="Create")
	WebElement creat;
	
	@FindBy(xpath="//img[contains(@alt, 'profile picture')]//parent :: span")
	WebElement profile;
	
	@FindBy(xpath="//div[text()='Save Your Login Info?']")
	WebElement saveYourLoginNotification;
	
	@FindBy(xpath="//div[text()='Not Now']")
	WebElement infoNotNowBtn;
	
	@FindBy(xpath="//button[text()='Not Now']")
	WebElement notNowBtn;
	
	@FindBy(xpath="//span//div[contains(@class, 'xeuugli')]//a")
	private WebElement userName;
	
	@FindBy(xpath="//div//*[@aria-label='Settings']")
	private WebElement moreBtn;
	
	@FindBy(xpath="//span[text()='Log out']")  
	private WebElement logoutBtn;
	
	@FindBy(xpath="//img[contains(@alt,'profile picture')]")  
	private WebElement profileBtn;
	
	public By post(int elm) {
		return By.xpath("//article[@role='presentation']["+elm+"]");
	}
	
	//Like Element
	public By likeBtn(int elm) {
		return By.xpath("//article[@role='presentation']["+elm+"]//div//div[3]//div//div//section//span");
	}
	
	//Comment Button Element
	public By commentBtn(int elm) {
		return By.xpath("//article[@role='presentation']["+elm+"]//div//div[3]//div//div//section//span[2]");
	}
	
	//Comment Field Element
	public By commentField(int elm) {
		return By.xpath("//article[@role='presentation']["+elm+"]//div//div[3]//div//div//section[3]//div");
	}
	
	public By totalNumOfComm(int elm) {
		return By.xpath("//article[@role='presentation']["+elm+"]//div//div[3]//div//div//div//div[2]//a//span[contains(@class,'xhkezso ')]//span");
	}
	
	public By likeColor(int elm) {
		return By.xpath("//article[@role='presentation']["+elm+"]//div//div[3]//div//div//section//span//button//div//span//*[local-name()='svg']");
	}
	
	By notNowBy=By.xpath("//button[text()='Not Now']");
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean homePageLogo() {
		return homePageLogo.isDisplayed();
	}
	
	public ReelsPage clickReelsBtn() {
		reels.click();
		return new ReelsPage(driver);
	}
	
	public CreatPage clickCreatsBtn() {
		creat.click();
		return new CreatPage(driver);
	}
	public String getUserName() {
		return userName.getText();
	}
	
	public boolean checkSaveYourLoginNotification() {
		return saveYourLoginNotification.isDisplayed();
	}
	
	public void clickInfoNotNowBtn() {
		infoNotNowBtn.click();
	}
	
	public void clickNotNowBtn() {
		waitForElement(notNowBy);
		notNowBtn.click();
	}
	
	public void postLikeBtn(int elm) {
		 getElement(likeBtn(elm)).click();
	}
	
	public void commentTextField(int elm, String txt) {
		 getElement(commentField(elm)).sendKeys(txt);
	}
	
	public String getTotalNumOfComm(int elm) {
		 return getElement(totalNumOfComm(elm)).getText();
	}
	
	public String getLikeColor(int elm) {
		waitForElement(likeColor(elm));
		return getElement(likeColor(elm)).getAttribute("color");
	}
	
	public WebElement scrollToElm(int elm) {
		return getElement(post(elm));
	}
	public void scrollAndLike(int numScroll) {
		Actions action=new Actions(driver);
		for(int i=1; i<=numScroll; i++) {
			
			waitForElement(post(i));
			action.scrollToElement(scrollToElm(i)).perform();
			waitForElement(likeBtn(i));
			postLikeBtn(i);
			
		}
	}
	
	//Logout Button
	public LoginPage clickLogoutBtn() {
		moreBtn.click();
		logoutBtn.click();
		return new LoginPage(driver);
	}
	

}
