package amazon.Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import amazon.AmazonBase;

public class ItemPage extends AmazonBase{
	
	
	public static WebElement addToCartButton() {
		
		logger.debug("adding to cart");
		
		WebElement addToCart = driver.findElement(By.cssSelector("[value=\"Add to Cart\"]"));
		return addToCart;
	}

	
	public static WebElement addOldToCartButton() {
		
		WebElement addOldToCart = driver.findElement(By.cssSelector("[value=\"Add to cart\"]"));
		return addOldToCart;
	}
	
	public static WebElement addMp3ToCartButton() {
	
		WebElement addMp3ToCart = driver.findElement(By.cssSelector("[data-clickedbuttontype=\"addToCart\"]"));
		return addMp3ToCart;
	}

	public static WebElement quantityField() {
		
		WebElement quantityField = driver.findElement(By.id("quantity"));
		return quantityField;
	}
	
	public static void SelectQuantity(int quantity) {
		
		logger.debug("selecting quantity");
		
		Select sq = new Select(quantityField());
		sq.selectByIndex(quantity - 1);
	}
	
	
	public static void SelectMaxQuantity() {
		
		logger.debug("selecting maximum quantity");
		
		Select sq = new Select(quantityField());
		int quantity = sq.getOptions().size();
		sq.selectByIndex(quantity - 1);
	}


	public static WebElement selectItemType(String typeName) {
		
		logger.debug("selecting item type");
		WebElement itemType = driver.findElements(By.cssSelector(".a-button-text > span"))
				.stream().filter(e -> e.getText().equals(typeName)).findFirst().get();
		return itemType;
	}	
	
	
	public static WebElement selectByConditionType(String typeName, String conditionTypeName) {
		
		List<WebElement> parentClass = driver.findElements(By.className("a-list-item"));
		
	    Iterator<WebElement> iterator = parentClass.iterator();
	    while (iterator.hasNext()) {
	    	WebElement pC = iterator.next();
	        if (pC.findElements(By.cssSelector(".a-button-text > span"))
					.stream().filter(e -> e.getText().equals(typeName)).toArray().length > 0) {
	        	WebElement conditionType = pC.findElements(By.cssSelector(".tmm-olp-links > span > a"))
	        			.stream().filter(e -> e.getText().contains(conditionTypeName)).findFirst().get();
		return conditionType;
	        }
	    }
	    return null;
	}
}
