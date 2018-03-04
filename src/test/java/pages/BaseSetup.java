package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseSetup implements ITestListener{
	
	private String name;
	protected  WebDriver driver;	
	
	@BeforeMethod
	public void beforeMethod() throws IOException{
		Reporter.log("Before Method", true);
		
		Properties p = new Properties();
		FileInputStream inputData = new FileInputStream("./global.properties");
		p.load(inputData);
		String testbroswer = p.getProperty("browserName"); 
		
		if (testbroswer.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./drivers/mac/chromedriver");
			driver = new ChromeDriver();
		} else if(testbroswer.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.drive", "./drivers/mac/geckodriver");
			driver = new FirefoxDriver();
		} else {
			Reporter.log("Driver EXE not found", true);
			driver = null;
		}
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod(){
		Reporter.log("After Method", true);
		driver.quit();
	}

	
	public void onStart(ITestContext context) {
		name = context.getName();
		Reporter.log("On Start Listner: Test Group Name = "+name+"\n", true);	
	}
	
	public void onTestStart(ITestResult result) {
		name = result.getMethod().getMethodName();
		Reporter.log("On Test Start Listner: Begining Test name : " +name+" started execution", true);
	}

	public void onTestSuccess(ITestResult result) {
		name = result.getMethod().getMethodName();
		Reporter.log("On Test Success Listner: Test Name : "+name+" Passed successfully", true);		
	}
	
	public void onTestFailure(ITestResult result) {
		name = result.getName();
		Reporter.log("On Test Fail Listner -> I Can Take Screen Shots & Test Method"+name+" has FAILED", true);
		
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("On Test Skipped Listner", true);
		
	}

	public void onFinish(ITestContext context) {
		name = context.getName();
		Reporter.log("On Finish Listner: Test Group Name = "+name+" Finished Execution\n", true);
		Reporter.log("Passed Tests: " + context.getPassedTests().size(), true);
		Reporter.log("Failed Tests:" + context.getFailedTests().size(), true);
		
	}
	
	public void OpenTestWebSite(String WebSiteURL) {
		driver.get(WebSiteURL);
	}
	
	public void GoBackPage(){
		driver.navigate().back();
	}

}
