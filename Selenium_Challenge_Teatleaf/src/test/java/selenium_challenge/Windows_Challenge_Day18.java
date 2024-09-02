package selenium_challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows_Challenge_Day18 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		//WebDriverManager.firefoxdriver().setup();
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver= new FirefoxDriver(op);
		String url = "https://www.irctc.co.in/nget/train-search";
		driver.get(url);
		
		String parentwindow=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//*[contains(text(),' BUSES ')]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String childwindowtitle="IRCTC Bus - Online Bus Ticket Booking | Bus Reservation";
		
		Set <String> allwindow=driver.getWindowHandles();
		
		for (String Newwindow : allwindow) {
			if(!Newwindow.equals(parentwindow)) {
			driver.switchTo().window(Newwindow).getTitle().equals(childwindowtitle);
			String childPageUrl=driver.switchTo().window(Newwindow).getCurrentUrl();
			System.out.println(childPageUrl);
			}
			
		}
		
		driver.quit();

	}

}
