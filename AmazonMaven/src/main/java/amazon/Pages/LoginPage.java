package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import amazon.AmazonBase;

public class LoginPage extends AmazonBase {
	
	public static WebElement emailField() {
		
		WebElement emailField = driver.findElement(By.id("ap_email"));
		return emailField;
	}
	
	
	public static WebElement passwordField() {
		
		WebElement passwordField = driver.findElement(By.id("ap_password"));
		return passwordField;
	}
	
	
	public static WebElement signInButton() {
		
		WebElement signInButton = driver.findElement(By.id("signInSubmit"));
		return signInButton;
	}
	
	
	public static void Login(String email, String pass, String name) {
		
		logger.debug("logging in");
		GlobalPage.accountAndListsButton().click();
		emailField().sendKeys(email);
		passwordField().sendKeys(pass);
		signInButton().click();
		
		logger.debug("checking name");
		String getName = driver.findElement(By.cssSelector("#nav-link-accountList > span:nth-child(1)")).getText();
		String expectedName = "Hello, " + name;
//Task: Adapt Pages to allow tests use different accounts
 		if (expectedName.equals(getName))
		{
			System.out.println(getName + ", Authentication Successful.");
		}
		else
		{
			System.out.println("Authentication Failed - Wrong Account Name: " + getName);
		}
		
		try {
			  driver.findElement(By.id("nav-link-accountList"));
			}
		catch (Exception NoSuchElementException) 
			{
			  Assert.fail("Account List element was not found");
			}
		Assert.assertTrue(driver.findElement(By.id("nav-link-accountList")).isDisplayed());	
	}

}	

	