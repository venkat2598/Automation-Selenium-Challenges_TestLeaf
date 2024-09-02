package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandling_Day11 {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		String URL= "https://www.telerik.com/contact";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//select Invoice/Billing  from the dropdown
		WebElement Firstdropdown=driver.findElement(By.id("Dropdown-1"));
		Select select= new Select(Firstdropdown);
		select.selectByValue("Invoicing/Billing");
		System.out.println("selected Invoicing/Billing ");
		
		//select Testing Framework  from the dropdown
		WebElement SecondDropdow = driver.findElement(By.id("Dropdown-2"));
		Select select1= new Select(SecondDropdow);
		select1.selectByValue("Testing Framework");
		System.out.println("selected Testing Framework ");
		
		WebElement firstname=driver.findElement(By.id("Textbox-1"));
		firstname.sendKeys("Venkat");
		
		WebElement lastname=driver.findElement(By.id("Textbox-2"));
		lastname.sendKeys("K K");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window-scrollBy(0,350)", "");
		
		//select United  states from the country dropdown
		WebElement countrydropdown=driver.findElement(By.id("Country-1"));
		Select select2= new Select(countrydropdown);
		select2.selectByIndex(1);
		
		System.out.println("Finally selected United States country!!!");
		driver.quit();
		
	}
}
