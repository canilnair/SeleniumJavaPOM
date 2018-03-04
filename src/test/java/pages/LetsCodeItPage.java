package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetsCodeItPage {
	
	private WebDriver driver;
	
	public LetsCodeItPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Enroll now']")
	WebElement EnrollNowLink;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement LoginLink;
	
	@FindBy(xpath = ("//a[text()='Sign Up']"))
	WebElement SignUpLink;
	
	@FindBy(xpath = "//a[contains(text(),'Practice')]")
	WebElement PracticeLink;
	
	public void ClickOnPraticeLink(){
		PracticeLink.click();
	}
	
	public void ClickOnAllRadioAndCheckBox(){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> x = driver.findElements(By.xpath("//input[(@type='radio') or (@type='checkbox')]"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<x.size();i++){
			x.get(i).click();
		}
	}
	
	public void PerformAllActionOnParcticePage() throws InterruptedException{
		
		String main = driver.getWindowHandle();
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		for (String string : windows) {
			if(!string.equals(main)){
				driver.switchTo().window(string);
				driver.findElement(By.xpath("//div[contains(text(),'Selenium WebDriver With Java')]")).click();
				driver.close();
			}
		}
		driver.switchTo().window(main);
		Thread.sleep(1000);
		List<WebElement> drop = driver.findElements(By.xpath("//select[@id='carselect']/option"));
		for (WebElement webElement : drop) {
			webElement.click();
			System.out.println(webElement.getText());
		}
		
		driver.findElement(By.id("name")).sendKeys("Anil Nair");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys("Anil Nair");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
	}
	
	public void ClickOnEnrollNowLink(){
		EnrollNowLink.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ClickOnLogin(){
		LoginLink.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean IsSignUpEnabled(){
		return SignUpLink.isEnabled();
	}

}
