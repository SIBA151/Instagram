package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instagram.qa.AbstractComponents.AbstractCompnent;

public class ReelsPage extends AbstractCompnent{

	WebDriver driver;
	
	
	//div[text()='Create new post']
	public By reel(int elm) {
		return By.xpath("//div[contains(@class,'xqmdsaz')]["+elm+"]");
	}
	
	By likeBy=By.xpath("//span//button[@type='button']//div[contains(@class,'_abl_')]");
	By likeValue=By.xpath("//button[contains(@class, '_abl-')]//div//span//*[local-name()='svg']");
	
	public ReelsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicklikeBtn() {
		waitForElement(reel(1));
		waitForElement(likeBy);
		getElement(likeBy).click();	
	}
	
	public String likeBtnColor() {
		waitForElement(likeValue);
		return getElement(likeValue).getAttribute("aria-label");
	}
	
	public WebElement scrollToElm(int elm) {
		return getElement(reel(elm));
	}
	

	public void scrollReels(int elmNum) {		
		waitForElement(reel(elmNum));		
		Actions action=new Actions(driver);
		action.scrollToElement(scrollToElm(elmNum)).perform();
		
	}
}
