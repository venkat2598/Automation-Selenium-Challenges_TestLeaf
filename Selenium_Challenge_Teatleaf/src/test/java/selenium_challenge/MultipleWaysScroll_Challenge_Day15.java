package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWaysScroll_Challenge_Day15 {
	
	public void UsingScrollBy() {
		
		//WebDriverManager.firefoxdriver().setup(); 
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver= new FirefoxDriver(op);
		String url = "https://www.espncricinfo.com/";
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));	
	//	driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Series']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//div[@class='ds-px-2 ds-py-2']//li[1]"))).click().build().perform();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
		WebElement Headertitle1=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[1]//h2"));
		String titlename=Headertitle1.getText();
		System.out.println(titlename);
		WebElement subtitle=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[1]//div"));
		String subtitletext=subtitle.getText();
		System.out.println(subtitletext);
		
		WebElement Headertitle2=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[2]//h2"));
		String title2=Headertitle2.getText();
		System.out.println(title2);
		WebElement Subtitle2=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[2]//div"));
		String subtitletext2=Subtitle2.getText();
		System.out.println(subtitletext2);
		
		driver.quit();
	}
	
	public  void UsingScrollIntoView() {
		
		//WebDriverManager.firefoxdriver().setup(); 
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver= new FirefoxDriver(op);
		String url = "https://www.espncricinfo.com/";
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));	
	//	driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Series']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//div[@class='ds-px-2 ds-py-2']//li[1]"))).click().build().perform();
			
		WebElement Headertitle1=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[1]//h2"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Headertitle1);
		String titlename=Headertitle1.getText();
		System.out.println(titlename);
		
		WebElement subtitle=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[1]//div"));
		String subtitletext=subtitle.getText();
		System.out.println(subtitletext);
		
		WebElement Headertitle2=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[2]//h2"));
		String title2=Headertitle2.getText();
		System.out.println(title2);
		WebElement Subtitle2=driver.findElement(By.xpath("(//div[@class='ds-flex ds-flex-col'])[2]//div"));
		String subtitletext2=Subtitle2.getText();
		System.out.println(subtitletext2);
		
		driver.quit();
	}


	public static void main(String[] args) {
		
		MultipleWaysScroll_Challenge_Day15 day11=new MultipleWaysScroll_Challenge_Day15();
		day11.UsingScrollBy();
		day11.UsingScrollIntoView();
	
	
	}

}
