package amazon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import amazon.Pages.LoginPage;
import assets.Cleaner;
import assets.ExcelRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBase {
	
	protected static WebDriver driver;
	
	protected static Logger logger;
		
	public static SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public static void SetupAmazon() 
	{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
//Task:	Headless
//Task: Screenshots, video		
		String appUrl = "https://www.amazon.com";
		driver.get(appUrl);

		driver.manage().window().maximize();
		logger = Logger.getLogger("Terminator is");
		LoginPage.Login(ExcelRead.getCell(0,0), ExcelRead.getCell(0,1), ExcelRead.getCell(0,2));
		Reporter.log("      Cleaning...", true);
//Task: log4j or logger not both		
		Cleaner.cleaner();
		Reporter.log("      Cleaned!", true);
		driver.get(appUrl);
	}
	
	
	@AfterClass
	public static void CloseBrowser()
	{
		Reporter.log("      Closing...", true);
		driver.close();
	}
}	
