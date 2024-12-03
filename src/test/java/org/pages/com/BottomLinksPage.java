package org.pages.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import org.utilities.com.CommonUtilities;

public class BottomLinksPage extends CommonUtilities{

	public BottomLinksPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Gift Cards'])[2]")
	WebElement giftcardslink;
	
	@FindBy(xpath="//a[text()='Returns & Exchanges']")
	WebElement returnandexchangelink;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	WebElement contactuslink;
	
	@FindBy(xpath="//a[text()='View Points & Certificates']")
	WebElement viewpointslink;
	
	@FindBy(xpath="//button[text()='Skip for now']")
	WebElement skiprecoverymobile;
	
		public void giftcardbottom() {
			SoftAssert sa =new SoftAssert();
			pageBottom();
			buttonClick(giftcardslink);
			String actual=getTitle();
			String expected="Gifts Cards and E-Gift Cards - Best Buy";
			sa.assertEquals(expected, actual);
			sa.assertAll();
		}
		
		public void returnExchange() {
			SoftAssert sa =new SoftAssert();
			pageBottom();
			buttonClick(returnandexchangelink);
			String actual=getTitle();
			String expected="Best Buy Return & Exchange Policy - Best Buy";
			sa.assertEquals(expected, actual);
			sa.assertAll();
		}
		
		public void contactus() {
			SoftAssert sa =new SoftAssert();
			pageBottom();
			buttonClick(contactuslink);
			String actual=getTitle();
			String expected="Contact Us";
			sa.assertEquals(expected, actual);
			sa.assertAll();
		}
		
		public void rewardpoints() {
			SoftAssert sa =new SoftAssert();
			pageBottom();
			buttonClick(viewpointslink);
			buttonClick(skiprecoverymobile);
			String actual=getTitle();
			String expected="Rewards Overview - Best Buy";
			sa.assertEquals(expected, actual);
			sa.assertAll();
		}
}
