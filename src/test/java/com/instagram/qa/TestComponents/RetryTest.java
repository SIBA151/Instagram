package com.instagram.qa.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{

	int count=0, maxTry=1;

	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry) {
			count++;
			return true;
		}
		return false;
	}
}
