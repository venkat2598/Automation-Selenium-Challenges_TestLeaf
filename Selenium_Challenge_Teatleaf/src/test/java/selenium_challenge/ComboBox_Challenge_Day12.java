package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ComboBox_Challenge_Day12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup(); 
		WebDriver driver= new FirefoxDriver();
		String url = "https://login.salesforce.com";
		driver.get(url);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));	
		System.out.println("Navigated to the Website");
	
		WebElement Username=driver.findElement(By.id("username"));
		Username.sendKeys("vinothkumar@testleaf.com");
		System.out.println("Entering username");
				
		WebElement Password=driver.findElement(By.id("password"));
		Password.sendKeys("SeleniumChallenge@24");
		System.out.println("Entering Password");
		
		WebElement loginnbtn=driver.findElement(By.id("Login"));
		loginnbtn.click();
		System.out.println("Clicking the login button");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement Searchbox=driver.findElement(By.xpath("//input[@placeholder='Quick Find']"));
		Searchbox.sendKeys("App Manager");
		System.out.println("Sending the input into the quicksearch box");
		
		driver.findElement(By.linkText("App Manager")).click();
		System.out.println("Clicking the the app manager link after search the result");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		WebElement NewconnenctedAppbtn=driver.findElement(By.xpath("//*[text()='New Connected App']"));
		NewconnenctedAppbtn.click();
		System.out.println("Clicking the new connected app button");  
	
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("vfFrameId_1720859434486"));
		
		driver.switchTo().frame(0);
		
		WebElement Appname=	driver.findElement(By.xpath("(//div[@class='requiredInput']/input)[1]"));
		wait.until(ExpectedConditions.visibilityOf(Appname)).sendKeys("Plato");
		System.out.println("Entering the app name");
		
		WebElement APIName=driver.findElement(By.xpath("(//div[@class='requiredInput']/input)[2]"));
		APIName.sendKeys("Venkat");
		System.out.println("Entering the API name");
		
		
		WebElement ContactEmail=driver.findElement(By.xpath("(//div[@class='requiredInput']/input)[3]"));
		ContactEmail.sendKeys("test@gmail.com");
		System.out.println("Entering the contact email address");
		
		WebElement OAuthbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", OAuthbox);
		System.out.println("clicking the OAuth checkbox");
		
		WebElement Dropdownlist=driver.findElement(By.xpath("(//select[@class='dueling '])[1]"));
		Select select=new Select(Dropdownlist);
		select.selectByIndex(0);
		select.selectByIndex(1);
		select.selectByIndex(2);
		select.selectByIndex(3);
		select.selectByIndex(4);
		select.selectByIndex(5);
		System.out.println("Seleting 6 item in the options");
		
		select.deselectByIndex(5);
		select.deselectByIndex(4);
		select.deselectByIndex(3);
		System.out.println("deSeleting last 3 item in the options");
		
		WebElement savebtn=driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
		JavascriptExecutor javasc=(JavascriptExecutor)driver;
		javasc.executeScript("arguments[0].scrollIntoView(true);", savebtn);
		savebtn.click();
		System.out.println("Scorll the page once view and clicking the save button");
		
		driver.quit();	
	}

}
