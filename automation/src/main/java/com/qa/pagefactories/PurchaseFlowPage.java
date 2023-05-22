package com.qa.pagefactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PurchaseFlowPage{
	public static WebDriver driver;
	int durationTime = 30;


	public PurchaseFlowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath ="//img[contains(@title,'Automation Test Store')]")
	private WebElement homepagetitle;

	@FindBy(xpath = "//a[contains(.,'Login or register')]")
	private WebElement Login;

	@FindBy(xpath ="//h2[@class='heading2'][contains(.,'I am a new customer.')]")
	private WebElement newuserheader;

	@FindBy(xpath ="//button[@type='submit'][contains(.,'Continue')]")
	private WebElement regcontinue;

	@FindBy(xpath ="//input[@type='text'][contains(@id,'firstname')]")
	private WebElement FNTXTBOX;

	@FindBy(xpath ="//input[@type='text'][contains(@id,'lastname')]")
	private WebElement LNTXTBOX;

	@FindBy(xpath ="//input[@type='text'][contains(@id,'email')]")
	private WebElement email;

	@FindBy(xpath ="//input[@type='text'][contains(@id,'1')]")
	private WebElement Address;

	@FindBy(xpath ="//input[@type='text'][contains(@id,'city')]")
	private WebElement city;

	@FindBy(xpath ="//input[@type='text'][contains(@id,'postcode')]")
	private WebElement zip;

	@FindBy(xpath ="//input[@type='text'][contains(@id,'loginname')]")
	private WebElement login;

	@FindBy(xpath ="//input[@type='password'][contains(@id,'password')]")
	private WebElement password;

	@FindBy(xpath ="//input[@type='password'][contains(@id,'confirm')]")
	private WebElement passwordconf;

	@FindBy(xpath ="//select[@name='zone_id'][contains(@id,'id')]")
	private WebElement region;

	@FindBy(xpath ="//select[@name='country_id'][contains(@id,'id')]")
	private WebElement country;

	@FindBy(xpath ="//input[@type='checkbox'][contains(@id,'agree')]")
	private WebElement chkbox;

	@FindBy(xpath ="//button[@class='btn btn-orange pull-right lock-on-click'][contains(.,'Continue')]")
	private WebElement logincont;

	@FindBy(xpath ="//a[contains(@title,'Continue')]")
	private WebElement finishcont;

	@FindBy(xpath ="(//i[contains(@class,'fa fa-cart-plus fa-fw')])[1]")
	private WebElement addtocartbtn;

	@FindBy(xpath ="/html/body/div/header/div[2]/div/div[3]/ul/li/a")
	private WebElement cartitems;

	@FindBy(xpath ="//a[@href='#'][contains(@id,'checkout1')][contains(.,'Checkout')]")
	private WebElement checkoutcart;

	@FindBy(xpath ="//*[@id=\"block_frame_featured_1769\"]/div/div[1]/div[1]/div/a")
	private WebElement itemname;
	
	@FindBy(xpath ="//a[@class='active menu_home'][contains(.,'Home')]")
	private WebElement homeicon;

	public boolean ishometitleDisplayed(){
		return homepagetitle.isDisplayed();
	}

	public boolean isnewuserheaderDisplayed(){
		return newuserheader.isDisplayed();
	}

	public boolean isloginDisplayed(){
		return Login.isDisplayed();
	}
	public void clicklogin(){
		Login.click();
	}
	public void clickregcontinue(){
		regcontinue.click();
	}
	public void enterfn(String fn){
		FNTXTBOX.sendKeys(fn);
	}

	public void enterln(String ln){
		LNTXTBOX.sendKeys(ln);
	}

	public void enteremail(String emailn){
		email.sendKeys(emailn);
	}
	public void enteraddr(String addressn){
		Address.sendKeys(addressn);
	}
	public void entercity(String cityn){
		city.sendKeys(cityn);
	}
	public void enterzip(String zipcode){
		zip.sendKeys(zipcode);
	}
	public void clickregion(){
		region.click();
	}
	public void enterloginname(String loginname){
		login.sendKeys(loginname);
	}
	public void enterpassword(String pasword){
		password.sendKeys(pasword);
	}
	public void renterpassword(String pasword){
		passwordconf.sendKeys(pasword);
	}
	public void clickchkbox(){
		chkbox.click();
	}
	public void clicklogcontinue(){
		logincont.click();
	}

	public void clickfinishcontinue(){
		finishcont.click();
	}
	public void clickcartbtn(){
		addtocartbtn.click();
	}
	public boolean ischeckoutcartDisplayed(){
		return cartitems.isDisplayed();
	}
	public void clickcartitems(){
		cartitems.click();
	}
	public void clickcheckcart(){
		checkoutcart.click();
	}
	public String getitemname() {
		return itemname.getText();
	}
	public void clickhome(){
		homeicon.click();
	}
	public String chckitemname(String item) {

		WebElement itemname = (WebElement) driver.findElement(By.xpath("(//a[@href='https://automationteststore.com/index.php?rt=product/product&product_id=50'][contains(.,'"+item+"')])[3]"));
		return  itemname.getText();
	}
	public String chckhomeusername(String un) {

		WebElement username =(WebElement) driver.findElement(By.xpath("//div[@class='menu_text'][contains(.,'Welcome back "+un+"')]"));
		return  username.getText();
	}
}
