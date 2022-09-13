package seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshPageDemo {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		
		// 1. using refresh command
		driver.navigate().refresh();
		System.out.println("Page refreshed using refresh command");
		
		//2. using sendKeys command
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(Keys.F5);
		System.out.println("Page refreshed using sendKeys command");
		
		//3. using get method
		driver.get(driver.getCurrentUrl());
		System.out.println("Page refreshed using get command");
		
		//4. using sendKeys with ASCII Code
		driver.findElement(By.name("q")).sendKeys("\uE035");
		System.out.println("Page refreshed using sendKeys command with ASCII Code");
		
		//using to command
		driver.navigate().to(driver.getCurrentUrl());
		System.out.println("Page refreshed using To command");
		
		//close browser
		driver.quit();

	}

}
