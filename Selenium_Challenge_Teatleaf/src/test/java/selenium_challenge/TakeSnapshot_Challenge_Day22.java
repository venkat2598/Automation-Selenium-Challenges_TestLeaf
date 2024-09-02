package selenium_challenge;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class TakeSnapshot_Challenge_Day22 {

	public static WebDriver driver;
	private static void captureSnapshot() {
		
		Date date=new Date();
		
		//Using both Timestamp  format will be work perfectly based on our needs pick any one.
		String Filename=date.toString().replace(":", "-").replace(" ", "-") + ".png";
		String Timestamp=new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss").format(date);
		
		TakesScreenshot snapshot=(TakesScreenshot)driver;
		File source= snapshot.getScreenshotAs(OutputType.FILE);
		try { 
		//I don't mentioned any location so the snapshot will store in our project area if we mentioned Specific location then it will store that location.
			FileHandler.copy(source, new File(Filename + ".png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		driver= new FirefoxDriver(op);
		String url = "https://www.codehim.com/demo/single-page-shopping-cart-template/";
		driver.get(url);

		new Actions(driver).moveToElement(driver.findElement(By.xpath("(//div[@class='product-front'])[1]"))).perform();
		driver.findElement(By.xpath("//div[text()='Add to cart']")).click();
		captureSnapshot();
		driver.findElement(By.xpath("//div[text()='View gallery']")).click();
		captureSnapshot();
		driver.close();



	}

}
