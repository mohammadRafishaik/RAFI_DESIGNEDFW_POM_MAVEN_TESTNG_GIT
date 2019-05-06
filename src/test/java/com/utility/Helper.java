package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String capturescreenshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String Screenshotpath=System.getProperty("user.dir") + "/Screenshots/Elevate_Application_"+gettimestamp()+".png";
		File source=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(source, new File(Screenshotpath));
		} catch (IOException e) {
			System.out.println("unable to take screenshot "+e.getMessage());
		}
		return Screenshotpath;
		
	}

	public static String gettimestamp() {
		DateFormat datevalue=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdateformet=new Date();
		
		return datevalue.format(currentdateformet);
	}
}
