/*package com.v2sd.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.v2sd.base.TestBase;
import com.v2sd.pageobject.v2sd_LoginPage;
import com.v2sd.utilities.TestUtil;

public class amazonLoginTestcase extends TestBase {
	String xlsname = "ExcelSheet_1.xls";

	@Test
	public void loginAsBankManager() throws Exception {
		// int itr = Integer.parseInt(getData("GmailAccountCreation",
		// "gmailtobecreated", xlsname));
		int itr = Integer.parseInt(getData("Testcase", "gmailtobecreated", xlsname));

		System.out.println("admin" + itr);
		for (int i = 1; i <= itr; i++) {
			
			test.log(LogStatus.INFO, "login with the valid credentials");
			log.info("login with the valid credentials");
			
			v2sd_LoginPage login=new v2sd_LoginPage();
			 String screenshot=TestUtil.screenshotName;
		       System.out.println(screenshot);
			Send(login.textuserName, config.getProperty("userName"), i);
		Thread.sleep(3000);
		//	test.log(LogStatus.PASS, "login with the valid credentials");


if(login.verifyText(login.textuserName, config.getProperty("userName"))==true)
{
	test.log(LogStatus.PASS, "logged in with credentials");
	
}


			if(driver.findElement(login.textuserName).getAttribute("value").equalsIgnoreCase(config.getProperty("userName")));
					test.log(LogStatus.PASS, "logged in with credentials");
		
		}
		
		
		
	if (driver.findElement(login.textuserName).getAttribute("value").equalsIgnoreCase(config.getProperty("userName")));
					test.log(LogStatus.PASS, "logged in with credentials");
		
		} 
		
		
      
if (driver.findElement(login.textuserName).getText().equalsIgnoreCase(config.getProperty("userName"))) {
	test.log(LogStatus.PASS, "logged in with credentials");
} else {
	test.log(LogStatus.FAIL,"ABC"+screenshot);
 	test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
}	
		
	
	}
	}
}
                
*/