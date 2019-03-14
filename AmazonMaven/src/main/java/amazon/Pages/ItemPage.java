package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import amazon.AmazonBase;

public class ItemPage extends AmazonBase{
	
	public static void SelectQuantity(String quantity) {
		
		logger.debug("selecting quantity");
		Select sq = new Select(driver.findElement(By.cssSelector("[id=\"quantity\"]")));
		sq.selectByVisibleText(quantity);
	}
	

	public static void AddToCart() {
		
		logger.debug("adding to cart");

		if (driver.findElements(By.id("add-to-cart-button")).size() > 0) {
			WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
			addToCart.click();
		}
		else if(driver.findElements(By.id("add-to-cart-button-ubb")).size() > 0) {
			WebElement addToCart = driver.findElement(By.id("add-to-cart-button-ubb"));
			addToCart.click();
		}
		else {
			WebElement addToCart = driver.findElement(By.cssSelector("[data-clickedbuttontype=\"addToCart\"]"));
			addToCart.click();
		}
	}
//TASK:	Maybe do separate button and use what is actually needed e.g. addToCartButton, addUsedToCartButton, addMp3ToCartButton	
	
	
	public static void SelectItemType(String typeName) {
		
		logger.debug("selecting item type");
		WebElement itemType = driver.findElements(By.cssSelector(".a-button-text > span"))
				.stream().filter(e -> e.getText().equals(typeName)).findFirst().get();
		itemType.click();
	}	
}
