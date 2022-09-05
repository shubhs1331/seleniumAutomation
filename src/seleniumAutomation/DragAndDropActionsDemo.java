package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActionsDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable");
		
		//find source and target elements
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		//Instantiate Actions class object
		Actions actions = new Actions(driver);
		
		//perform drag and drop
		actions.dragAndDrop(source, target).perform();
		System.out.println("Drag and Drop Action performed succesfully!!!!!");
		
		//close browser
		driver.quit();

	}

}
