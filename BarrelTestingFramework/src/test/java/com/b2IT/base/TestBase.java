package com.b2IT.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.b2IT.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	/*
	 * WebDriver Properties Logs ExtendReports DB Excel Mail
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static DateFormat dateFormat;
	public static java.util.Date date;
	public static String FileName;
	public ExtentReports repo = ExtentManager.getInstance();
	public static ExtentTest test;

	@BeforeSuite
	public void setUp() {
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config file");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "gecko.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
			driver.get(config.getProperty("testsiteUrl"));

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
		}
	}

	//
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * public void click(String locator) { if (locator.endsWith("_CSS")) {
	 * driver.findElement(By.cssSelector(locator)).click(); } else if
	 * (locator.endsWith("_XPATH")) {
	 * driver.findElement(By.xpath(locator)).click(); } else if
	 * (locator.endsWith("_ID")) { driver.findElement(By.id(locator)).click(); }
	 * test.log(LogStatus.INFO, "Clicking on : " + locator); }
	 */

	public void sendKeys(String locator, String value) {
		driver.findElement(By.cssSelector(locator)).sendKeys(value);

	}

	public void Send(By by, String text, int i) {
		try {
			driver.findElement(by).sendKeys(text);
			if (driver.findElement(by).getText().equals(text)) {
				test.log(LogStatus.PASS, " Enter the value"+text+"text");
			} else if (driver.findElement(by).getAttribute("value").equals(text)) {
				test.log(LogStatus.PASS, " Enter the value"+"value"+text);
			}

		} catch (NoSuchElementException e) {
			test.log(LogStatus.FAIL, "Failed with exception " + e);
		}
	}
	
	
	public void SendWithoutITR(By by, String text) {
		try {
			driver.findElement(by).sendKeys(text);
			if (driver.findElement(by).getText().equals(text)) {
				test.log(LogStatus.PASS, " Enter the value"+text+"text");
			} else if (driver.findElement(by).getAttribute("value").equals(text)) {
				test.log(LogStatus.PASS, " Enter the value"+"value"+text);
			}

		} catch (NoSuchElementException e) {
			test.log(LogStatus.FAIL, "Failed with exception " + e);
		}
	}


	public void Click(By by, int i) {
		try {
			driver.findElement(by).click();
		} catch (NoSuchElementException e) {

		}
	}


	
	public void ClickWithoutITR(By by) {
		try {
			System.out.println("clicked");
			driver.findElement(by).click();
			
			Thread.sleep(4000);
	
			
		} catch (Exception e) {
e.printStackTrace();
System.out.println("Not able to click");
		}
	}
	public void doubleClick() {
		Actions act = new Actions(driver);
		act.doubleClick().build().perform();

	}


	
	
	public static String getData(String SheetName, String ColName, String excelName, int iteration) throws Exception {
		String returnValue = null;
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\" + excelName);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh = wb.getSheet(SheetName);
			HSSFRow row = sh.getRow(0);
			int colNum = row.getLastCellNum();
			// int maxCell= r.getLastCellNum();
			for (int i = 0; i <= colNum; i++) {
				String val = sh.getRow(0).getCell(i).getStringCellValue();

				if (val.equalsIgnoreCase(ColName)) {
					returnValue = sh.getRow(iteration).getCell(i).getStringCellValue();
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return returnValue;
	}

	public static String getData(String SheetName, String ColName, String excelName) throws Exception {
		String returnValue = "";
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\" + excelName);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh = wb.getSheet(SheetName);
			int rowCount = sh.getLastRowNum();
			for (int i = 0; i <= rowCount; i++) {
				String val = sh.getRow(i).getCell(0).getStringCellValue();
				if (val.equalsIgnoreCase(ColName)) {
					returnValue = sh.getRow(i).getCell(1).getStringCellValue();
					break;
				}
			}
		} catch (Exception ex) {
		}
		return returnValue;
	}

	public static void DateFormat() {
		dateFormat = new SimpleDateFormat("MMddYYYY");
		// removed sec due to duplicated in folder
		date = new java.util.Date();
		FileName = dateFormat.format(date);
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}