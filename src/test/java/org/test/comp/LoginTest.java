package org.test.comp;

import org.base.com.EngineClass;
import org.pages.com.HeaderMenu;
import org.pages.com.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest extends EngineClass{
	
	
	@BeforeTest
	public void setup() throws Exception {
		sheetname="LoginData";
	}
	
	
	@Test(dataProvider = "getData")
	
	public void loginTest(String email, String password, String type, String text) {
		test = report.createTest("Validating Login");
		HeaderMenu hm = new HeaderMenu(driver);
		hm.loginIcon()
		.checkLogin(email, password, type, text);
		test.log(Status.PASS, "Successfully Validated");
	}

}
