package org.base.com;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.utilities.com.CommonUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EngineClass extends CommonUtilities{

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		Htmlreport = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//index.html");
		report = new ExtentReports();
		report.attachReporter(Htmlreport);
		report.setSystemInfo("Tester", "Mohanraj");
			}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bestbuy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//img[@alt='United States'])[1]")).click();
	}
	
	@DataProvider(name ="getData")
	public String[][] getData() throws Exception {
		String[][] data = readExcel(sheetname);
		return data;
	}
	
	
	@AfterTest(alwaysRun=true)
	public void afterTest() {
		
	}
		
	@AfterMethod()
	public void getResult(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		test.log(Status.FAIL,result.getThrowable());
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"//sscreenshot1"+"ss"+".png";
		FileHandler.copy(source, new File(screenshotpath));
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		//driver.close();
		}
		
	@AfterSuite(alwaysRun=true)
	 public void afterSuite() {
		report.flush();
	}
}
