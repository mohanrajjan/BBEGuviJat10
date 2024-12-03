package org.pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.com.CommonUtilities;

public class CheckoutPage extends CommonUtilities{
	
	public CheckoutPage() {
		 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Checkout']")
	static WebElement checkoutbutton;
	
	@FindBy(id="text-updates")
	static WebElement textupdatecheckbox;
	
	@FindBy(xpath="//span[text()='Continue to Payment Information']")
	static WebElement continuetopaybutton;
	

	@FindBy(xpath="(//span[text()='Email Address']//following::input)[1]")
	static WebElement emailtext;
	

	@FindBy(xpath="(//span[text()='Phone Number']//following::input)[1]")
	static WebElement phonenumbertext;
	
	public void gotopaymentpage() {
		waitExplicit(textupdatecheckbox, 3);
		textKey(emailtext, "ejbdm12@gmail.com");
		textKey(phonenumbertext, "5763963263");
		buttonClick(textupdatecheckbox);
		buttonClick(continuetopaybutton);
	}
	
}
