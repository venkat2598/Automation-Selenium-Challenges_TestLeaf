package selenium_challenge;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeCapabilities_Day2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();  // download and setup the browser
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");		
		//	resize the browser window
		opt.addArguments("window-size=1200,800");

		//Remove Info of Chrome is being controlled by automated software.
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

		WebDriver driver=new ChromeDriver(opt);  //Initialize the desired browser

		String baseurl="https://www.spicejet.com/"; 
		driver.get(baseurl); //load and hit the url

		// get the text name "flights"
		String textname= driver.findElement(By.linkText("Flights")).getText();	// get the text name "flights"
		System.out.println(textname);

		//Print the title of the page
		System.out.println(driver.getTitle());

		//close the browser
		driver.close();

	}

}
