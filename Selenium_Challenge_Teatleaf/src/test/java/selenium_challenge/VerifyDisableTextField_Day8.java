package selenium_challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyDisableTextField_Day8 {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		String URL= "https://codepen.io/unknownUser7/pen/gOJEeRM";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement ClcikChangeviewiCon=driver.findElement(By.id("view-switcher-button"));
		ClcikChangeviewiCon.click();

		WebElement selectFirsticon=driver.findElement(By.id("left-layout"));
		selectFirsticon.click();
		ClcikChangeviewiCon.click();
		
		driver.switchTo().frame(0);
		WebElement ConfirmEmail=driver.findElement(By.id("confirmEmail"));
		System.out.println(ConfirmEmail.isEnabled());
		String ConfirmEmailText=	ConfirmEmail.getAttribute("value");
		System.out.println("Confirm Email Text is: "+ ConfirmEmailText);
		
		WebElement ConfirmPwd=driver.findElement(By.id("confirmPassword"));
		System.out.println(ConfirmPwd.isEnabled());
		String ConfirmPwdText=	ConfirmPwd.getAttribute("value");
		System.out.println("Confirm Password Text is: "+ ConfirmPwdText);
		
		
		
		
		
		driver.quit();
	}
}
