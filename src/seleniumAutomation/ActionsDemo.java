package seleniumAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		//find right click button
		WebElement rightClickButton= driver.findElement(By.xpath
				("//span[text()='right click me']"));
		
		//Instantiate Actions class reference
		Actions actions = new Actions(driver);
		
		//right click on element
		actions.contextClick(rightClickButton).perform();
		
		//select copy option
		WebElement copy = driver.findElement(By.xpath("//span[text()='Copy']"));
		
		//click on copy 
		copy.click();
		
		//handle alert
		Alert alerts =driver.switchTo().alert();
		String text = alerts.getText();
		alerts.accept();
		System.out.println(text);
		
		//close browser
		driver.quit();
		

	}

}
