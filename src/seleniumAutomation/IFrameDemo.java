package seleniumAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrameDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");
		
		//Get total number of frames on page 
		//1. using tagname
		List<WebElement> noOfIFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total no of iframes found using tagname are : "+
		noOfIFrames.size());
		
		//using JavaScriptExecutor
		JavascriptExecutor js =(JavascriptExecutor)driver;
		Integer noOfFrames = Integer.parseInt(js.executeScript("return window.length")
				.toString());
		System.out.println("Total no of iframes found using JavaScriptExecutor are :"
				+noOfFrames);
		
		//switch between iframes using index no
		for(int i=0;i<noOfIFrames.size();i++) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(i));
			//driver.switchTo().frame(i);
			System.out.println("Switched on frame : "+i);
			driver.switchTo().defaultContent();
		}
		
		//using name/id
		driver.switchTo().frame("frame1");
		String text1 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Text on Frame One : "+text1);
		driver.switchTo().defaultContent();
		
		//using WebElement
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		String text2= driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Text on Frame Two : "+text2);
		driver.switchTo().defaultContent();
		
		
		//close browser
		driver.quit();

	}

}
