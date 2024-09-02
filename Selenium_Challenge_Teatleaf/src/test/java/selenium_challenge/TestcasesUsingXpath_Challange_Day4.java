package selenium_challenge;

import java.time.Duration;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestcasesUsingXpath_Challange_Day4 {
	public static void main(String[] args) {
		
		//browser setup  and lanuch the website 
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		String BaseUrl= "https://www.cartify.pk/";
		driver.get(BaseUrl);

		//clicking the shop by categories link
		WebElement shopbycategorieslink=driver.findElement(By.xpath("//ul[@id='SiteNav']/li[3]"));
		shopbycategorieslink.click();

		//clicking the cloth Rack category
		WebElement clothrack=driver.findElement(By.xpath("//div[contains(text(),'Cloth Rack')]"));
		clothrack.click();
		
		//selecting floor standing cloth rack cloth wheels items
		WebElement floorclothrackitem=driver.findElement(By.xpath("//ul[@class='grid grid--uniform grid--view-items']/li[1]"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(floorclothrackitem));
		floorclothrackitem.click();
		
		//add the items into the cart 
		WebElement itemintoaddtocart=driver.findElement(By.xpath("//button[@name='add']"));
		itemintoaddtocart.click();
		
		//view cart section
		WebElement viewcartsec=driver.findElement(By.xpath("//div[@class='cart-popup']/a"));
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(viewcartsec));
		viewcartsec.click();
		
		
		// print the subtotal price of the item
		WebElement subtotalprice=driver.findElement(By.xpath("//span[@class='cart-subtotal__price']"));
		System.out.println("SubtotalPrice is :" + subtotalprice.getText());
	
		//close the browser
		driver.quit();
		
		
		
		



	
	}
}








