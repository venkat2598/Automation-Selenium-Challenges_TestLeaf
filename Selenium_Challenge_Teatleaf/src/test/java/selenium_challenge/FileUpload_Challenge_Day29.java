package selenium_challenge;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FileUpload_Challenge_Day29 {
	static WebDriver driver;
	public static void UploadpdfUsingRobotClass() {

		String Path="C:\\Users\\user\\Downloads\\menu.pdf";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		StringSelection selection= new StringSelection(Path);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		Robot  robot=null;
		try
		{ 
			robot=new Robot(); } 
		catch (AWTException e) { 
			e.printStackTrace(); }

		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V); 
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		driver= new FirefoxDriver(op);
		String url = "https://www.ilovepdf.com/";
		driver.get(url);	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//h3[text()='PDF to Word']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("pickfiles")).click();
		UploadpdfUsingRobotClass();




	}


}
