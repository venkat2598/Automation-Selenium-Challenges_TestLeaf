package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameChallenge_Day17 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver= new FirefoxDriver(op);
		String url = "https://login.salesforce.com/";
		driver.get(url);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$123");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//clicking the App Launcher icon
		
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		//
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search apps and items...']"))).sendKeys("Opportunities");
		
		//clicking the opportunities title from the list
		driver.findElement(By.xpath("//a[@id='Opportunity']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//clicking the first opportunities text
		driver.findElement(By.xpath("(//table[@role='grid']//tbody//th//a)[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Email  button under activity tab
		driver.findElement(By.xpath("(//*[text()='Email'])[2]")).click();

		// To address box
		driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).sendKeys("kkvenkat1998@gmail.com");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement parentframe= driver.findElement(By.xpath("//iframe[@title='CK Editor Container']"));
		driver.switchTo().frame(parentframe);
		WebElement childframe= driver.findElement(By.xpath("//iframe[@title='Email Body']"));
		driver.switchTo().frame(childframe);
		
		//WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

		//Finally enter the  text into the content box
		WebElement Emailbody= driver.findElement(By.xpath("//body[@role='textbox']"));
		Emailbody.clear();
		Emailbody.sendKeys("I have completed the Selenium Challenge 13");
		
		
		driver.switchTo().defaultContent();
		
		//clicking the send button
		driver.findElement(By.xpath("//button[@type='button']/span[text()='Send']")).click();

		//quit the browser
		driver.quit();

	}

}
