package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.AddedPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.ItemPage;
import amazon.Pages.PaymentPage;
import amazon.Pages.SearchResultsPage;
import amazon.Pages.ShippingAddressPage;

public class SmokeTestCase extends AmazonBase {
	@BeforeClass
	public void FindAndOpenItem() 
	{
		GlobalPage.Search("The Dark Side of the Moon");
		SearchResultsPage.OpenItemByImgUrl("https://m.media-amazon.com/images/I/61PEh3IyaeL._AC_UL436_.jpg");
	}

	
	@Test(description="Test adds an item to the cart, SMOKE")
	public void AddtoCartSmoke()
	{
		ItemPage.SelectItemType("Audio CD");
		ItemPage.AddToCart();
		
		softAssert.assertEquals(AddedPage.AddedToCartMessage(), "Added to Cart");
//BUG:	Not soft assert? If an item add to cart fails, it wont go to next step
	}
	
	@Test(dependsOnMethods = {"AddtoCartSmoke"}, 
			description="Test fills address form and submits it, SMOKE")
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
		assertTrue(ShippingAddressPage.ImportantMessageErrorIsNotShown());

		GlobalPage.submitButton().click();
		
//BUG:	Makes with the same logic as soft assert in test above
	}
	
	@Test(dependsOnMethods = {"AddtoCartSmoke", "SubmitAddressSmoke"},
			description="Test proceeds to the payment and fills CC information, SMOKE")
	public void FillCCSmoke()
	{
		String expectedCCname = "Dulce Campbell";
		String expectedCCNumber = "4865398914894674";
		String expectedCCM = "08";
		String expectedCCY = "2023";
//Task: Move to DataProvider
		
		PaymentPage.ccNameField().sendKeys(expectedCCname);
		PaymentPage.ccNumberField().sendKeys(expectedCCNumber);
		
		PaymentPage.ccValidMListButton("01").click();
		PaymentPage.ccValidMListItem(expectedCCM).click();
		
		PaymentPage.ccValidYListButton("2019").click();
		PaymentPage.ccValidYListItem(expectedCCY).click();
		
		softAssert.assertEquals(PaymentPage.ccNameField().getAttribute("value"), expectedCCname);
		softAssert.assertEquals(PaymentPage.ccNumberField().getAttribute("value"), expectedCCNumber);
		softAssert.assertEquals(PaymentPage.ccValidMListButton(expectedCCM).isDisplayed(), true);
		softAssert.assertEquals(PaymentPage.ccValidYListButton(expectedCCY).isDisplayed(), true);
		softAssert.assertAll();
 	}
	
}
