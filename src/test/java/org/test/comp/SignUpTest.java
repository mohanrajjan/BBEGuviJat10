package org.test.comp;

import org.base.com.EngineClass;
import org.pages.com.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SignUpTest extends EngineClass {
	
	@BeforeTest
	public void setup() throws Exception {
		openProp();
	}

	@Test(groups={"Signup","Smoke"})
	public void SignUpTC01() {
		 test = report.createTest("Invalid Signup");
		 SignUpPage sp= new SignUpPage();
		 System.out.println(prop.getProperty("IFirstName"));
		 sp.invalidSignUp(prop.getProperty("iFirstName"),prop.getProperty("iLastName"),prop.getProperty("iPass"),
         prop.getProperty("iCPass"),prop.getProperty("iMobile"),prop.getProperty("iEmail"));
		 test.log(Status.PASS, "SignUp not Successful");
	}
	
	@Test(groups={"Signup","Regression"})
	public void SignUpTC02() {
		 test = report.createTest("Valid SignUp");
		 SignUpPage sp= new SignUpPage();
		 sp.validSignUp(prop.getProperty("vFirstName"),prop.getProperty("vLastName"),prop.getProperty("vPass"),
        prop.getProperty("vCPass"),prop.getProperty("vMobile"),prop.getProperty("vEmail"));
		 test.log(Status.PASS, "SignUp Successful");
	}
}
