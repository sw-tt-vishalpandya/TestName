package com.read.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadWriteExcel {

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static XSSFWorkbook workBook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private static XSSFRow row;

	private static By uname = By.xpath("//input[@name='username']");
	private static By password = By.xpath("//input[@name='password']");
	private static By btnLogin = By.xpath("//input[@type='submit']");

	public ReadWriteExcel() throws Exception {
		
		
	}

	
	public static void main(String[] args) throws Exception {

		loadBrowser();
		 getURL("https://classic.crmpro.com/login.cfm");

		String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\UserInfo.xlsx";
		setExcelFile(filePath, "UserDetails");

		getCellData();

	}



	private static void getURL(String url) {

		loadBrowser();
		getURL(url);
	}

	private static void loadBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\drivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/login.cfm");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(path);

			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheet(sheetName);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static void getCellData() throws Exception {

		for (int RowNum = 1; RowNum <= sheet.getLastRowNum(); RowNum++) {

			cell = sheet.getRow(RowNum).getCell(0);
			driver.findElement(uname).clear();
//			wait.until(ExpectedConditions.presenceOfElementLocated(uname));
			driver.findElement(uname).sendKeys(cell.getStringCellValue());
			System.out.println(cell.getStringCellValue());

			cell = sheet.getRow(RowNum).getCell(1);
			driver.findElement(password).clear();
//			wait.until(ExpectedConditions.presenceOfElementLocated(password));
			driver.findElement(password).sendKeys(cell.getStringCellValue());
			System.out.println(cell.getStringCellValue());
			
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.presenceOfElementLocated(btnLogin));
			driver.findElement(btnLogin).click();

			
			System.out.println("===============");
		}

		workBook.close();
		driver.close();
	}

}
