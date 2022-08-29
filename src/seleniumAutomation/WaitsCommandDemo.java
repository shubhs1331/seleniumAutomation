package seleniumAutomation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsCommandDemo {

	public static void main(String[] args) {
		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//pageLoadTimeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/dynamic-properties");
		
		//implicitilyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
		WebElement hiddenButton = driver.findElement(By.id("visibleAfter"));

		if(hiddenButton.isEnabled()) {
			hiddenButton.click();
			System.out.println("Hidden button is visible and clickable ");
		}
		else {
		System.out.println("Hidden button is not visible");
		}
		
		
		//explicit wait
		Boolean title = new WebDriverWait(driver, Duration.ofSeconds(10)).until
				(ExpectedConditions.titleIs("ToolsQA"));
		System.out.println("Title of the page is correct : "+title);
		
		
		// close browser
		driver.quit();
	}

}
