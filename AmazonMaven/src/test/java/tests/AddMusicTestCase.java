package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.SearchResultsPage;
import assets.Methods;

public class AddMusicTestCase extends AmazonBase {
	
	@DataProvider
	protected Object[][] musicProvider() {
		return new Object[][] {
			{"Audio CD"},
			{"Vinyl"},
			{"Audio, Cassette"}
		};
	}
	
	
	@BeforeClass
	public static void FindItem()
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
	}
	

	@Test()
	public static void AddMp3ToCart() 
	{		
		ItemPage.selectItemType("MP3").click();
		ItemPage.addMp3ToCartButton().click();
		
		Methods.WaitInvisibility(ItemPage.addMp3ToCartButton());
		hardAssert.assertFalse(ItemPage.addMp3ToCartButton().isDisplayed());	
	}
		
		
	@Test(dataProvider = "musicProvider")
	public static void AddToCart(String musicItemType) 
	{		
		ItemPage.selectItemType(musicItemType).click();
		ItemPage.addToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(dataProvider = "musicProvider") 
	public static void AddUsedToCart(String musicItemType)
	{
		ItemPage.selectByConditionType(musicItemType, "Used").click();
		ItemPage.addOldToCartButton().click();
		/*Amazon has few different ways to describe Add To Cart button element, and
		  for used items they use lower case "cart" ("Add to Cart" vs. "Add to cart").
		  Therefore, separate WebElement for old item add to cart functionality is 
		  being used. However, this might be a bug or strange design decision*/
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
}

