package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadFileDemo {

	public static void main(String[] args) throws InterruptedException {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		
		//scroll down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		//find upload file web element
		WebElement uploadFile = driver.findElement(By.id("uploadPicture"));
		uploadFile.click();
		//uploadFile.sendKeys("C:\\Users\\Dell\\Documents\\sampleFile.txt");
		Thread.sleep(3000);
		System.out.println("File Uploaded Successfully!!!");
		
		//close browser
		driver.quit();

	}

}
