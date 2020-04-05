package com.b2IT.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.b2IT.base.TestBase;

import org.apache.commons.io.FileUtils;

public class TestUtil extends TestBase {

	//public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {


		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File("D:\\ValueSDProductFramework\\target\\surefire-reports\\html\\" + screenshotName));



	}
	
	
}

