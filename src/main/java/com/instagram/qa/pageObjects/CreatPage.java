package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instagram.qa.AbstractComponents.AbstractCompnent;
import com.instagram.qa.Utility.FileUpload;

public class CreatPage extends AbstractCompnent{

	WebDriver driver;
	
	@FindBy(xpath="//div[text()='Create new post']")
	WebElement creatPageLabel;
	
	@FindBy(xpath="//button[text()='Select from computer']")
	WebElement uploadBtn;
	
	@FindBy(xpath="//div[text()='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath="//div[text()='Share']")
	WebElement shareBtn;
		
	
	@FindBy(xpath="//div//*[@aria-label='Close']")
	WebElement close;
	
	By successfulShared= By.xpath("//span[text()='Your post has been shared.']");
	
	
	public CreatPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickUploadBtn() {
		uploadBtn.click();
	}
	
	public void uploadPic(String name) {
		FileUpload.fileUpload(System.getProperty("user.dir")+"\\PhotosAndVideos\\"+name);	
	}
	
	public void clickNextBtn() {
		nextBtn.click();
	}
	
	public void clickShareBtn() {
		shareBtn.click();
	}

	public boolean checkCreatPageLabel() {
		return creatPageLabel.isDisplayed();
	}
	
	public boolean successfulSharedMsg() {
		waitForElement(successfulShared);
		return getElement(successfulShared).isDisplayed();
	}
	
	public void fileUploadInstagaram(String name) {
		clickUploadBtn();
		uploadPic(name);
		clickNextBtn();
		clickNextBtn();
		shareBtn.click();
	}
	
	public HomePage clickClosePage() {
		close.click();
		return new HomePage(driver);
	}
}
