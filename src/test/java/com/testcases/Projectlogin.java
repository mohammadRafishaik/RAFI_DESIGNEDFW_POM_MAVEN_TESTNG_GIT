package com.testcases;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.webpages.Loginpage;

public class Projectlogin extends BaseClass
{
//	 WebDriver driver;

	public Loginpage login;
@Test(priority=0)
public void pageLogin() 
{

	logger=	report.createTest("login hrm");
	 login=PageFactory.initElements(driver, Loginpage.class);
	//login.loginhrm("user03", "pass1234");
	logger.info("Application login");
	login.loginhrm(excel.getstringgetdata("Sheet1", 1, 0), excel.getstringgetdata("Sheet1", 1, 1));
	logger.pass("Successfully open Leave Page");

}
@Test(priority=1)
	public void Applyleave() 
	{
	
//////////Aply Leave Tab//////;
	logger=	report.createTest("Apply leave with hrm application");
	login.Leavepage();

		logger.info("Apply leave functionality test is start");
	logger.pass("Apply leave functionality will working fine");
		
	}
	
	
	


}
