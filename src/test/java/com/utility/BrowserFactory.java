package com.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
static WebDriver driver;
	public static WebDriver launchbrowser(String browserName,String projectURL) 
	{
		
		if(browserName.equals("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gicko.driver", "C:\\Users\\TT089\\eclipse-workspace\\SeleniumFWPOMMJGTNG\\SeleniumFW\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{	
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Browser is not defined.So Please give correct browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(projectURL);
		return driver;
	}	
	public static void closethewindow(WebDriver driver) {
		driver.close();
		
		
	}
	public static void scr(String name) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File Destination=new File("C:\\Users\\TT089\\eclipse-workspace\\SeleniumFWPOMMJGTNG\\SeleniumFW\\Screenshots\\+name+\\.png");
		
	
	}
	
}
