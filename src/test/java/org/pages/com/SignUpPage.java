package org.pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.utilities.com.CommonUtilities;

public class SignUpPage extends CommonUtilities {
	
	public SignUpPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Account']")
	static WebElement accounticon;
	
	@FindBy(xpath="//a[text()='Create Account']")
	static WebElement createAccountBtn;
	
	@FindBy(id="firstName")
	static WebElement firstName;
	
	@FindBy(id="lastName")
	static WebElement lastName;
	
	@FindBy(id="email")
	static WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	static WebElement password;
	
	@FindBy(id="reenterPassword")
	static WebElement confirmPassword;
	
	@FindBy(id="phone")
	static WebElement phoneNumber;
	
	@FindBy(xpath="//button[text()='Create an Account']")
	static WebElement createAnAccountBtn;
	
	@FindBy(tagName ="p")
	static WebElement pagetext;
	
	@FindBy(tagName ="(//strong)[2]")
	static WebElement Errormessage;
	
	@FindBy(xpath ="//button[text()='No, Thanks']")
	static WebElement surveymessage;
	
	public void validSignUp(String vFirstName,
			String vLastName, String vPass, String vCPass, String vMobile, String vEmail ) {
		SoftAssert sa = new SoftAssert();
		waitImplicit(2);
		buttonClick(accounticon);
		waitExplicit(createAccountBtn, 4);
		buttonClick(createAccountBtn);
		waitExplicit(firstName, 2);
		textKey(firstName, vFirstName);
		textKey(lastName, vLastName);
		textKey(email, vEmail);
		textKey(password, vPass);
		textKey(confirmPassword, vCPass);
		textKey(phoneNumber, vMobile);
		buttonClick(createAnAccountBtn);
		sa.assertAll();
	}
	
	public void invalidSignUp(String iFirstName,
			String iLastName, String iPass, String iCPass, String iMobile, String iEmail ) {
		SoftAssert sa = new SoftAssert();
		waitImplicit(2);
		waitExplicit(accounticon, 2);
		buttonClick(accounticon);
		waitExplicit(createAccountBtn, 4);
		buttonClick(createAccountBtn);
		waitExplicit(firstName, 2);
		textKey(firstName, iFirstName);
		textKey(lastName, iLastName);
		textKey(email, iEmail);
		textKey(password, iPass);
		textKey(confirmPassword, iCPass);
		waitExplicit(phoneNumber, 2);
		textKey(phoneNumber, iMobile);
		buttonClick(createAnAccountBtn);
		waitExplicit(Errormessage, 4);
		String emailexists = elementText(Errormessage);
		
		sa.assertEquals("An account with this email already exists.", emailexists);
		sa.assertAll();
	}
	
}
