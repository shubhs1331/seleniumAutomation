package seleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerDemo {

	public static void main(String[] args) {
		// launch browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		//get page title
		System.out.println("Page title is : "+driver.getTitle());
		
		//close browser
		driver.quit();

	}

}
