package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	
	private WebDriver driver;
	
	public GoogleSearchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="lst-ib")
	WebElement searchbox;
	
	@FindBy(linkText="Flights")
	WebElement FlightsLink;
	
	public void searchgoogle(String SearchKeyword) throws Exception{
		searchbox.sendKeys(SearchKeyword);
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	
	public void clickLink(String linkName) throws Exception{
		driver.findElement(By.linkText(linkName)).click();
		Thread.sleep(2000);
		
		Set<String> anil = driver.getWindowHandles();
		
		for (String string : anil) {
			System.out.println("Window Handle: "+ string);
		}
	}
	
	

}
