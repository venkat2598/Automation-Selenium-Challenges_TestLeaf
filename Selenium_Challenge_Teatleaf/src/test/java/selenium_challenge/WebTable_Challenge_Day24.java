package selenium_challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.List;

public class WebTable_Challenge_Day24 {

    public static void main(String[] args) {
        
    	
    	System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		FirefoxDriver driver= new FirefoxDriver(op);
		String url = "https://finance.yahoo.com/most-active";
		driver.get(url);
      
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        
        try {
            
            // Find all rows in the table
            List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));
            System.out.println(rows.size());
            double lowestPrice = Double.MAX_VALUE;
            WebElement lowestPriceRow = null;

            // Iterate through each row to find the company with the lowest price
            for (WebElement row : rows) {
                // Get the price from the second cell
                WebElement priceCell = row.findElement(By.xpath("td[3]"));
                double price = Double.parseDouble(priceCell.getText());
                
                // Check if this is the lowest price
                if (price < lowestPrice) {
                    lowestPrice = price;
                    lowestPriceRow = row;
                }
            }

            if (lowestPriceRow != null) {
                // Get the company name and market cap from the row with the lowest price
                String companyName = lowestPriceRow.findElement(By.xpath("td[1]")).getText();
                String price = lowestPriceRow.findElement(By.xpath("td[3]")).getText();
                String marketCap = lowestPriceRow.findElement(By.xpath("td[7]")).getText();

                // Print the company name, price, and market cap
                System.out.println("Company Name: " + companyName);
                System.out.println("Price: " + price);
                System.out.println("Market Cap: " + marketCap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            driver.close();
        }
    }
}

