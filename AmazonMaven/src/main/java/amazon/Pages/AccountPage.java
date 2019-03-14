package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import amazon.AmazonBase;

public class AccountPage extends AmazonBase {
	
	public static WebElement addressesButton() {
		
		WebElement addressesButton = driver.findElement(By.cssSelector("[data-card-identifier=\"Addresses\"]"));
		return addressesButton;
	}
}
