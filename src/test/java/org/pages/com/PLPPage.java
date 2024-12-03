package org.pages.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.utilities.com.CommonUtilities;

public class PLPPage extends CommonUtilities {

	public PLPPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='What can we help you find today?']")
	WebElement searchtext;
	
	@FindBy(xpath="//button[@title='submit search']")
	WebElement searchsubmit;
	
	@FindBy(xpath="(//button[text()='Add to Cart'])[4]")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	WebElement searchaddtocartbtn;
	
	@FindBy(xpath="//a[text()='Go to Cart']")
	WebElement gotocartbtn;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement closegotocartbtn;
	
	@FindBy(xpath="//button[@aria-label='Menu']")
	WebElement menubutton;
	
	@FindBy(xpath="//button[text()='Brands']")
	WebElement brandbutton;
	
	@FindBy(xpath="//a[text()='All Brands']")
	WebElement allbrandsbutton;
	
	@FindBy(xpath="//a[text()='Samsung']")
	WebElement samsungbrandbutton;
	
	@FindBy(xpath="(//a[text()='TV and home theater'])[2]")
	WebElement samsungtvbutton;
	
	
	
	@FindBy(xpath="//button[text()='Computers & Tablets']")
	static WebElement computerbutton;
	
	@FindBy(xpath="//button[text()='Laptops & Desktops']")
	static WebElement lapdeskbutton;
	
	@FindBy(xpath="//a[text()='Laptops']")
	static WebElement laplinkbutton;
	
	@FindBy(xpath="//a[text()='Dell']")
	static WebElement delllinkbutton;
	
	public void searchByProduct(String Searchproduct) {
		SoftAssert sa = new SoftAssert();
		textKey(searchtext, Searchproduct);
		buttonClick(searchsubmit);
		WebElement product1 = driver.findElement(By.xpath("(//a[text()='Dyson Digital Slim Cordless Vacuum - Iron/Nickel'])[1]"));
		buttonClick(product1);
		String expected="Dyson Digital Slim Cordless Vacuum Iron/Nickel 481761-01 - Best Buy";
		String actual=getTitle();
		waitExplicit(searchaddtocartbtn, 3);
		goandclick(searchaddtocartbtn);
		waitExplicit(gotocartbtn, 3);
		buttonClick(gotocartbtn);
		sa.assertEquals(actual,expected);
		sa.assertAll();
		
	}
	
	public void searchByBrand() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(menubutton);
		waitExplicit(brandbutton, 2);
		buttonClick(brandbutton);
		buttonClick(samsungbrandbutton);
		waitExplicit(samsungtvbutton, 2);
		buttonClick(samsungtvbutton);
		WebElement elementname=driver.findElement(By.xpath("//a[text()='Samsung - 50” Class DU6900 Series Crystal UHD 4K Smart Tizen TV (2024)']"));
		buttonClick(elementname);
		String tvname="//h1[text()='Samsung - 50” Class DU6900 Series Crystal UHD 4K Smart Tizen TV (2024)']";
		WebElement elementname1=driver.findElement(By.xpath(tvname));
		String actual = elementText(elementname1);
		System.out.println(actual);
		String expected="Samsung - 50” Class DU6900 Series Crystal UHD 4K Smart Tizen TV (2024)";
		goandclick(addtocartbtn);
		waitExplicit(gotocartbtn, 3);
		buttonClick(gotocartbtn);
		sa.assertEquals(actual,expected);
		sa.assertAll();
	}
	
	public void searchByDepart() {
		SoftAssert sa = new SoftAssert();
		waitImplicit(3000);
		buttonClick(menubutton);
		buttonClick(computerbutton);
		waitExplicit(lapdeskbutton, 2);
		buttonClick(lapdeskbutton);
		waitExplicit(laplinkbutton, 2);
		buttonClick(laplinkbutton);
		waitExplicit(delllinkbutton, 2);
		buttonClick(delllinkbutton);
		String lapmodel="//a[text()='Dell - Inspiron 14” 2-in-1 Touch Laptop – Intel Core 7 Processor – 16GB Memory – 1TB SDD - Ice Blue']";
		WebElement purchase=driver.findElement(By.xpath(lapmodel));
		String expected="Dell - Inspiron 14” 2-in-1 Touch Laptop – Intel Core 7 Processor – 16GB Memory – 1TB SDD - Ice Blue";
		String actual=elementText(purchase);
		buttonClick(purchase);
		
		goandclick(addtocartbtn);
		waitExplicit(gotocartbtn, 3);
		buttonClick(gotocartbtn);
		
		sa.assertAll();
		Assert.assertEquals(expected, actual);
		
		
	}
}
