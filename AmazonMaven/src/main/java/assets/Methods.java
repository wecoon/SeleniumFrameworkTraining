package assets;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import amazon.AmazonBase;

public class Methods extends AmazonBase{

	
	public static void Hover(WebElement hoverItem) {
		
		logger.debug("hovering...");
		Actions hover = new Actions(driver);
		hover.moveToElement(hoverItem);
		hover.perform();
		}


	public static void takeScreenshot() {
		
		String pattern = "yyyy-MM-dd HH mm ss SSS";
		SimpleDateFormat simpleDateFormat =
		        new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());

		try {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\github\\SeleniumFrameworkTraining\\"
				+ "AmazonMaven\\test-output\\screenshots\\" + date + ".png"));
		Reporter.log("      SMILE! Taking Screenshot!", true);
		}
		catch (Exception e) {
				e.printStackTrace();
			}
		}
}
