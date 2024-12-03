package org.pages.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.utilities.com.CommonUtilities;

public class LoginPage extends CommonUtilities{

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Account']")
	WebElement accounticon;
	
	@FindBy(xpath="//a[text()='Sign In']")
	 WebElement signinlinkbutton;
	
	@FindBy(xpath="//input[@type='email']")
	 WebElement loginemailbutton;
	
	@FindBy(xpath="//input[@type='password']")
	 WebElement loginpasswdbutton;
	
	@FindBy(xpath="//button[text()='Sign In']")
	 WebElement signinbutton;
	
	@FindBy(xpath="//button[text()='Skip for now']")
	 WebElement skipnow;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continuebutton;
	
	@FindBy(xpath="//button[text()='Continue as Guest']")
	 WebElement guestbutton;
	
	@FindBy(xpath="//div[text()='Sorry, something went wrong. Please try again.']")
	WebElement errorMessage;
	
	
	public LoginPage checkLogin(String email, String password, String type, String text) {
		SoftAssert sa = new SoftAssert();
		List<WebElement> link1 = driver.findElements(By.tagName("a"));
		for (WebElement link : link1) {
			String url = link.getAttribute("href");
			verifyLink(url);
		}
		
		if(type.equalsIgnoreCase("validdata")) {
			
			waitExplicit(loginemailbutton, 2);
			textKey(loginemailbutton, email);
			textKey(loginpasswdbutton, password);
			buttonClick(signinbutton);
			//buttonClick(skipnow);
			waitExplicit(errorMessage, 5);
			String expected=text;
			String actual=elementText(errorMessage);
			sa.assertEquals(expected, actual);
			sa.assertAll();
		}
		
		else if(type.equalsIgnoreCase("invaliddata")) {
			
			waitExplicit(loginemailbutton, 2);
			textKey(loginemailbutton, email);
			textKey(loginpasswdbutton, password);
			buttonClick(signinbutton);
			waitExplicit(errorMessage, 5);
			String expected=text;
			String actual=elementText(errorMessage);
			sa.assertEquals(actual, expected);
			sa.assertAll();
		}else {
			System.out.println("Login is failed");}
		
		return this;
	}
	
	public HeaderMenu loginToPay(String vlogemail, String vlogpass) {
		SoftAssert sa = new SoftAssert();
		waitExplicit(loginemailbutton, 3);
		textKey(loginemailbutton, vlogemail);
		textKey(loginpasswdbutton, vlogpass);
		buttonClick(signinbutton);
		sa.assertAll();
		return new HeaderMenu(driver);
	}
	
	public void guest() {
		waitExplicit(guestbutton, 2);
		buttonClick(guestbutton);
	}
}
