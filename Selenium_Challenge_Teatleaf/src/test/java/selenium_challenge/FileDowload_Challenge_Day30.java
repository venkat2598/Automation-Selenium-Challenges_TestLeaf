package selenium_challenge;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDowload_Challenge_Day30 {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "files");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		op.setProfile(profile);
		FirefoxDriver driver= new FirefoxDriver(op);
		String url = "https://pontoon.mozilla.org/";
		driver.get(url);	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


		driver.findElement(By.xpath("(//a[text()='Start Localizing Now'])[1]")).click();
		driver.findElement(By.xpath("//ul[@class='links']/li[1]")).click();
		driver.findElement(By.className("table-filter")).sendKeys("india");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()='Bengali (India)']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-cloud-download-alt']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//div[@class='menu']/ul/li[1])[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		try {
		// Rename the downloaded file
        File oldFile = new File(System.getProperty("user.dir") + File.separator + "files" + File.separator + "bn-IN.tbx");
        File newFile = new File(System.getProperty("user.dir") + File.separator + "files" + File.separator + "terminology.tbx");
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
            System.out.println("File Name successfully changed !......");
        }else {
        	 System.out.println("File Name successfully not changed !......");
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        
        driver.quit();
    }









	}

}
