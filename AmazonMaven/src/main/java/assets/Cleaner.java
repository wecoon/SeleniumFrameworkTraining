package assets;

import amazon.AmazonBase;
import amazon.Pages.AccountPage;
import amazon.Pages.AddressesPage;
import amazon.Pages.CartPage;
import amazon.Pages.GlobalPage;
import amazon.Pages.Mp3CartPage;
import amazon.Pages.Mp3HomePage;


public class Cleaner extends AmazonBase {

	public static void cleaner() {
		logger.debug("clicking account and lists button");
		GlobalPage.accountAndListsButton().click();;
		logger.debug("openning list of added addresses");
		AccountPage.addressesButton().click();
		AddressesPage.DeleteAllAddresses();
		GlobalPage.OpenDepartment("Digital Music");
		Mp3HomePage.mp3CartButton().click();
		Mp3CartPage.RemoveAllMp3();
		GlobalPage.cartButton().click();
		CartPage.DeleteAllCartItems();
	}
}
