package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickActionsDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		
		//find right click button
		WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
		
		//Creating refrence of Actions class
		Actions actions = new Actions(driver);
		
		//performing right click
		actions.contextClick(rightClickButton).perform();
		
		//Verify right click action performed
		String text = driver.findElement(By.id("rightClickMessage")).getText();
		System.out.println(text);
		
		//close browser
		driver.quit();

	}

}
