package pages;

import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
	
	private WebDriver driver;
	
	public FlightsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='OMOBOQD-mb-u']")
	WebElement NewYorkCity;
	
	@FindBy(xpath="//div[@class='DQX2Q1B-Kb-b']")
	WebElement destinationTab;
	
	
	public void clickNewYorkTab() throws Exception{
		destinationTab.click();
		destinationTab.sendKeys("New York");
		Thread.sleep(1000);
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
	
	}
}
