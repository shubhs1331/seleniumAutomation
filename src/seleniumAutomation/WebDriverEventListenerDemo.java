package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverEventListenerDemo {

	public static void main(String[] args) {
		// Create WebDriver instance
		WebDriver driver = new ChromeDriver();
		
		//create EventFiringWebDriver instance using regular driver
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
		//create instance of EventHandler class that implements WebDriverEventListener Interface
		EventHandler handler = new EventHandler();
		
		//Register object of EventHandler class 
		eventDriver.register(handler);
		
		//launch browser
		eventDriver.get("https://demoqa.com/links");
		
		//find and click on simple link
		eventDriver.findElement(By.id("simpleLink")).click();
		System.out.println("clicked on simple link");
		
		//close browser
		eventDriver.quit();

	}
}