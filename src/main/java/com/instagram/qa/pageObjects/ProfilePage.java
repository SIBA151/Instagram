package com.instagram.qa.pageObjects;

import org.openqa.selenium.By;

import com.instagram.qa.AbstractComponents.BaseClass;
import com.instagram.qa.AbstractComponents.Element;

public class ProfilePage extends BaseClass{

	
	
	By userName=By.xpath("//a[contains(@class,'xeuugli ')]//h2");
	By fullName=By.xpath("//div//div//span[contains(@class,'_aacl _aaco _aacw _aacx _')]");
	
	public String getUsername() {
		return Element.getText(userName);
	}
}
