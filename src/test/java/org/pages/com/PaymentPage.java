package org.pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.com.CommonUtilities;

public class PaymentPage extends CommonUtilities {

	public PaymentPage() {
		 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cc-number")
	static WebElement ccnumbertextbox;
	
	@FindBy(id="expirationDate")
	static WebElement expirationdatebox;
	
	@FindBy(id="cvv")
	static WebElement cvvtextbox;
	
	@FindBy(id="first-name")
	static WebElement billaddfntextbox;
	
	@FindBy(id="last-name")
	static WebElement billaddlntextbox;
	
	@FindBy(id="address-input")
	static WebElement billaddresstextbox;
	
	@FindBy(id="city")
	static WebElement billcitynametextbox;
	
	@FindBy(id="state")
	static WebElement billstatetextbox;
	
	@FindBy(id="postalCode")
	static WebElement billzipcodetextbox;
	
	@FindBy(xpath="//span[text()='Place Your Order']")
	static WebElement placeyourorderbutton;
	
	@FindBy(xpath="//span[text()='Return to Cart']")
	static WebElement returntocartbutton;
	
	@FindBy(xpath="//strong[text()='Back to Pickup & Delivery Options']")
	static WebElement backtopickupoptionbutton;
	
	@FindBy(xpath="//span[text()='Create Password']//following::input")
	static WebElement createpasswordtext;
	
	@FindBy(xpath="//span[text()='Create Account']//parent::button")
	static WebElement createaccountbutton;
	
	@FindBy(tagName = "p")
	static WebElement errormessage;
	
	public void visaPayment(String CardNumber, String ExpirationDate, String CVV,String firstname, String lastname, String address,String city,String Zipcode) {
		waitExplicit(ccnumbertextbox, 5);
		textKey(ccnumbertextbox, CardNumber);
		textKey(expirationdatebox, ExpirationDate);
		textKey(cvvtextbox, CVV);
		textKey(billaddfntextbox, firstname);
		textKey(billaddlntextbox, lastname);
		textKey(billaddresstextbox, address);
		textKey(billcitynametextbox, city);
		SelectDropdownByText(billstatetextbox, "NY");
		textKey(billzipcodetextbox, Zipcode);
		textKey(createpasswordtext, "enisk=Q12");
		goandclick(placeyourorderbutton);
	}
}
