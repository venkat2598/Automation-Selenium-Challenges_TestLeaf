package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class AlertChallenge_Day16 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		String url = "https://codepen.io/unknownUser7/pen/ZEdGLbq";
		driver.get(url);


		driver.switchTo().frame(0);

		driver.findElement(By.id("username")).sendKeys("user");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String alerttext =driver.switchTo().alert().getText();
		System.out.println("Alert text is : "  + alerttext);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().alert().accept();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement Afterlogintext=driver.findElement(By.xpath("//div[@id='welcomePage']//p"));
		String innertext =Afterlogintext.getText();
		String verifytext="You have successfully logged in.";
		
		if(innertext.equals(verifytext))
		{
			System.out.println("Test Case is passed!!");
		}

		driver.quit();
	}


}
