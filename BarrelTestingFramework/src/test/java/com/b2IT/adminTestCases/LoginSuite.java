package com.b2IT.adminTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.b2IT.base.TestBase;
import com.b2IT.pageobject.b2IT_LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.win32.WinDef.BYTE;

public class LoginSuite extends TestBase
{
	String xlsname = "ExcelSheet_1.xls";

	@Test
	public void Task() throws Exception {
		// int itr = Integer.parseInt(getData("GmailAccountCreation",
		// "gmailtobecreated", xlsname));
		int itr = Integer.parseInt(getData("Testcase", "Iteration", xlsname));

		System.out.println("admin" + itr);
		for (int i = 1; i <= itr; i++) {
			//test = repo.startTest("ExtentDemo");

		try{	test.log(LogStatus.INFO, "login with the valid credentials");
			b2IT_LoginPage login = new b2IT_LoginPage();
			
			SendWithoutITR(login.textuserName, config.getProperty("userName"));
			
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			
			SendWithoutITR(login.textpassWord, config.getProperty("passWord"));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.MILLISECONDS);
			ClickWithoutITR(login.loginButton);
		
			login.errorInvalidPassword(login.errorInvalidPassword);
			//doubleClick();	
		}
		catch(Exception e)
		{
	
		}
			
		}
		
	}
	
}