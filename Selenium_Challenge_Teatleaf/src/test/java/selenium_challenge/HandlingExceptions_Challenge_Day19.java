package selenium_challenge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HandlingExceptions_Challenge_Day19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver= new FirefoxDriver(op);
		String url = "https://www.saucedemo.com/";
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("(//div[@class='login-box']//input)[3]")).click();
		WebElement click = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", click);
		String price = driver.findElement(By.className("inventory_details_price")).getText();
		System.out.println("Price of Backpack "+price);
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.xpath("//button[text()='Continue Shopping']/following::button")).click();
		driver.findElement(By.id("first-name")).sendKeys("Leaf");
		driver.findElement(By.id("last-name")).sendKeys("Test");
		driver.findElement(By.name("postalCode")).sendKeys("600114");
		driver.findElement(By.xpath("//button[text()='Cancel']/following-sibling::input")).click();
		String sauceCard=  driver.findElement(By.xpath("//div[text()='Payment Information:']/following-sibling::div")).getText();
		System.out.println(sauceCard);
		driver.findElement(By.xpath("//button[text()='Finish']")).click();

		
	}

}
