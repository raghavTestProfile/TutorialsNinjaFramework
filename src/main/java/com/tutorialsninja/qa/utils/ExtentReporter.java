package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtendReports() throws IOException {
		
		ExtentReports extentreports=new ExtentReports();
		
		File expentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(expentReportFile);
		
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("TutorialsNinja TestAutomation Results");
		sparkreporter.config().setDocumentTitle("TN AUtomation report");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreports.attachReporter(sparkreporter);


		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		
		extentreports.setSystemInfo("Application URL: ",prop.getProperty("url"));
		extentreports.setSystemInfo("Browser Name: ",prop.getProperty("browser"));
		extentreports.setSystemInfo("Valid Email: ",prop.getProperty("validEmail"));
		extentreports.setSystemInfo("Valid Password: ",prop.getProperty("validPassword"));
		extentreports.setSystemInfo("OS: ",System.getProperty("os.name"));
		extentreports.setSystemInfo("User: ",System.getProperty("user.name"));
		extentreports.setSystemInfo("Java Version: ",System.getProperty("java.version"));
		
		return extentreports;
		
		
		
		
	}

}
