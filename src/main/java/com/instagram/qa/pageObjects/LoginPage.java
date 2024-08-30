package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;

import com.instagram.qa.AbstractComponents.BaseClass;
import com.instagram.qa.AbstractComponents.Element;

public class LoginPage extends BaseClass{
	
	By userNameBy=By.xpath("//label//input[@name='username']");
	By passwordBy=By.name("password");	
	By loginBtn=By.xpath("//div[text()='Log in']");
	By logo=By.cssSelector("i[aria-label='Instagram']");
	By errorMsg=By.xpath("//p[contains(text(),'your password was incorrect')]");
	By ContinueBtn=By.xpath("//article[contains(@class, 'xkrivgy ')]//div[2]//div//div[2]//div//div//button//span[contains(text(), 'Continue as')]");
	By googlePlayLink=By.xpath("//img[@alt='Get it on Google Play']");
	By microsoftLink=By.xpath("//img[@alt='Get it from Microsoft']");
	
	
	
	public LoginPage loginApplication(String emailAdd, String pwd) {
		Element.entryText(userNameBy, emailAdd);
		Element.entryText(passwordBy, pwd);
		return this;
	}
	
	public HomePage clickOnLoginButton() {
		Element.clickElm(loginBtn);
		 return new HomePage();
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean loginPageLogo() {
		return Element.isDisplay(logo);
	}
	
	public boolean LoginPageLoginBtn() {
		return Element.isDisplay(loginBtn);
	}
	
	public boolean loginPageErrorMsg() {
		return Element.isDisplay(errorMsg);
	}
	
	public boolean loginPageContinueBtn() {
		return Element.isDisplay(ContinueBtn);
	}
	
	public boolean loginPageGooglePlayLink() {
		return Element.isDisplay(googlePlayLink);
	}
	
	public boolean loginPageMicrosoftLink() {
		return Element.isDisplay(microsoftLink);
	}
	
	public HomePage loginPageContinueBtnClick() {
		Element.clickElm(ContinueBtn);
		 return new HomePage();
	}
	
	public void clearUserNameTxtField() {
		Element.clearText(userNameBy);
	}
	
	public void clearUserPasswordTxtField() {
		Element.clearText(passwordBy);
	}
	public void clearCredentialTxt() {
		clearUserNameTxtField();
		clearUserPasswordTxtField();
	}
	
	
}
