package com.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Loginpage 
{
	WebDriver driver;
	public Loginpage(WebDriver idriver)
	{
		this.driver=idriver;
	}

	@FindBy(how=How.NAME,using="txtUsername")WebElement username;

	@FindBy(id="txtPassword") WebElement password;
	@FindBy(id="btnLogin") WebElement loginbutton;

	public void loginhrm(String Usernameforlogin,String Passwordforlogin) 
	{
		username.sendKeys(Usernameforlogin);
		password.sendKeys(Passwordforlogin);
		loginbutton.click();
		System.out.println("Login Is done successfully");

	}
	@FindBy(id="menu_leave_viewLeaveModule") WebElement Leavetab;
	@FindBy(id="menu_leave_applyLeave") WebElement Applylink;
	@FindBy(id="applyleave_txtLeaveType") WebElement SelectLeaveType;
	@FindBy(xpath="//option[text()='Annual Leave']") WebElement Dropdownvalueselected;
	public void Leavepage() {
		Leavetab.click();
		Applylink.click();
		SelectLeaveType.click();
		Dropdownvalueselected.click();
		
	}
	
}
