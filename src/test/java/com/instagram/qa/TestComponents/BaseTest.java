package com.instagram.qa.TestComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.instagram.qa.AbstractComponents.BaseClass;
import com.instagram.qa.Utility.ConfigRead;


public class BaseTest extends BaseClass	{
	public static ConfigRead prop = new ConfigRead();
	public static boolean notific = true;
	public static boolean notLogout = true;
	public Logger logger = LogManager.getLogger("Instagram");
	
	protected Properties instaPagesProperties = ConfigRead.getProValue("static_data");
		
	String browserName = instaPagesProperties.getProperty("browser");
	String url = instaPagesProperties.getProperty("baseUrl");

	@BeforeSuite(alwaysRun = true)
	public void initialization() {
		browserSetup(browserName);
		driver.get(url);
	}

	@AfterSuite(alwaysRun = true, enabled=false)
	public void tearDown() {
		driver.quit();
	}

	// Take Screenshot method
	public String takeScreenshot(String screenShotName) {
		
		String dateName= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir") + "\\Screenshot\\" + screenShotName+dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(screenshotpath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String jenkinsScreenshotPath="http://localhost:8080/job/InstagarmWithGit/ws/Screenshot/"+screenShotName+dateName + ".png";
		
		String runJenkins = System.getProperty("jenkins") != null ? jenkinsScreenshotPath : screenshotpath;
		return runJenkins;
	}
}
