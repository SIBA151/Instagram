package com.instagram.qa.AbstractComponents;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractCompnent {

	WebDriver driver;
	
	public AbstractCompnent(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getElement(By locator) {
		WebElement elm = driver.findElement(locator);
		return elm;
	}
	public void waitForElement(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
