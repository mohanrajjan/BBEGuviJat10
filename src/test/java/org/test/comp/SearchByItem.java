package org.test.comp;

import org.base.com.EngineClass;
import org.pages.com.CartPage;
import org.pages.com.LoginPage;
import org.pages.com.PLPPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SearchByItem extends EngineClass{
	
	@BeforeTest
	public void setup() throws Exception {
		sheetname="Payment";
		openProp();
	}

	@Test(dataProvider = "getData")
	
	public void searchItem(String CardNumber, String ExpirationDate, String CVV, String Searchproduct) {
		test = report.createTest("Search By Item");
		LoginPage lp = new LoginPage(driver);
		PLPPage pl= new PLPPage();
		pl.searchByProduct(Searchproduct);
		test.log(Status.PASS, "Item added Successful");
	}
}
