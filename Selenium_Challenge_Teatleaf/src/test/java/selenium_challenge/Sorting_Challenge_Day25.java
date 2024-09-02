package selenium_challenge;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.*;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sorting_Challenge_Day25 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		FirefoxDriver driver= new FirefoxDriver(op);
		String url = "https://www.moglix.com/";
		driver.get(url);	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("search-input"))).sendKeys("TV"+Keys.RETURN);
		//driver.findElement(By.xpath("//div[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List <WebElement> AllTVPrices=driver.findElements(By.xpath("//div[@class='prod-selling-price ng-star-inserted']"));
		System.out.println("Total list of prices count is : " +AllTVPrices.size());
		Map<WebElement,Integer> maps=new HashMap<WebElement,Integer>();
		
		
		
		for(int i=1;i<AllTVPrices.size();i++) {
			
			maps.put(AllTVPrices.get(i), Integer.parseInt(AllTVPrices.get(i).getText().replaceAll(",", "").replaceAll("₹", "")));
			
		}
			
		List<Entry<WebElement,Integer>> Pricelist=new ArrayList<Map.Entry<WebElement,Integer>>(maps.entrySet());
		Pricelist.sort(Entry.comparingByValue());
		
		for (Entry e : Pricelist) {
			
			System.out.println(e.getValue());
		}
		
		Pricelist.get(0).getKey().click();
		Pricelist.get(0).getKey().click();
		String parentwindow=driver.getWindowHandle();
		for (String newwindows : driver.getWindowHandles()) {
			if(!newwindows.equals(parentwindow)) {
				driver.switchTo().window(newwindows);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				WebElement addtocart=new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn add-to-cart-btn default-btn']")));
				driver.executeScript("arguments[0].click();", addtocart);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement carticon=driver.findElement(By.xpath("//p[text()='Cart']"));
				driver.executeScript("arguments[0].click();", carticon);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				String gettotalvalue=driver.findElement(By.xpath("//li[@class='border']")).getText();
				System.out.println(gettotalvalue);
			}
		}
		driver.quit();
		
		
	}

}
