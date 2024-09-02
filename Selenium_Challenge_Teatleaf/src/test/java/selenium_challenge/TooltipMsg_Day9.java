package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TooltipMsg_Day9 {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		String URL= "https://www.mapz.com/map";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//Clicking on the draw tab link
		WebElement drawtab=driver.findElement(By.xpath("//a[contains(text(),'Draw')]"));
		drawtab.click();

		//Identify the email text fielld
		WebElement HoverEmailField   =driver.findElement(By.id("email"));

		Actions action=new Actions(driver);
		//hover the  mouse into the email field 
		action.moveToElement(HoverEmailField).build().perform();
		//wait for some time to visible the tooltip text
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// here we mentioned the title - attribute or tooltip locators
		String Tooltiptext  =HoverEmailField.getAttribute("validationMessage"); 
		//  retrievve the text  and store
		

		//finally print the text value.
		System.out.println("Actual Tooltip Msg is:" + Tooltiptext);
		driver.quit();


	}

}
