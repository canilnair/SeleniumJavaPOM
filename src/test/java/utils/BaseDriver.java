package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BaseDriver{
	
	protected WebDriver driver;
	protected String website;
	
	public WebDriver setDriver() throws IOException{			
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
		
		return driver;
		
	}

}
