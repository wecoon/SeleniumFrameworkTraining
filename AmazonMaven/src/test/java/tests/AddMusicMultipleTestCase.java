package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.SearchResultsPage;

public class AddMusicMultipleTestCase extends AmazonBase{

	@DataProvider
	protected Object[][] musicProvider() {
		return new Object[][] {
			{"Audio CD"},
			{"Vinyl"},
		};
	}
	
	@BeforeClass
	public static void FindItem()
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
	}
	
	
	@Test(dataProvider = "musicProvider") 
	public static void Add5VinylsToCart(String musicItemType) {
		
		int a = GlobalPage.cartCount();
		int quantity = 5;
		ItemPage.selectItemType(musicItemType).click();	
		ItemPage.SelectQuantity(quantity);
		ItemPage.addToCartButton().click();
		
		hardAssert.assertEquals(GlobalPage.cartCount(), a + quantity);
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(dataProvider = "musicProvider") 
	public static void AddMaxQuantity(String musicItemType) {
		
		ItemPage.selectItemType(musicItemType).click();	
		ItemPage.SelectMaxQuantity();
		ItemPage.addToCartButton().click();
				
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		/*Amazon does not update quantity options based on added items,
		  so AddtoCart will succeed with SelectMaxQuantity if that item
		  have not been added yet*/
		AddedPage.GetBackToTheItem();
	}
}
