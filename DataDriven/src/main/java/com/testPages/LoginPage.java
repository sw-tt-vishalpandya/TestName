package com.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage extends BaseClass {

	// Test Vishal
	//Terst


	private static By uname = By.xpath("//input[@name='username']");
	private static By password = By.xpath("//input[@name='password']");
	private static By btnLogin = By.xpath("//input[@type='submit']");
	
//	@FindBy(xpath="//input[@id='username']")
//	WebElement userName;
//	
//	@FindBy(xpath="//input[@id='password']")
//	WebElement password;
//	
//	@FindBy(xpath = "//button[@id='loginBtn']")
//	WebElement btnClick;
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void checkLogin(String user, String pwd) {
		
		driver.findElement(uname).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(btnLogin).click();
	}
}


