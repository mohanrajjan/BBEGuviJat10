package org.test.comp;

import org.base.com.EngineClass;
import org.pages.com.HeaderMenu;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class HeaderTest extends EngineClass{

	@Test(groups= {"Smoke","Deals"})
	public void tc01() {
		test = report.createTest("Deals headers");
		HeaderMenu hm = new HeaderMenu(driver);
		hm.bestbuydaypage();
		hm.dealofthedaypage();
		hm.fridaydealpage();
		hm.topdealspage();
		test.log(Status.PASS, "Deals headers verfied successfull");
	}
	
	@Test(groups= {"Smoke","Profile"})
	public void tc02() {
		test = report.createTest("Acounts Details");
		HeaderMenu hm = new HeaderMenu(driver);
		hm.cartpage();
		hm.recentlyviewedpage();
		hm.saveditemspage();
		hm.orderstatuspage();
		test.log(Status.PASS, "Accounts details verfied successfull");
	}
	
}
