package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.instagram.qa.AbstractComponents.BaseClass;
import com.instagram.qa.AbstractComponents.Element;

public class ReelsPage extends BaseClass{
	
	
	//div[text()='Create new post']
	public By reel(int elm) {
		return By.xpath("//div[contains(@class,'xqmdsaz')]["+elm+"]");
	}
	
	By likeBy=By.xpath("//span//button[@type='button']//div[contains(@class,'_abl_')]");
	By likeValue=By.xpath("//button[contains(@class, '_abl-')]//div//span//*[local-name()='svg']");
	
		
	public void clicklikeBtn() {
		//waitForElementToDisappear();
		//waitForElement(likeBy);
		Element.clickElm(likeBy);	
	}
	
	public String likeBtnColor() {
	//	waitForElementToDisappear();
	//	waitForElement(likeValue);
		return Element.getAttributeValue(likeValue, "aria-label");
	}
	
	public WebElement scrollToElm(int elm) {
		return Element.getElement(reel(elm));
	}
	

	public void scrollReels(int elmNum) {		
		//waitForElement(reel(elmNum));		
		Actions action=new Actions(driver);
		action.scrollToElement(scrollToElm(elmNum)).perform();
		
	}
}
