package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavascriptScrollDemo {

	public static void main(String[] args) throws InterruptedException {
		// Launch browser
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/broken");
		
		//scroll using scrollIntoView method
		driver.executeScript("window.scrollByLines(15)");
		WebElement brokenLink= driver.findElement(By.xpath
				("//a[text()='Click Here for Broken Link']"));
		brokenLink.click();
		System.out.println("Your clicked on broken link ");
		
		//close browser
		driver.quit();

	}

}
