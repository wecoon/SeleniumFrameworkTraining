package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import amazon.AmazonBase;

public class ShippingAddressPage extends AmazonBase{


	public static WebElement address1Field() {
		
		WebElement address1Field = driver.findElement(By.id("enterAddressAddressLine1"));
		return address1Field;
	}

	public static WebElement address2Field() {
		
		WebElement address2Field = driver.findElement(By.id("enterAddressAddressLine2"));
		return address2Field;
	}
	
	
	public static WebElement cityField() {
		
		WebElement cityField = driver.findElement(By.id("enterAddressCity"));
		return cityField;
	}

	
	public static WebElement postalCodeField() {
		
		WebElement postalCodeField = driver.findElement(By.id("enterAddressPostalCode"));
		return postalCodeField;
	}

	
	public static WebElement phoneField() {
		
		WebElement phoneField = driver.findElement(By.id("enterAddressPhoneNumber"));
		return phoneField;
	}

	
	public static WebElement addressInstructionsField() {
		
		WebElement addressInstructionsField = driver.findElement(By.id("AddressInstructions"));
		return addressInstructionsField;
	}
	
	
	public static WebElement importantMessageError() {
				
		WebElement importantMessageError = driver.findElements(By.tagName("h4")).
				stream().filter(e -> e.getText().equals("Important Message")).findFirst().get();
		return importantMessageError;
	}
	
	public static void SelectCountry(String countryName) {
		
		logger.debug("selecting country");
		Select countryList = new Select(driver.findElement(By.id("enterAddressCountryCode")));
		countryList.selectByVisibleText(countryName);
	}
	
	public static WebElement shipSpeedDiv() {
		
		WebElement shipSpeedDiv = driver.findElement(By.className("ship-speed"));
		return shipSpeedDiv;
	}
}
