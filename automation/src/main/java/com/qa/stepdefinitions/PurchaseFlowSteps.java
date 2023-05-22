package com.qa.stepdefinitions;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.text.CaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.*;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.qa.pagefactories.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.Collections;

public class PurchaseFlowSteps  {
	PurchaseFlowPage demoHome_obj ;
	config	config_object  = new config();
	public static WebDriver driver;
	public PurchaseFlowSteps(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
		options.addArguments("test-type");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);

		// Maximize the browser
		driver.manage().window().maximize();
		// Launch Website

		config_object.readYaml();
		String url=(String)config_object.getyaml("home_url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		demoHome_obj = new PurchaseFlowPage(driver);

	}


	@When("verify HomePage is loaded")
	public void openUrl() throws InterruptedException {
		WebDriverWait wait =  new WebDriverWait(driver, 80);
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"//img[contains(@title,'Automation Test Store')]")));		
		//Thread.sleep(5000);
		assertTrue(demoHome_obj.ishometitleDisplayed());
		ExtentCucumberAdapter.addTestStepLog("HomePage is loaded");
	}

	@Then("click on Login and register the new user in web")
	public void loginuser()  {
		if(demoHome_obj.isloginDisplayed()) {
			demoHome_obj.clicklogin();
			ExtentCucumberAdapter.addTestStepLog("Login Button is Clicked and New User is registered");

		}
		if(demoHome_obj.isnewuserheaderDisplayed());{
			demoHome_obj.clickregcontinue();
		}
		String firstname=(String)config_object.getyaml("first_name");
		String lastname=(String)config_object.getyaml("last_name");
		String email=(String)config_object.getyaml("email");
		String address=(String)config_object.getyaml("Address");
		String city=(String)config_object.getyaml("City");
		String zipcode=(String)config_object.getyaml("ZIPCode");
		String login=(String)config_object.getyaml("login_name");
		String password=(String)config_object.getyaml("Password");
		String passwordconfirm=(String)config_object.getyaml("password_confirm");

		demoHome_obj.enterfn(firstname);
		demoHome_obj.enterln(lastname);
		demoHome_obj.enteremail(email);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)", "");
		demoHome_obj.enteraddr(address);
		demoHome_obj.entercity(city);
		demoHome_obj.clickregion();
		Select region = new Select(driver.findElement(By.xpath("//select[@name='zone_id'][contains(@id,'id')]")));
		region.selectByValue("3513");
		Select country = new Select(driver.findElement(By.xpath("//select[@name='country_id'][contains(@id,'id')]")));
		country.selectByValue("222");

		demoHome_obj.enterzip(zipcode);
		demoHome_obj.enterloginname(login);
		demoHome_obj.enterpassword(password);
		demoHome_obj.renterpassword(passwordconfirm);
		demoHome_obj.clickchkbox();
		demoHome_obj.clicklogcontinue();
		demoHome_obj.clickfinishcontinue();
		demoHome_obj.clickhome();
	}

	@Then("verify home element is displayed with login details in web")
	public void verify_username()  {

		if(demoHome_obj.ishometitleDisplayed()) {
			String firstname=(String)config_object.getyaml("first_name");
			String actual_fn = demoHome_obj.chckhomeusername(firstname);
			String replaced = actual_fn.replaceFirst("Welcome back", "").trim();
			assertEquals(replaced, firstname);
			ExtentCucumberAdapter.addTestStepLog("home element is displayed with login details:  "+firstname);
		}



	}
	@And("Add a product to the cart and validate in the payment page")
	public void Add_to_cart()  {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		demoHome_obj.clickcartbtn();
		js.executeScript("window.scrollBy(0,-350)", "");
		if(demoHome_obj.ischeckoutcartDisplayed()) {
			String item = demoHome_obj.getitemname();
			ExtentCucumberAdapter.addTestStepLog("Adding item to the Cart :" + item);
			String[] itemname = new String[] {""};
			Arrays.stream(item.split(" ")).forEach(s -> {itemname[0] += StringUtils.capitalize(s.toLowerCase()) + " ";});
			String act_itemname = StringUtils.chop(itemname[0]);
			demoHome_obj.clickcartitems();
			demoHome_obj.clickcheckcart();
			String actual_item = demoHome_obj.chckitemname(act_itemname);
			assertEquals(actual_item,act_itemname);
			ExtentCucumberAdapter.addTestStepLog("Expected itemname is:"+act_itemname + " and actual itemName is:"+actual_item+ ": " +"Assertion Passed");
			demoHome_obj.clickhome();
			ExtentCucumberAdapter.addTestStepLog("Validated all Assertions and returned back to HomePage!!!");
			driver.close();
		}



	}



}