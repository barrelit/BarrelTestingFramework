package com.b2IT.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.b2IT.base.TestBase;
import com.b2IT.pageobject.b2IT_HomePage;
import com.b2IT.pageobject.b2IT_LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TaskClass extends TestBase {

	String xlsname = "ExcelSheet_1.xls";

	@Test
	public void Task() throws Exception {
		// int itr = Integer.parseInt(getData("GmailAccountCreation",
		// "gmailtobecreated", xlsname));
		int itr = Integer.parseInt(getData("Testcase", "Iteration", xlsname));

		System.out.println("admin" + itr);
		for (int i = 1; i <= itr; i++) {
			//test = repo.startTest("ExtentDemo");

			test.log(LogStatus.INFO, "login with the valid credentials");

			b2IT_LoginPage login = new b2IT_LoginPage();

			Send(login.textuserName, config.getProperty("userName"), i);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			doubleClick();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			Send(login.textpassWord, config.getProperty("passWord"), i);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("longwait")),
					TimeUnit.MILLISECONDS);
			Click(By.id("loginButton"), i);
		/*	driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("longwait")),
					TimeUnit.MILLISECONDS);
			
			b2IT_HomePage homepage=new b2IT_HomePage();
			if(isElementPresent(homepage.logout)==true)
			{
				test.log(LogStatus.PASS, "logged with valid credentials "+config.getProperty("userName")+config.getProperty("passWord"));

			}
			else
			{
				test.log(LogStatus.FAIL, "Please check the credentials");

			}
			
*/
			// driver.findElement(By.name("password")).sendKeys("Welcome@123") ;
			/*
			 * driver.findElement(By.id("loginButton")).click();
			 * 
			 * System.out.println("Login was Successful");
			 */

		}

	}
}
