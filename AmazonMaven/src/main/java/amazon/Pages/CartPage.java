package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.AmazonBase;

public class CartPage extends AmazonBase{

	
	public static WebElement deleteButton() {
		
		WebElement deleteButton = (new WebDriverWait(driver, 3))
				   .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Delete\"]")));
		return deleteButton;
	}
	
	
	public static void DeleteAllCartItems() {
		
		logger.debug("deleting all items from cart");

		Long deleteSize = driver.findElements(By.cssSelector("input[value=\"Delete\"]")).stream().count();
		
		while(deleteSize > 0) {
			deleteButton().click();
			--deleteSize;
		}
	}
}
