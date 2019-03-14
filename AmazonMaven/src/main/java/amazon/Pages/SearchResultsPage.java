package amazon.Pages;

import org.openqa.selenium.By;

import amazon.AmazonBase;

public class SearchResultsPage extends AmazonBase{

	public static void OpenItemByImgUrl(String itemImgURL) {
		
		logger.debug("opening the the item page");
		driver.findElement(By.cssSelector("img[src=\"" + itemImgURL + "\"]")).click();
	}
}

