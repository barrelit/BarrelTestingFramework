package com.b2IT.pageobject;
import org.openqa.selenium.By;

import com.b2IT.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class b2IT_LoginPage extends TestBase{

	
	
	/*public By textuserName=By.xpath("//input[@id='ap_email']");
	public By textpassWord=By.xpath("//input[@name='password']");
	public By buttonContinue=By.xpath("//input[@id='continue']");
	public By buttonlogin=By.xpath("//input[@id='signInSubmit']");
	*/		
			
	
	public By textuserName=By.xpath("//input[@id='mat-input-1']");
	public By textpassWord=By.xpath("//input[@id='mat-input-2']");
	public By loginButton=By.xpath("//span[contains(text(),' LOGIN')]");//dont not remove spaces
	public By errorInvalidPassword=By.xpath("//*[@id='mat-error-2']");
			
	
	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifySignInPageTitle(String expectedTitle) {
	
		return getSignInPageTitle().contains(expectedTitle);
	}
	
	public String getSignInPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public boolean verifySignInPageUrl(String Url) {
		
		return getSignInPageUrl().contains(Url);
	}
	
	
	
	public void errorInvalidPassword(By by)
	{
		/*if(!driver.findElement(by).isDisplayed())
		{
			test.log(LogStatus.PASS, "next page navigated"+driver.getCurrentUrl());
		}
		else 
		{
			test.log(LogStatus.FAIL, "Unable to navigate to next page");
		}*/
		
		try
		{
			System.out.println("into try block");
			if(driver.findElement(by).isDisplayed())
			{
				System.out.println("inside into try block");
				test.log(LogStatus.FAIL, "next page not navigated"+driver.getCurrentUrl());
			}	
			}
		catch(Exception e)
		{
			System.out.println("inside into catch block");
			test.log(LogStatus.PASS, "navigated to next page"+driver.getCurrentUrl());	
		}
	}
	
	
	
	
	
	
	
	
	
	
			}

