package assets;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import amazon.AmazonBase;

public class Methods extends AmazonBase{

	
	public static void Hover(WebElement hoverItem) {
		
		logger.debug("hovering...");
		Actions hover = new Actions(driver);
		hover.moveToElement(hoverItem);
		hover.perform();
		}
}
