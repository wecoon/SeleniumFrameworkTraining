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
		ItemPage.AddToCart();
		
//TASK:	Assert
		
	}
		
	@Test(priority = 1, description="Add all types of music items and removed them from the carts")
	public static void AddCDToCart() 
	{		
		ItemPage.SelectItemType("Audio CD");
		ItemPage.AddToCart();
		
		softAssert.assertEquals(AddedPage.AddedToCartMessage(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	@Test(priority = 1, description="Add all types of music items and removed them from the carts")
	public static void AddVinylToCart() 
	{
		ItemPage.SelectItemType("Vinyl");
		ItemPage.AddToCart();
		
		softAssert.assertEquals(AddedPage.AddedToCartMessage(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}

	@Test(priority = 1, description="Add all types of music items and removed them from the carts")
	public static void AddCassetteToCart() 
	{		
		ItemPage.SelectItemType("Audio, Cassette");
		ItemPage.AddToCart();
		
		softAssert.assertEquals(AddedPage.AddedToCartMessage(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	@Test(priority = 2, description="Test added and removed 5 Audio CDs")
	public static void Add5VinylssToCart() {
		
		ItemPage.SelectItemType("Vinyl");	
		ItemPage.SelectQuantity("5");
		ItemPage.AddToCart();
		
		softAssert.assertEquals(AddedPage.AddedToCartMessage(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
		
		softAssert.assertAll();
	}
}
