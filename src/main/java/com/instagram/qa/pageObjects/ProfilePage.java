package com.instagram.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instagram.qa.AbstractComponents.AbstractCompnent;

public class ProfilePage extends AbstractCompnent{

	@FindBy(xpath="//a[contains(@class,'xeuugli ')]//h2")
	WebElement userName;
	
	@FindBy(xpath="//div//div//span[contains(@class,\"_aacl _aaco _aacw _aacx _\")]")
	WebElement fullName;
	
	WebDriver driver;
	public ProfilePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getUsername() {
		return userName.getText();
	}
}
