package selenium_challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentWaysBrowserLanuch_Day1 {

	// Launching Browser using different ways:

	/* 1.Using System.setproperty() Method:

			Manually download the browsers driver.which browser you need to perform the task.Like drivers name are Chromedriver, geckodriver,Edgedriver and so......

			Steps to follow download the Drivers Manually:

				1.Search the drivers name in google like which driver do you want to download (ex:Chrome driver)
				2.Click the official site and download driver exe file based on your device browser versions.


				Selenium Code:

					Note: Add the drivers exe.file  in your projects.
					System.setProperty("driver name ", "Path of driver location");
				WebDriver driver = new FirefoxDriver(); // initialize the Browser drivers using webdriver.

	 */
	public void Usingsyssetproperty(){



		// Firefox Driver
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String url = "https://www.testleaf.com";
		driver.get(url);
		//Or

		// Chrome Driver
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);


	}




	/* 2.Using WebDriverManager 

		Automatically download Drivers without downloading the drivers manually. it will work the same process but automatically download and store their location.


		it will support any project like Java project or Maven Project.

		Your using Java project Consider this point:
		we need to download one jar file the name called WebdriverManager.jar file.

		 or

		Maven Project:
		Download the webdrivermanager dependencies and add into the pom.xml file. 
	 */

	public void UsingWebDriverManager(){

		WebDriverManager.chromedriver().setup(); // this steps will work download the driver and setup and maintain the thier location with the current browser version.
		WebDriver driver= new ChromeDriver();
		String url = "https://www.testleaf.com";
		driver.get(url);
		//		Or
		driver.navigate().to(url);


	}


	/* 3.Without using System.setproperty() Method:

		Directly paste the driver exe file location into our machine envirnment setting page once the steps done. then restart the machine after its work.
		We can able to launch the site or browser without using the system.setproperty method.

		Cons:
		incase your not using this machine in your project the point is not work. you can choose 1 or 2 ways.

	 */

	public void WithoutusingSystemsetproperty(){

		// Here already set the driver path into our local machine so don't worry about it. It will work as expected

		WebDriver driver= new ChromeDriver();
		String url = "https://www.testleaf.com";
		driver.get(url);




	}



	/*Conclusion:


		Which ways is better to launch the broswers 

		First Priority:

		1.I recommand webdrivermanager. because its automatically download and setup the browser in our project. so that we can use easily.

		Second Priority:

		2.System.setproperty();
	 */
	public static void main(String[] args) {
		DifferentWaysBrowserLanuch_Day1 launch = new DifferentWaysBrowserLanuch_Day1();
		launch.Usingsyssetproperty();
		launch.UsingWebDriverManager();
		launch.WithoutusingSystemsetproperty();
	}


}
