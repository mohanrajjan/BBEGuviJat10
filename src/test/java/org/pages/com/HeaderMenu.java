package org.pages.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.utilities.com.CommonUtilities;

public class HeaderMenu extends CommonUtilities {

	public HeaderMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Top Deals']")
	static WebElement topdealsicon;
	
	@FindBy(xpath="//a[text()='Deal of the Day']")
	static WebElement dealofdayicon;
	
	@FindBy(xpath="//a[text()='Yes, Best Buy Sells That']")
	static WebElement bestbuysellsicon;
	
	@FindBy(xpath="//a[text()='Black Friday Deals']")
	static WebElement blackfridaydealsicon;
	
	@FindBy(xpath="//span[text()='More']")
	static WebElement moreicon;
	
	@FindBy(xpath="//span[text()='Account']")
	static WebElement accounticon;
	
	@FindBy(xpath="//span[text()='Recently Viewed']")
	static WebElement recentlyviewedicon;
	
	@FindBy(xpath="//span[text()='Order Status']")
	static WebElement orderstatusicon;
	
	@FindBy(xpath="//span[text()='Saved Items']")
	static WebElement saveditemsicon;
	
	@FindBy(xpath="//span[text()='Cart']")
	static WebElement carticon;
	
	@FindBy(xpath="//div[@class='store-locator']")
	static WebElement storeicon;
	
	@FindBy(xpath="//button[text()='Menu']")
	static WebElement hamburgermenuicon;
	
	@FindBy(xpath="//a[@title='BestBuy.com']")
	static WebElement logoicon;
	
	@FindBy(xpath="//input[@placeholder='What can we help you find today?']")
	static WebElement searchtext;
	
	@FindBy(xpath="//a[text()='Account']")
	static WebElement accountlinkbtn;
	
	@FindBy(tagName="h2")
	static WebElement saveditemstext;
	
	@FindBy(tagName ="h2")
	static WebElement orderstatustext;
	
	@FindBy(tagName ="h1")
	static WebElement carttext;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement conitnuebutton;
	
	
	@FindBy(xpath="//a[text()='Sign In']")
	 WebElement signinlinkbutton;
	
	public LoginPage loginIcon() {
		waitExplicit(accounticon, 3);
		buttonClick(accounticon);
		
		waitExplicit(signinlinkbutton, 2);
		buttonClick(signinlinkbutton);
		return new LoginPage(driver);
	}
	
	public void topdealspage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(topdealsicon);
		String toptitle = getTitle();
		String expected="Best Buy Top Deals";
		sa.assertAll();
		Assert.assertEquals(expected,toptitle);
		buttonClick(logoicon);
	}
	
	public void accountpage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(accounticon);
		waitExplicit(accountlinkbtn, 2);
		buttonClick(accountlinkbtn);
		String dealofdaytitle = getTitle();
		String expected="Account Home - Best Buy";
		sa.assertAll();
		Assert.assertEquals(expected,dealofdaytitle);
		buttonClick(logoicon);
	}
	
	public void dealofthedaypage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(dealofdayicon);
		String dealofdaytitle = getTitle();
		String expected="Deal of the Day: Electronics Deals - Best Buy";
		sa.assertAll();
		Assert.assertEquals(expected,dealofdaytitle);
		buttonClick(logoicon);
	}
	
	public void bestbuydaypage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(bestbuysellsicon);
		String bestbuytitle = getTitle();
		System.out.println(bestbuytitle);
		String expected="Yes, Best Buy Sells That – Best Buy";
		sa.assertAll();
		Assert.assertEquals(expected,bestbuytitle);
		buttonClick(logoicon);
	}
	
	public void fridaydealpage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(blackfridaydealsicon);
		String fridaydealtitle = getTitle();
		String expected="Best Buy Black Friday Deals 2024";
		sa.assertAll();
		Assert.assertEquals(expected,fridaydealtitle);
		buttonClick(logoicon);
	}
	
	public void recentlyviewedpage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(recentlyviewedicon);
		String recentlyviewed = getTitle();
		String expected="Best Buy | Official Online Store | Shop Now & Save";
		sa.assertAll();
		Assert.assertEquals(expected,recentlyviewed);
		buttonClick(logoicon);
	}
	
	public void orderstatuspage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(orderstatusicon);
		//without login
		buttonClick(conitnuebutton);
		String orderstext = elementText(orderstatustext);
		System.out.println(orderstext);
		String expected="Order Status";
		sa.assertAll();
		//Assert.assertEquals(expected,orderstext);
		buttonClick(logoicon);
	}
	
	public void saveditemspage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(saveditemsicon);
		String saveditemtext = elementText(saveditemstext);
		String expected="Saved Items";
		sa.assertAll();
		//Assert.assertEquals(expected,saveditemtext);
		buttonClick(logoicon);
	}
	public void cartpage() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(carticon);
		String carttitle = getTitle();
		String expected="Cart - Best Buy";
		sa.assertAll();
		Assert.assertEquals(expected,carttitle);
		buttonClick(logoicon);
	}
	
}
