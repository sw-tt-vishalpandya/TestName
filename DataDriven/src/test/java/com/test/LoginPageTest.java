package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.read.data.*;
import com.test.utility.TestUtil;
import com.testPages.LoginPage;

public class LoginPageTest extends BaseClass {

	public LoginPageTest() throws Exception {
	}

	private static XSSFWorkbook workBook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private static XSSFRow row;

	private static WebDriverWait wait;
	private static By uname = By.xpath("//input[@name='username']");
	private static By password = By.xpath("//input[@name='password']");
	private static By btnLogin = By.xpath("//input[@type='submit']");

	LoginPage loginpage;

	@BeforeTest
	private void setup() throws Exception {
		getUrl("https://classic.crmpro.com/login.cfm");
		loginpage = new LoginPage();

	}

	@DataProvider
	public Iterator<Object[]> getTestData() throws Exception {
		ArrayList<Object[]> data = TestUtil.getExcelData();
		return data.iterator();

	}

	@Test(dataProvider = "getTestData")
	private void checkLogin(String username, String pwd) throws Exception {
		// ReadWriteExcel.getCellData();

		// wait.until(ExpectedConditions.presenceOfElementLocated(uname));
		driver.findElement(uname).clear();
		driver.findElement(uname).sendKeys(username);

		// wait.until(ExpectedConditions.presenceOfElementLocated(password));
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
		Thread.sleep(2000);
		// wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		driver.findElement(btnLogin).click();

	}

	@AfterTest
	private void tearDown() {
		driver.close();
	}

}
