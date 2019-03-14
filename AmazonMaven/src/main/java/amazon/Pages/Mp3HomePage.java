package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import amazon.AmazonBase;

public class Mp3HomePage extends AmazonBase{

	public static WebElement mp3CartButton() {
		
	WebElement mp3CartButton = driver.findElements(By.className("nav-a-content")).stream()
			.filter(e -> e.getText().equals("MP3 cart")).findFirst().get();
	return mp3CartButton;
	}
}
