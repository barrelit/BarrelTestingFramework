package com.b2IT.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.omg.CORBA.ARG_OUT;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.b2IT.base.TestBase;
import com.b2IT.utilities.MonitoringMail;
import com.b2IT.utilities.TestConfig;
import com.b2IT.utilities.TestUtil;
import com.relevantcodes.extentreports.LogStatus;


public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {
	String messageBody;

	public void onFinish(ITestContext arg0) {
		System.out.println(arg0.getName().toLowerCase());
/*		test.log(LogStatus.PASS, arg0.getName().toUpperCase());
		repo.endTest(test);
		repo.flush();*/
		repo.endTest(test);
		repo.flush();
	}

	public void onStart(ITestContext arg0) {

	/*	test.log(LogStatus.PASS, arg0.getName().toUpperCase());
		repo.endTest(test);
		repo.flush();*/

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + arg0.getThrowable());
		System.out.println(TestUtil.screenshotName);
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		Reporter.log("helloo");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ "height=200 width=200></img></a>");

		repo.endTest(test);
		repo.flush();
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
	public void onTestStart(ITestResult arg0) {

		test = repo.startTest(arg0.getName().toUpperCase());
	
	}

	public void onTestSuccess(ITestResult arg0) {


	}

	public void onFinish(ISuite arg0) {

		MonitoringMail mail = new MonitoringMail();
		try {
			System.out.println(InetAddress.getLocalHost());
			System.out.println(InetAddress.getLocalHost().getHostName());

			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/Rag/Extent_20Reports/";
			System.out.println(messageBody);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onStart(ISuite arg0) {

		

	}

}