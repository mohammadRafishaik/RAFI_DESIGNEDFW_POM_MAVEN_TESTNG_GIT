package com.testcases;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.webpages.Loginpage;

public class Projectlogin extends BaseClass
{
//	 WebDriver driver;

	public Loginpage web;
@Test(priority=0)
public void pageLogin() throws InterruptedException 
{
	//timeconcern();

	logger=	report.createTest("login Elevate App");
	web=PageFactory.initElements(driver, Loginpage.class);
	logger.info("Elevate  login");
	web.loginhrm(excel.getstringgetdata("Sheet1", 1, 0), excel.getstringgetdata("Sheet1", 1, 1));
	logger.pass("Successfully open Elevate App");

//	web.manifestcreation();
}
@Test(priority=1)
	public void creationofmanifest() throws InterruptedException 
	
	{
	web.manifestcreation();
	}

	
	
	


}
