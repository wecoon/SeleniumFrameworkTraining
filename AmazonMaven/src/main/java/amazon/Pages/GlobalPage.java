package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import amazon.AmazonBase;
import assets.Methods;

public class GlobalPage extends AmazonBase {
	
	
	public static WebElement accountAndListsButton() {
		
		WebElement accountAndListsButton = driver.findElement(By.id("nav-link-accountList"));
		return accountAndListsButton;
	}
	
	
	public static WebElement cartButton() {
		
		WebElement cartButton = driver.findElement(By.id("nav-cart-count"));
		return cartButton;
	}

	
	public static int cartCount() {
		
		WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
		
		int cartCountint = Integer.parseInt(cartCount.getText());
		return cartCountint;
	}
	
	public static WebElement submitButton() {

		WebElement submitButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
		return submitButton;
	}
	
	
	public static void Search(String itemName) {
		
		logger.debug("searching for the item");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(itemName);
		searchBox.sendKeys(Keys.RETURN);
	}
	
	
	public static void OpenDepartment(String depName) {
	
		WebElement hoverItem = driver.findElement(By.id("nav-link-shopall"));
		Methods.Hover(hoverItem);
		
		logger.debug("opening department");
		WebElement departments = driver.findElements(By.className("nav-text")).stream().filter(e -> e.getText().equals(depName)).findFirst().get();
		departments.click();
	}

	
}
