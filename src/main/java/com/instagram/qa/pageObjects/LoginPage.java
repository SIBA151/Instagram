package com.instagram.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.instagram.qa.AbstractComponents.AbstractCompnent;

public class LoginPage extends AbstractCompnent{

	WebDriver driver;
	
	@FindBy(xpath="//label//input[@name='username']") 
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Log in']") 
	WebElement loginBtn; 
	
	@FindBy(css="i[data-visualcompletion='css-img']")
	WebElement logo;
	
	@FindBy(xpath="//p[contains(text(),'your password was incorrect')]")
	WebElement errorMsg;
	
	@FindBy(xpath="//article[contains(@class, 'xkrivgy ')]//div[2]//div//div[2]//div//div//button//span[contains(text(), 'Continue as')]")
	WebElement ContinueBtn;
	
	@FindBy(xpath="//img[@alt='Get it on Google Play']") 
	WebElement googlePlayLink; 
	
	@FindBy(xpath="//img[@alt='Get it from Microsoft']") 
	WebElement microsoftLink; 
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loginApplication(String emailAdd, String pwd) {
		 userName.sendKeys(emailAdd);
		 password.sendKeys(pwd);
		 loginBtn.click();
		 return new HomePage(driver);
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	public boolean loginPageLogo() {
		return logo.isDisplayed();
	}
	
	public boolean loginPageErrorMsg() {
		return errorMsg.isDisplayed();
	}
	
	public boolean loginPageContinueBtn() {
		return ContinueBtn.isDisplayed();
	}
	
	public boolean loginPageGooglePlayLink() {
		return googlePlayLink.isDisplayed();
	}
	
	public boolean loginPageMicrosoftLink() {
		return microsoftLink.isDisplayed();
	}
	
	public HomePage loginPageContinueBtnClick() {
		 ContinueBtn.click();
		 return new HomePage(driver);
	}
	
	public void clearUserNameTxtField() {
		 userName.clear();
	}
	
	public void clearUserPasswordTxtField() {
		password.clear();
	}
	public void clearCredentialTxt() {
		clearUserNameTxtField();
		clearUserPasswordTxtField();
	}
	
	
}
