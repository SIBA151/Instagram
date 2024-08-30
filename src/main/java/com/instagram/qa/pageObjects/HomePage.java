package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.instagram.qa.AbstractComponents.BaseClass;
import com.instagram.qa.AbstractComponents.Element;

public class HomePage extends BaseClass{
	By homePageLogo=By.cssSelector("svg[aria-label='Instagram']");
	By reels=By.linkText("Reels");
	By creat=By.linkText("Create");
	By profile=By.xpath("//img[contains(@alt, 'profile picture')]//parent :: span");
	By saveYourLogin=By.xpath("//div[text()='Save your login info?']");
	By infoNotNowBtn=By.xpath("//div[text()='Not now']");
	By notNowBtn=By.xpath("//button[text()='Not Now']");
	By userName=By.xpath("//span//div[contains(@class, 'xeuugli')]//a");
	By moreBtn=By.xpath("//div//*[@aria-label='Settings']");
	By logoutBtn=By.xpath("//span//span[text()='Log out']");
	By profileBtn=By.xpath("//img[contains(@alt,'profile picture')]");
	
	
	
	
	public By post(int elm) {
		return By.xpath("//article[@role='presentation']["+elm+"]");
	}
	
	//Like Element
	public By likeBtn(int elm) {
		return By.xpath("//article["+elm+"]//div//div//div//div//div//div//span//div//div//span//*[local-name()='svg' and @aria-label='Like']");
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
		return By.xpath("//article["+elm+"]//div//div//div//div//div//div//span//div//div//span//*[local-name()='svg']");
	}
	
	
	
	
	//Action Methods
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public boolean homePageLogo() {
		return Element.isDisplay(homePageLogo);
	}
	
	public ReelsPage clickReelsBtn() {
		Element.clickElm(reels);
		return new ReelsPage();
	}
	
	public CreatPage clickCreatsBtn() {
		Element.clickElm(creat);
		return new CreatPage();
	}
	
	public String getUserName() {
		return Element.getText(userName);
	}
	
	public boolean checkSaveYourLoginNotification() {
		return Element.isDisplay(saveYourLogin);
	}
	
	public void clickInfoNotNowBtn() {
		Element.waitForElement(infoNotNowBtn);
		Element.clickElm(infoNotNowBtn);
	}
	
	public void clickNotNowBtn() {
		Element.waitForElement(notNowBtn);
		Element.clickElm(notNowBtn);
	}
	
	public void postLikeBtn(int elm) {
		Element.clickElm(likeBtn(elm));
	}
	
	public void commentTextField(int elm, String txt) {
		Element.entryText(commentField(elm),txt);
	}
	
	public String getTotalNumOfComm(int elm) {
		 return Element.getText(totalNumOfComm(elm));
	}
	
	public String getLikeColor(int elm) {
		//waitForElement(likeColor(elm));
		return Element.getAttributeValue(likeColor(elm), "viewBox");
	}
	
	public WebElement scrollToElm(int elm) {
		return Element.getElement(post(elm));
	}
	
	public void scrollAndLike(int numScroll) {
		Actions action=new Actions(driver);
		for(int i=1; i<=numScroll; i++) {		
			//waitForElement(post(i));
			action.scrollToElement(scrollToElm(i)).perform();
			//waitForElement(likeBtn(i));
			postLikeBtn(i);			
		}
	}
	
	public HomePage clickMoreBtn() {
		Element.clickElm(moreBtn);
		return this;
	}
	
	//Logout Button
	public LoginPage clickLogoutBtn() {
		Element.clickElm(logoutBtn);
		return new LoginPage();
	}
	

}
