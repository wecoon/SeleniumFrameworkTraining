package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.SearchResultsPage;
import assets.Methods;

public class AddMusicTestCase extends AmazonBase {
	
	@BeforeClass
	public static void FindItem()
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
	}
	

	@Test(description="Add Mp3 to Cart")
	public static void AddMp3ToCart() 
	{		
		ItemPage.selectItemType("MP3").click();
		ItemPage.addMp3ToCartButton().click();
		
		Methods.WaitInvisibility(ItemPage.addMp3ToCartButton());
		hardAssert.assertFalse(ItemPage.addMp3ToCartButton().isDisplayed());	
	}
		
	
	@Test(description="Add CD to Cart")
	public static void AddCDToCart() 
	{		
		ItemPage.selectItemType("Audio CD").click();
		ItemPage.addToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(description="Add Vinyl to Cart")
	public static void AddVinylToCart() 
	{
		ItemPage.selectItemType("Vinyl").click();
		ItemPage.addToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}

	
	@Test(description="Add Cassette to Cart")
	public static void AddCassetteToCart() 
	{		
		ItemPage.selectItemType("Audio, Cassette").click();
		ItemPage.addToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(description="Add Used CD to Cart") 
	public static void AddUsedCDToCart()
	{
		ItemPage.selectByConditionType("Audio CD", "Used").click();
		ItemPage.addOldToCartButton().click();
		/*Amazon has few different ways to describe Add To Cart button element, and
		  for used items they use lower case "cart" ("Add to Cart" vs. "Add to cart").
		  Therefore, separate WebElement for old item add to cart functionality is 
		  being used. However, this might be a bug or strange design decision*/
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(description="Add Used Vinyl to Cart") 
	public static void AddUsedVinylToCart()
	{
		ItemPage.selectByConditionType("Vinyl", "Used").click();
		ItemPage.addOldToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
	
	
	@Test(description="Add Used Cassette to Cart") 
	public static void AddUsedCassetteToCart()
	{
		ItemPage.selectByConditionType("Audio, Cassette", "Used").click();
		ItemPage.addOldToCartButton().click();
		
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
		
		AddedPage.GetBackToTheItem();
	}
}

