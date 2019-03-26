package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.AmazonBase;

public class PaymentPage extends AmazonBase {

	public static WebElement ccNameField() {
		
		WebElement ccNameField = (new WebDriverWait(driver, 3))
				   .until(ExpectedConditions.elementToBeClickable(By.id("ccName")));
		return ccNameField;
	}
	
		
	public static WebElement ccNumberField() {
		
		WebElement ccNumberField = (new WebDriverWait(driver, 3))
				   .until(ExpectedConditions.elementToBeClickable(By.id("addCreditCardNumber")));
		return ccNumberField;
	}
	
	public static WebElement ccValidMListButton(String Default01) {
		

		WebElement ccValidMListButton = driver.findElements(By.className("a-dropdown-prompt"))
				.stream().filter(e -> e.getText().equals(Default01)).findFirst().orElse(null);
		return ccValidMListButton;

	}
	
	
	public static WebElement ccValidYListButton(String Default2019) {

		WebElement ccValidYListButton = driver.findElements(By.className("a-dropdown-prompt"))
				.stream().filter(e -> e.getText().equals(Default2019)).findFirst().orElse(null);
		return ccValidYListButton; 
	}
	
	
	public static WebElement ccValidMListItem(String MM) {
		
		int M = Integer.parseInt(MM);	
		WebElement ccValidMListItem = driver.findElement(By.cssSelector("[data-value=\"" + M + "\"]"));
		return ccValidMListItem; 
	}
	
	
	public static WebElement ccValidYListItem(String YYYY) {

		WebElement ccValidYListItem = driver.findElement(By.cssSelector("[data-value=\"" + YYYY + "\"]"));
		return ccValidYListItem; 
	}
}
