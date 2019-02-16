package com.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.Configfiledata;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public Configfiledata propertiefile;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void Excelload() {
		Reporter.log("Test Is Start and trying to load every thing", true);
	excel=new ExcelDataProvider();
	propertiefile=new Configfiledata();
	
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File (System.getProperty("user.dir")+"/Reports/HRM+"+Helper.gettimestgamp()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	Reporter.log("Test Is Start and trying to load every thing is done", true);

	}
	@BeforeClass
	public void intialexecution() {
		Reporter.log("Browser trying to start", true);

		//driver=BrowserFactory.launchbrowser("Chrome", "http://www.testingmasters.com/hrm/symfony/web/index.php/auth/login");
		driver=BrowserFactory.launchbrowser(propertiefile.getbrowser(), propertiefile.getweburl());
		Reporter.log("Browser is launched Done", true);

	}
	
	@AfterClass
	public void EndExecution() {
	Reporter.log("Trying to close window", true);

	BrowserFactory.closethewindow(driver);	
	Reporter.log("Window is closed", true);

	}
	
	@AfterMethod
	public void getscreenshot(ITestResult result) {
		//if(result.getStatus()==ITestResult.FAILURE) {
		Reporter.log("End of the Execution", true);

		if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.capturescreenshot(driver);
			try {
				logger.pass("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
			} 
			catch (Exception  e) {
				System.out.println(" unable to get screensshot for Success case "+e.getMessage());
			}
		}
			else if(result.getStatus()==ITestResult.FAILURE) {
				
				Helper.capturescreenshot(driver);
				try {
					logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
				} catch (Exception  e) {
					System.out.println(" unable to get screensshot for Success case "+e.getMessage());
				}
				
			}
		
		report.flush();
		Reporter.log("Execution is done ....>> Check The Reports of HTML", true);

	}
	
}
