package org.pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.com.CommonUtilities;

public class CartPage extends CommonUtilities {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Checkout']")
	static WebElement checkoutbutton;
	
	@FindBy(xpath="//button[text()='Checkout']")
	static WebElement pickupatstoreradiobtn;
	
	@FindBy(xpath="//button[text()='Checkout']")
	static WebElement shiptoaddressradiobtn;
	
	@FindBy(xpath="//img[@alt='PayPal Checkout']")
	static WebElement paypalcheckoutbtn;
	
	@FindBy(xpath="(//select[@class='tb-select'])[1]")
	static WebElement selectgiftcard;
	
	@FindBy(xpath="(//select[@class='tb-select'])[2]")
	static WebElement selectproductqty;
	
	public void pickupatstore() {
		waitExplicit(checkoutbutton, 3);
		buttonClick(checkoutbutton);
	}
	
	public void usepaypalpickupstore() {
		waitExplicit(paypalcheckoutbtn, 3);
		buttonClick(paypalcheckoutbtn);
	}
	
	public void shipaddress() {
		buttonClick(shiptoaddressradiobtn);
		buttonClick(checkoutbutton);
	}
	
	public void usepaypalshipaddress() {
		
		buttonClick(shiptoaddressradiobtn);
		buttonClick(paypalcheckoutbtn);
	}
}
