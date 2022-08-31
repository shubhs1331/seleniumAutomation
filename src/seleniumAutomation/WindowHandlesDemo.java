package seleniumAutomation;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesDemo {

	public static void main(String[] args) throws InterruptedException {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		
		//get parent window handle
		String parentWindow = driver.getWindowHandle();
		System.out.println("This is parent window handle : "+parentWindow);
		
		//click on child windows
		driver.findElement(By.id("windowButton")).click();
		
		
		//get child window handles
		Set <String> childWindows = driver.getWindowHandles();
		System.out.println("This is child window handles : "+childWindows);
		Iterator <String> i = childWindows.iterator();
		
		//String [] locators ={"//h1[@id='sampleHeading']","//body[contains(text(),'Knowledge')]"};
		while(i.hasNext()) {
			String childWindow = i.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("window switched");
				driver.manage().window().maximize();
				System.out.println("window maximize");
				String text = driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(text);
			}
		}
		
		//close browser
		driver.quit();

	}

}
