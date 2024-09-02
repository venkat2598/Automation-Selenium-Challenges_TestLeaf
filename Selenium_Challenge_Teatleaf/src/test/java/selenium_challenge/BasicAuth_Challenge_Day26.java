package selenium_challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicAuth_Challenge_Day26 {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String BasicAuthUrl="https://admin:admin@the-internet.herokuapp.com/basic_auth";
		driver.get(BasicAuthUrl);
		String pagetitle=driver.getTitle();
		System.out.println(pagetitle);
		driver.quit();
	}

}
