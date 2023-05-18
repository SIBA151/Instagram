package com.instagram.qa.AbstractComponents;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void fileUpload(String string) {
		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		
		
		StringSelection str=new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.delay(300);
		// press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	}
}
