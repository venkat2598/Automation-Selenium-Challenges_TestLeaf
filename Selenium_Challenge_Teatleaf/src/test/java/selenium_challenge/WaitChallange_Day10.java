package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitChallange_Day10 {


	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String URL="https://commercejs-demo-store.netlify.app/";
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		JavascriptExecutor js=(JavascriptExecutor) driver;

		//clicking the shop now button
		WebElement shopbtn=driver.findElement(By.linkText("Shop now"));
		js.executeScript("arguments[0].click();", shopbtn);
		System.out.println("Shop button is clicked");

		js.executeScript("window-scrollBy(0,520)", "");

		
		//clicking the Shampoo & Conditioner Set product under hair product section)
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Shampoo & Conditioner Set']"))).click();
		System.out.println("Shampoo product  is selected");
		
		//wait for some time to present the element in dom then clicking the add to cart button
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add to cart']"))).click();
		System.out.println("product is selected and move to add to cart");
		
		driver.quit();



	}

}
