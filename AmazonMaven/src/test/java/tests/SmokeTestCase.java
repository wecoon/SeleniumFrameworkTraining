package tests;

import org.testng.annotations.Test;
import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.PaymentPage;
import amazon.Pages.SearchResultsPage;
import amazon.Pages.ShippingAddressPage;

public class SmokeTestCase extends AmazonBase {
	
	
	@Test(description="find and add item")
	public void FindAndOpenItemSmoke() 
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
		hardAssert.assertTrue(ItemPage.addMp3ToCartButton().isDisplayed());
	}

	
	@Test(dependsOnMethods = {"FindAndOpenItemSmoke"},
			description="add item to cart")
	public void AddtoCartSmoke()
	{
		ItemPage.selectItemType("Audio CD").click();
		ItemPage.addToCartButton().click();
		hardAssert.assertEquals(AddedPage.addedToCartMessage().getText(), "Added to Cart");
	}
	
	
	@Test(dependsOnMethods = {"AddtoCartSmoke"}, 
			description="fill and submit address form")
	public void SubmitAddressSmoke()
	{
		logger.debug("proceeding to added item checkout");
		AddedPage.proceedCheckoutButton().click();
		
		ShippingAddressPage.address1Field().sendKeys("24 School Ln, Egham");
		ShippingAddressPage.address2Field().sendKeys("22");
		ShippingAddressPage.cityField().sendKeys("SHOTTISHAM");
		ShippingAddressPage.postalCodeField().sendKeys("TW20 9LQ");
		ShippingAddressPage.SelectCountry("United Kingdom");
		ShippingAddressPage.phoneField().sendKeys("+12025550131");
		ShippingAddressPage.addressInstructionsField().sendKeys("This order "
				+ "is being done by automated test built by "
				+ "Selenium for Java, therefore, do not "
				+ "deliver and refund lease, thanks");
		GlobalPage.submitButton().click();
		
		hardAssert.assertTrue(ShippingAddressPage.shipSpeedDiv().isDisplayed());
		
		GlobalPage.submitButton().click();
	}
	
	
	@Test(dependsOnMethods = {"SubmitAddressSmoke"},
			description="fill CC form")
	public void FillCCSmoke()
	{
		String expectedCCname = "Dulce Campbell";
		String expectedCCNumber = "4865398914894674";
		String expectedCCM = "11";
		String expectedCCY = "2023";
		
		PaymentPage.ccNameField().sendKeys(expectedCCname);
		PaymentPage.ccNumberField().sendKeys(expectedCCNumber);
		
		PaymentPage.ccValidMListButton("01").click();
		PaymentPage.ccValidMListItem(expectedCCM).click();
		
		PaymentPage.ccValidYListButton("2019").click();
		PaymentPage.ccValidYListItem(expectedCCY).click();

		softAssert.assertEquals(PaymentPage.ccNameField().getAttribute("value"), expectedCCname);
		softAssert.assertEquals(PaymentPage.ccNumberField().getAttribute("value"), expectedCCNumber);
		softAssert.assertTrue(PaymentPage.ccValidMListButton(expectedCCM).isDisplayed());
		softAssert.assertTrue(PaymentPage.ccValidYListButton(expectedCCY).isDisplayed());
		softAssert.assertAll();
 	}
	
}
