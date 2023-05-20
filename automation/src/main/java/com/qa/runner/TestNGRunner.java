package com.qa.runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import com.qa.utils.config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
	    features="main/resources/com/qa/features/Pages",
		glue={"com.qa.stepdefinitions"},tags="@SanityWeb",
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestNGRunner extends AbstractTestNGCucumberTests 
{
	public static TestNGCucumberRunner testNGCucumberRunner;
	static AppiumDriverLocalService appiumDriverLocalService=null;
	public static ExtentReports report;
	@AfterSuite
	public void beforeSuite() throws IOException
	{
		System.out.println("ENTERED AFTER SUITE");
		report=ExtentService.getInstance();
		
	}
	
	@BeforeSuite
	
	public static void afterTest() throws IOException
	{
		System.out.println("Entered Before Suite");
		String chromepath = System.getProperty("user.dir") + "\\resources\\" + "chromedriver.exe";

		 System.setProperty(
		            "webdriver.chrome.driver",
		            chromepath );
		
		
	}

}