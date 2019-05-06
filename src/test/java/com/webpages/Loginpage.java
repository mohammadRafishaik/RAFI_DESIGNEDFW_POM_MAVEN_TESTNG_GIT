package com.webpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.testcases.BaseClass;


public class Loginpage 
{
	WebDriver driver;
	BaseClass Bc=new BaseClass();
	
	public Loginpage(WebDriver idriver)
	{
		this.driver=idriver;
	}

	@FindBy(how=How.ID,using="email")WebElement username;

	@FindBy(id="password") WebElement password;
	@FindBy(id="send") WebElement loginbutton;
//	@FindBy(xpath="//span[contains(text(),'0614273')]")WebElement Orderid;
	@FindBy(xpath="//div[@class='ag-cell ag-cell-not-inline-editing ag-cell-with-height ag-cell-no-focus ag-cell-last-left-pinned ag-column-hover']")WebElement ele;
	@FindBy(xpath="//div[@class='OrdersGridActions']//button[3]")WebElement Manifestlid;

	public void loginhrm(String Usernameforlogin,String Passwordforlogin) throws InterruptedException 
	{
		username.sendKeys(Usernameforlogin);
		password.sendKeys(Passwordforlogin);
		loginbutton.click();
		System.out.println("Login Is done successfully");
		//Thread.sleep(34000);
//		Orderids.click();

	}
	public void manifestcreation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		ele.click();
		Thread.sleep(3000);
		Manifestlid.click();
	
	}
	

//		
//	}
	
}
