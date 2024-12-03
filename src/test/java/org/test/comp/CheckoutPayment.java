package org.test.comp;

import org.base.com.EngineClass;
import org.pages.com.CartPage;
import org.pages.com.CheckoutPage;
import org.pages.com.LoginPage;
import org.pages.com.PLPPage;
import org.pages.com.PaymentPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CheckoutPayment extends EngineClass{

	


	@BeforeTest
	public void setup() throws Exception {
		sheetname="Payment";
		openProp();
	}
	
	
	@Test(groups= {"purchase","Regression"},dataProvider = "getData")
	public void searchForItem( String CardNumber, String ExpirationDate, String CVV,String Searchproduct) {
		test = report.createTest("Checkout and Payment");
		LoginPage lp = new LoginPage(driver);
		PLPPage pl= new PLPPage();
		CartPage cp = new CartPage();
		CheckoutPage co = new CheckoutPage();
		PaymentPage pp = new PaymentPage();
		waitImplicit(3);
		pl.searchByProduct(Searchproduct);
		cp.pickupatstore();
		lp.guest();
		co.gotopaymentpage();
		pp.visaPayment(CardNumber, ExpirationDate, CVV, prop.getProperty("vFirstName"), prop.getProperty("vLastName"), prop.getProperty("vAddress"), prop.getProperty("vCity"), prop.getProperty("vZipcode"));
		test.log(Status.PASS, "Successful");
	}
	
	
	
	
}
