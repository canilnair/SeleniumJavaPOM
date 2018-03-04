package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.BasePage;

public class PageNavigationTest extends BasePage{
	

	String baseRL="http://letskodeit.teachable.com/";
	String baseURL2="https://www.directenergy.com/";

	@Test
	public void LestKodeIt_Test001() {
		OpenTestWebSite(baseRL);
		UsingLestCodeItPage().ClickOnEnrollNowLink();
		GoBackPage();
		UsingLestCodeItPage().ClickOnLogin();
		GoBackPage();
	}
	
	@Test
	public void DirectEnergy_test001() {
		driver.get(baseURL2);
		assertEquals("Direct Energy: a Leading Provider of Electricity, Natural Gas Across North America", GetPageTitle());
	}
	
	@Test
	public void LestKodeIt_Test002() {
		driver.get(baseURL2);
		assertTrue(UsingLestCodeItPage().IsSignUpEnabled());
		
	}
	
	@Test
	public void LestKodeIt_Test004() throws Exception{
		OpenTestWebSite(baseRL);
		UsingLestCodeItPage().ClickOnPraticeLink();
		UsingLestCodeItPage().ClickOnAllRadioAndCheckBox();
		UsingLestCodeItPage().PerformAllActionOnParcticePage();
	}
	
}
