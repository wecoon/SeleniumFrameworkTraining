package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.SearchResultsPage;
import assets.CommonDataProviders;

public class AddMusicAllTestCase extends AmazonBase{

	@BeforeClass
	public static void FindItem()
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
	}
	
	
	@Test(dataProvider = "allMusicProvider", dataProviderClass = CommonDataProviders.class) 
	public static void AddMaxQuantity(String musicItemType) {
		
		ItemPage.selectItemType(musicItemType).click();	
		ItemPage.SelectMaxQuantity();
		ItemPage.addToCartButton().click();
				
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");

		AddedPage.GetBackToTheItem();
	}
}
