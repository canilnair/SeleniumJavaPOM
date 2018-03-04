package tests;

import org.testng.annotations.Test;

import pages.BasePage;

public class GoogleSearchFlightBookingTest extends BasePage{ 
	
	String testURL = "https://www.google.com/";
	
//	@Test
	public void flightbooking() throws Exception{
		
		OpenTestWebSite(testURL);
		UsingGoogleSearchPage().searchgoogle("Flight Booking");		
		UsingGoogleSearchPage().clickLink("Flights");
		UsingFlightsPage().clickNewYorkTab();
	}
	
	@Test
	public void flightcancel() throws Exception{		
		OpenTestWebSite(testURL);
		UsingGoogleSearchPage().searchgoogle("Flight Cancel");
		UsingGoogleSearchPage().clickLink("News");
	}
	
	//@Test
	public void flightbookingFactory() throws Exception{
		
		OpenTestWebSite(testURL);
		UsingGoogleSearchPage().searchgoogle("Flights Booking");
		UsingGoogleSearchPage().clickLink("Flights");
		UsingFlightsPage().clickNewYorkTab();
	}

}
