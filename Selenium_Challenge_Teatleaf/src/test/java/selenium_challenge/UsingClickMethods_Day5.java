package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingClickMethods_Day5 {
	/*
	 * Multiple Ways in click methods
	 * 
	 * 1. Directly use click method -  click();
	 * 2.  using javascriptexecutor 
	 * 	  javascripexecutor js=(javascriptexecutor)driver;
	 *    js.executescript("arguments[0].click;", element);
	 *    
	 * 3. Using action class
	 * 	Actions action=new Actions(driver);
	 * 	action.click().perform();
	 * 
	 * 
	 * */
	 WebDriver driver;
	 Actions action;

	public void Testcase1() {

		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		String BaseUrl= "https://my.aidaform.com/signup";
		driver.get(BaseUrl);

		WebElement Username =driver.findElement(By.name("nickname"));
		Username.sendKeys("Venkat");

		WebElement Email=driver.findElement(By.xpath("//input[@name='email']"));
		Email.sendKeys("abc@gmail.com");

		WebElement Password=driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("123456");

		WebElement Confirm_Password=driver.findElement(By.xpath("//input[@name='confirm']"));
		Confirm_Password.sendKeys("123456");


		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		WebElement clickcheckbox=driver.findElement(By.xpath("//input[@value='true']")); 
		action=new Actions(driver);
		action.moveToElement(clickcheckbox).click().build().perform();

		WebElement Clickcreate_freeacccount=driver.findElement(By.xpath("//button[@type='submit']"));
		Clickcreate_freeacccount.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.quit();

	}


	public void  Testcase2() {

		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		String BaseUrl= "https://gemini.google.com/"; // hit the website
		driver.get(BaseUrl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		System.out.println("Page Title : " + driver.getTitle());

		//clicking the sign in button
		WebElement Signbtn=driver.findElement(By.linkText("Sign in"));
		Signbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//after clicking the signup then retrive the page  title
		String PageTitleName=driver.getTitle();
		System.out.println(PageTitleName);

		driver.quit();

	}


	public void Testcase3() {

		/* I have tried many ways to finish the testcases.
		 * But I couldn't to finish. Once you are reviewed the code. 
		 * kindly provide the correct code for testcase3 and What i made a mistake in this code. 
		 */

		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		String BaseUrl= "https://petdiseasealerts.org/forecast-map#/";
		driver.get(BaseUrl);	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.switchTo().frame(0);

		WebElement Heartwormlink=driver.findElement(By.xpath("//a[text()='Heartworm']"));
		WebElement TickBorneDiseaseAgent=driver.findElement(By.xpath("//span[text()='Tick Borne Disease Agents']"));


		action=new Actions(driver);
		action.moveToElement(Heartwormlink).perform();
		action.click(TickBorneDiseaseAgent).perform();

		driver.quit();



	}

	public static void main(String[] args) {


		UsingClickMethods_Day5 Click= new UsingClickMethods_Day5();
		Click.Testcase1();
		Click.Testcase2(); 
		Click.Testcase3();





	}
}
