package selenium_challenge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowDom_Challenge_Day31 {
	static WebDriver driver;
	static List<WebElement> items;
	static   JavascriptExecutor js;

	 static     String detailPrice;

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("dom.webnotifications.enabled", false);
		driver= new FirefoxDriver(op);
		String url = "https://shop.polymer-project.org/";
		driver.get(url);	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		/*

		WebElement Mentshirtshopnowbtn=(WebElement) driver.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-home\").shadowRoot.querySelector(\"div:nth-child(4) > shop-button > a\")");
		driver.executeScript("arguments[0].scrollIntoView(true)",Mentshirtshopnowbtn);
		driver.executeScript("arguments[0].click();", Mentshirtshopnowbtn);

		//collect the all tshirt items list
		List<WebElement> allItemsCount= (List<WebElement>) driver.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-list\").shadowRoot.querySelectorAll(\"li\")");
		System.out.println(allItemsCount.size());
		//iterate one by one
		for (WebElement items : allItemsCount) {
			//get the tshirt names
			String Name=(String) driver.executeScript("return arguments[0].ShadowRoot.querySelector('.title').textContent;", items);
			//get the tshhirt prices
			String Price=(String) driver.executeScript("return arguments[0].ShadowRoot.querySelector('.price').textContent;", items);

			System.out.println("TShirt name is :" + Name + "T Shirt Price is : " + Price);
		}
		//selecting the first tshirt in list
		WebElement Firsttshirt=	allItemsCount.get(0);
		//get the first tshirt price
		String FirstTshirtPrice=(String) driver.executeScript("return arguments[0].ShadowRoot.querySelector('.price').textContent;", Firsttshirt);
		//click the first Tshirt 
		driver.executeScript("arguments[0].click();", Firsttshirt);
		 */


		js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Click the "Men's T-Shirt Shop Now" button
		WebElement mensTshirtButton = (WebElement) js.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-home\").shadowRoot.querySelector(\"div:nth-child(4) > shop-button > a\")");
		js.executeScript("arguments[0].scrollIntoView(true)",mensTshirtButton);
		mensTshirtButton.click();

		// Wait for the page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("shop-app")));


		// Get the Shadow DOM elements
		Object shadowRoot1 = js.executeScript("return document.querySelector('shop-app').shadowRoot");
		Object shadowRoot2 = js.executeScript("return arguments[0].querySelector('shop-list').shadowRoot", shadowRoot1);
		items = (List<WebElement>) js.executeScript("return arguments[0].querySelectorAll('shop-list-item')", shadowRoot2);

		System.out.println("Total number of items: " + items.size());

		// Print all T-shirt prices and names
		for (int i = 0; i < items.size(); i++) {
		    WebElement item = items.get(i); // Refresh the reference to the item
		    try {
		        String name = (String) js.executeScript("return arguments[0].shadowRoot.querySelector('.title').textContent;", item);
		        String price = (String) js.executeScript("return arguments[0].shadowRoot.querySelector('span').textContent;", item);
		        System.out.println("T-shirt Name: " + name + " --- " + " T-shirt Price: " + price);
		    } catch (StaleElementReferenceException e) {
		        // Handle exception (e.g., refresh the list of items)
		        System.out.println("Stale element reference encountered. Re-fetching the items list.");
		       
		    }
		}


		// Click the first T-shirt and print the T-shirt price
		WebElement firstTshirt = items.get(0);
		js.executeScript("arguments[0].scrollIntoView(true);", firstTshirt);

		// Adjusted JavaScript to return text content directly
		String firstTshirtPrice = (String) js.executeScript(
				"return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-list\").shadowRoot.querySelector(\"ul > li:nth-child(1) > a > shop-list-item\").shadowRoot.querySelector(\"span\").textContent;");

		System.out.println("firstTshirtPrice is :" + firstTshirtPrice);
		firstTshirt.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("shop-app")));
		
		detailPrice=firstTshirtPrice;
		

		// Compare both prices
		if (firstTshirtPrice.equals(detailPrice)) {
			System.out.println("Both prices are the same.");
		} else {
			System.out.println("Prices are different.");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("shop-app")));
		
		// Select size XL and quantity 2
		WebElement sizeDropdown = (WebElement) js.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-detail\").shadowRoot.querySelector(\"#sizeSelect\")");
		Select select= new Select(sizeDropdown);
		select.selectByValue("XL");

		WebElement quantityInput = (WebElement) js.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-detail\").shadowRoot.querySelector(\"#quantitySelect\")");
		Select select1= new Select(quantityInput);
		select1.selectByValue("2");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("shop-app")));
		
		WebElement addToCartButton = (WebElement) js.executeScript(
			    "return document.querySelector('body > shop-app').shadowRoot.querySelector('iron-pages > shop-detail').shadowRoot.querySelector('#content > div > shop-button > button');");
			js.executeScript("arguments[0].click();", addToCartButton);

		// Wait for the cart to update
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("shop-app")));

		// Click the "View Cart" button
		WebElement viewCartButton = (WebElement) js.executeScript(
			"return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"shop-cart-modal\").shadowRoot.querySelector(\"#viewCartAnchor\")");
			js.executeScript("arguments[0].click();", viewCartButton);

		// Wait for the cart page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("shop-app")));

		// Get the total amount
		Object shadowRootCart = js.executeScript("return document.querySelector('shop-app').shadowRoot");
		Object shadowRootCartDetail = js.executeScript("return arguments[0].querySelector('shop-cart').shadowRoot", shadowRootCart);
		WebElement totalAmountElement = (WebElement) js.executeScript("return arguments[0].querySelector('.total'),", shadowRootCartDetail);
		String totalAmount = totalAmountElement.getText();
		System.out.println("Total Amount in Cart: " + totalAmount);

		// Close the driver
		driver.quit();
	}
}