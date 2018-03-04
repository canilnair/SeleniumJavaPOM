package pages;

public class BasePage extends BaseSetup{
	
	public String GetPageTitle(){
		return driver.getTitle();
	}
	
	public FlightsPage UsingFlightsPage(){
		return new FlightsPage(driver);		
	}
	
	public GoogleSearchPage UsingGoogleSearchPage(){
		return new GoogleSearchPage(driver);
	}
	
	public LetsCodeItPage UsingLestCodeItPage(){
		return new LetsCodeItPage(driver);
	}
	
	public DirectEnergyPage UsingDirectEnergyPage(){
		return new DirectEnergyPage(driver);
	}
	
}
