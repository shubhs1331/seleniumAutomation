package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationCommandsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		// open demoqa.com
		String url = "https://demoqa.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
		//click on elements
		String elementXpath = "//div[@class='card mt-4 top-card']//h5[text()='Elements']";
		try {
		try {
			WebElement ele = driver.findElement(By.xpath(elementXpath));
			if(ele.isDisplayed()) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", ele);
				Thread.sleep(3000);
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				System.out.println("Clicked on Elements Successfully!!!");
			}
		}
			catch(Exception e) {
				System.out.println("Elements is not displayed!!");
			}
		
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("Navigate back successfully!!!");
		driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println("Navigate forwards successfully!!!");
		driver.navigate().to(url);
		Thread.sleep(2000);
		System.out.println("Navigate to URL successfully!!!");
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("Page refreshed successfully!!!");
		}
		catch(Exception e) {
			System.out.println("Unable to navigate successfully!!!");
		}
		
		// close browser
		driver.quit();

	}

}
