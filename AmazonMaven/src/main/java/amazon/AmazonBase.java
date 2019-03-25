package amazon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import amazon.Pages.LoginPage;
import assets.Cleaner;
import assets.CustomHardAssert;
import assets.CustomSoftAssert;
import assets.ExcelRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBase {
	
	protected static WebDriver driver;
	
	protected static Logger logger;
		
	public static CustomSoftAssert softAssert = new CustomSoftAssert();
	public static CustomHardAssert hardAssert = new CustomHardAssert();
	
	static String appUrl = "https://www.amazon.com";
	
	@BeforeClass
	public static void SetupAmazon() 
	{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//Task:	Headless
//Task: Video before the bug		
		
		driver.get(appUrl);
		driver.manage().window().maximize();
		logger = Logger.getLogger("Terminator is");
		LoginPage.Login(ExcelRead.getCell(0,0), ExcelRead.getCell(0,1), ExcelRead.getCell(0,2));
	}
	
	
	@AfterClass
	public static void CloseBrowser()
	{
		Reporter.log("      Cleaning...", true);
//Task: log4j or logger not both		
		driver.get(appUrl);
		Cleaner.cleaner();
		Reporter.log("      Cleaned!", true);
		Reporter.log("      Closing...", true);
		driver.close();
	}
}	
