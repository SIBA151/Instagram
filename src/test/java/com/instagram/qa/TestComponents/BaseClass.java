package com.instagram.qa.TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.instagram.qa.Utility.ConfigRead;

public class BaseClass {
	public static ConfigRead prop;
	public static WebDriver driver;
	public static boolean notific= true;
	public static boolean notLogout= true;
	public Logger logger=LogManager.getLogger("Instagram");

	public BaseClass() {
		prop=new ConfigRead();
	}
    
	public void browserSetup() {
		String broName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getBrowser();

		switch(broName.toLowerCase()){
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default :
			driver=null;
			break;

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
	}

	@BeforeSuite(alwaysRun=true)
	public void initialization () {
		browserSetup();
		driver.get(prop.getBaseURL());
	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	

	//Take Screenshot method
	public String takeScreenshot(String screenShotName) {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(".//ScreenShot//"+screenShotName+".png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}

		return System.getProperty("user.dir")+"\\ScreenShot\\"+screenShotName+".png";
	}
}
