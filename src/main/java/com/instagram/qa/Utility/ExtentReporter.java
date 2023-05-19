package com.instagram.qa.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports getReport() {
		ConfigRead configRead=new ConfigRead();
		
		ExtentSparkReporter htmlReport= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//Instagram_Result.html");
		ExtentReports reports= new ExtentReports();
		reports.attachReporter(htmlReport);
		
		htmlReport.config().setDocumentTitle("Instagram_Result_Report");
		htmlReport.config().setReportName("Happy_path_Result");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	    
		reports.setSystemInfo("Machine", "Dell");
		reports.setSystemInfo("OS", "Windos10");
		reports.setSystemInfo("Browser", configRead.getBrowser());
		
		return reports;
	}
}
