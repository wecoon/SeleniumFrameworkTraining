package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.SearchResultsPage;

public class AddMusicTestCase extends AmazonBase {
	
	@BeforeClass
	public static void FindItem()
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
	}
	

	@Test(priority = 1, description="Add all types of music items and removed them from the carts")
	public static void AddMp3ToCart() 
	{		
		ItemPage.SelectItemType("MP3");
		ItemPage.AddToCartButton().click();
		softAssert.assertTrue(ItemPage.AddToCartButton().isDisplayed());		
	}
		
	
	@Test(priority = 1, description="Add all types of music items and removed them from the carts")
	public static void AddCDToCart() 
	{		
		ItemPage.SelectItemType("Audio CD");
		ItemPage.AddToCartButton().click();
		
		softAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(priority = 1, description="Add all types of music items and removed them from the carts")
	public static void AddVinylToCart() 
	{
		ItemPage.SelectItemType("Vinyl");
		ItemPage.AddToCartButton().click();
		
		softAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}

	
	@Test(priority = 1, description="Add all types of music items and removed them from the carts")
	public static void AddCassetteToCart() 
	{		
		ItemPage.SelectItemType("Audio, Cassette");
		ItemPage.AddToCartButton().click();
		
		softAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	@Test(priority = 2, description="Test added and removed 5 Audio CDs")
	public static void Add5VinylssToCart() {
		
		ItemPage.SelectItemType("Vinyl");	
		ItemPage.SelectQuantity("5");
		ItemPage.AddToCartButton().click();
		
		softAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		softAssert.assertAll();
	}
}
