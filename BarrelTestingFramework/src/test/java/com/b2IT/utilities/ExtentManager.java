package com.b2IT.utilities;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static  ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		Date d=new Date();
		
		if(extent==null)
		{
			if(extent==null)
			{
				/*extent=new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\Extent-Reports\\extent.html",true,DisplayOrder.OLDEST_FIRST);
				extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));*/
																			
			//	extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
				//extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
				extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
				extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));

			}
			
		}
		return extent;

	}

	}


