package com.instagram.qa.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element extends BaseClass{

	static WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	
	public static WebElement getElement(By element) {
		return driver.findElement(element);
	}
	
	public static String getText(By element) {
		return driver.findElement(element).getText();
	}
	
	public static String getAttributeValue(By element, String attribute) {
		return driver.findElement(element).getAttribute(attribute);
	}
	
	public static void entryText(By element, String value) {
		clearText(element);
		driver.findElement(element).sendKeys(value);
	}
	
	public static void clickElm(By element) {
		driver.findElement(element).click();
	}
	
	public static void clearText(By element) {
		driver.findElement(element).sendKeys(Keys.CONTROL + "a");
		driver.findElement(element).sendKeys(Keys.DELETE);
	}
	
	public static boolean isDisplay(By element) {
		return driver.findElement(element).isDisplayed();
	}
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
	public static void waitForElement(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
}
