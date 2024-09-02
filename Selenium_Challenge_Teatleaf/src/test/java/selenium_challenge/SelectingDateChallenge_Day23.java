package selenium_challenge;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectingDateChallenge_Day23 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		FirefoxDriver driver= new FirefoxDriver(op);
		String url = "https://www.cheapoair.com/";
		driver.get(url);	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		
		new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.className("modal-close-icon"))).click();
		WebElement onewaytripbtn=driver.findElement(By.id("onewayTrip"));
		driver.executeScript("arguments[0].click();", onewaytripbtn);	
		driver.findElement(By.id("from0")).sendKeys("MAA");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='MAA']"))).click();
		driver.findElement(By.id("to0")).sendKeys("DXB");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='DXB']"))).click();
		driver.findElement(By.id("cal0")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,  'month-date is--today')]//following::a"))).click();
		driver.findElement(By.id("travellerButton")).click();		
		driver.findElement(By.id("removeadults")).click();
		driver.findElement(By.id("addadults")).click();
		driver.findElement(By.id("addseniors")).click();
		driver.findElement(By.id("closeDialog")).click();
		driver.findElement(By.id("searchNow")).click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//	new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated((By.id("fare-alert__closeBtn")))).click();
		List<WebElement> Allflightprices=driver.findElements(By.xpath("//span[@class='currency text-nowrap']"));
		System.out.println(Allflightprices.size());
		List<Double> alist=new ArrayList<Double>();
		for (WebElement prices : Allflightprices) {
			String pricetitle=prices.getAttribute("title");
			Double dprice=Double.parseDouble(pricetitle);
			alist.add(dprice);
		}
		System.out.println(alist);
		List<Double> pr=new ArrayList<Double>(alist);
		Double lowestfligtprice=pr.get(0);
		System.out.println(lowestfligtprice);



	}

}
