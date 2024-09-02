package selenium_challenge;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.http.impl.nio.ExpandableBuffer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.Color;


public class Locators_Day3 {
	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		String BaseUrl= "https://www.marutisuzuki.com/";
		driver.get(BaseUrl);

		//clicking search icon 
		WebElement searchIcon= driver.findElement(By.className("headerSearch-btn"));
		searchIcon.click();

		//in  search box entering search terms 
		WebElement searchbox=driver.findElement(By.xpath("//ul[@id='searchopen']//div/input"));
		searchbox.sendKeys("Swift"+Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//clicking the car info option
		WebElement carinfo= driver.findElement(By.className("icon-general_info"));
		carinfo.click();


		// count of the city 
		List<WebElement> countcityvalue=driver.findElements(By.xpath("//select[@id='selectcity1']/option"));
		int totalcity=countcityvalue.size();
		System.out.println(totalcity);

		//print the last city name
		WebElement lastcityname=driver.findElement(By.xpath("//select[@id='selectcity1']/option[last()]"));
		System.out.println(lastcityname.getText());

		//select the last city name
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement selectlastcity=driver.findElement(By.id("selectcity1"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectcity1"))).click();
		Select select= new Select(selectlastcity);
		select.selectByVisibleText("ZIRO");




		//clicking safety link  
		//ul[@class='navbar-nav mr-auto']/li[3]  
		WebElement safetylink=driver.findElement(By.id("safety"));
		safetylink.click();

		//Print the safety discription
		WebElement Safetydis=driver.findElement(By.xpath("//div[@class='safety-dis']/p[1]"));
		System.out.println(Safetydis.getText());

		WebElement Safetydis2=driver.findElement(By.xpath("//div[@class='safety-dis']/p[2]"));
		System.out.println(Safetydis2.getText());

		//clicking the colours section
		WebElement colorsec=driver.findElement(By.id("colors"));
		colorsec.click();


		//print the selected colour
		WebElement selectedcolor=driver.findElement(By.className("msr-red--pm-black"));
		String carcolorname=selectedcolor.getCssValue("background-color").toString();
		System.out.println(carcolorname);
		

		driver.quit();


	}
}
