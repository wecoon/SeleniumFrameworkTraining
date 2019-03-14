package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import amazon.AmazonBase;

public class Mp3CartPage extends AmazonBase{

	
	public static WebElement removeButton() {
		WebElement removeButton = driver.findElements(By.cssSelector("[data-callback=\"toggleButtonsOnPage\"]")).stream()
				.filter(e -> e.getText().equals("Remove")).findFirst().get();
		return removeButton;
	}

		
	public static void RemoveAllMp3() {
		
		logger.debug("removing all mp3 from the cart");

		Long size = driver.findElements(By.cssSelector("[data-callback=\"toggleButtonsOnPage\"]")).stream()
				.filter(e -> e.getText().equals("Remove")).count();
		
		while(size > 0) {
				
			removeButton().click();
			--size;
		}
	}

	
}
