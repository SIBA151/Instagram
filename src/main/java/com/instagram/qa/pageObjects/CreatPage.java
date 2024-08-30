package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;

import com.instagram.qa.AbstractComponents.BaseClass;
import com.instagram.qa.AbstractComponents.Element;
import com.instagram.qa.Utility.FileUpload;

public class CreatPage extends BaseClass{
	
	By creatPageLabel=By.xpath("//div[text()='Create new post']");
	By uploadBtn=By.xpath("//button[text()='Select from computer']");
	By nextBtn=By.xpath("//div[text()='Next']");
	By shareBtn=By.xpath("//div[text()='Share']");
	By close=By.xpath("//div//*[@aria-label='Close']");
	By successfulShared= By.xpath("//span[text()='Your post has been shared.']");
		
	
	public void clickUploadBtn() {
		Element.clickElm(uploadBtn);
	}
	
	public void uploadPic(String name) {
		FileUpload.fileUpload(System.getProperty("user.dir")+"\\PhotosAndVideos\\"+name);	
	}
	
	public void clickNextBtn() {
		Element.clickElm(nextBtn);
	}
	
	public void clickShareBtn() {
		Element.clickElm(shareBtn);
	}

	public boolean checkCreatPageLabel() {
		return Element.isDisplay(creatPageLabel);
	}
	
	public boolean successfulSharedMsg() {
		//waitForElement(successfulShared);
		return Element.isDisplay(successfulShared);
	}
	
	public void fileUploadInstagaram(String name) {
		clickUploadBtn();
		uploadPic(name);
		clickNextBtn();
		clickNextBtn();
		Element.clickElm(shareBtn);
	}
	
	public HomePage clickClosePage() {
		Element.clickElm(close);
		return new HomePage();
	}
}
