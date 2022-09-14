package seleniumAutomation;

import java.io.File;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CaptureScreenshotDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		//TakeScreenshot
		takeScreenshot(driver);
		
		/*Take fullpage screenshot in Selenium 3 and above for browsers 
		other than firefox*/
		takeFullPageScreenshot(driver);
		
		//Take fullpage screenshot in Selenium 4
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("https://demoqa.com/");
		takeFullPageScreenshotFirefox(firefoxDriver);
		firefoxDriver.quit();
		
		//Take particular element (eg : page Logo) screenshot
		takeElementScreenshot(driver);
		
		
		//Take section screenshot
		takeSectionScreenshot(driver);
		
		//close browser
		driver.quit();

	}
	
	//takes screenshot of visible section
	public static void takeScreenshot(WebDriver driver) {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(screenshot,new File("D:\\SeleniumLearning\\seleniumAutomation"
				+ "\\Screenshot\\homepage.png"));
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//takes screenshot of fullpage using AShot Utility
	public static void takeFullPageScreenshot(WebDriver driver){
		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.
				viewportPasting(1000)).takeScreenshot(driver);
		try {
		ImageIO.write(s.getImage(), "PNG", new File("D:\\SeleniumLearning\\seleniumAutomation"
				+ "\\Screenshot\\fullpage.png"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	//takes screenshot using getFullPageScreenshotAs() method
	public static void takeFullPageScreenshotFirefox(WebDriver firefoxDriver) {
	File firefoxScreenshot = ((FirefoxDriver) firefoxDriver).getFullPageScreenshotAs(OutputType.FILE);
	try{
		FileHandler.copy(firefoxScreenshot, new File("D:\\SeleniumLearning\\seleniumAutomation"
				+ "\\Screenshot\\fullpageFirefox.png"));
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	//takes screenshot of particular element
	public static void takeElementScreenshot(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//header//a//img"));
		File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(elementScreenshot,new File("D:\\SeleniumLearning\\"
				+ "seleniumAutomation\\Screenshot\\pagelogo.png"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Takes section screenshot
	public static void takeSectionScreenshot(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
				("img[class='banner-image")));
		WebElement banner = driver.findElement(By.cssSelector
				("img[class='banner-image"));
		try {
		File sectionScreenshot = banner.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sectionScreenshot,new File("D:\\SeleniumLearning\\"
				+ "seleniumAutomation\\Screenshot\\sectionlogo.png") );
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
