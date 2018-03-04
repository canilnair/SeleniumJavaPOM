package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DirectEnergyPage {
	
	public DirectEnergyPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
