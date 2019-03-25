package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import amazon.AmazonBase;

public class AddressesPage extends AmazonBase{

	public static WebElement deleteButton() {
		
		WebElement deleteButton = driver.findElement(By.id("ya-myab-address-delete-btn-0"));
		return deleteButton;
	}
	
	
	public static WebElement confirmDeleteButton() {
		
		WebElement confirmDeleteButton = driver.findElement(By.id("deleteAddressModal-0-submit-btn"));
		return confirmDeleteButton;
	}
	
	
	public static void DeleteAllAddresses() {

		long size = driver.findElements(By.className("a-link-normal")).stream()
				.filter(e -> e.getText().equals("Set as Default")).count();

		while(size > 0) {
	
			logger.debug("choosing address to delete");
			deleteButton().click();

			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");	
			
			logger.debug("confirming deletion");
			confirmDeleteButton().click();
			--size;
		}
	}
}
