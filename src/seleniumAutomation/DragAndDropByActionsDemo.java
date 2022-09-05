package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropByActionsDemo {

	public static void main(String[] args) {
		// Launch browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://demoqa.com/droppable");
				
				//find source and target elements
				WebElement from = driver.findElement(By.id("draggable"));
				WebElement to = driver.findElement(By.id("droppable"));
				
				//get x-offset and y-offset of source
				int xOffsetFrom = from.getLocation().getX();
				int yOffsetFrom = from.getLocation().getY();
				
				//get x-offset and y-offset of target
				int xOffsetTo = to.getLocation().getX();
				int yOffsetTo = to.getLocation().getY();
				
				// get x-offset and y-offset
				int xOffset = xOffsetTo - xOffsetFrom;
				int yOffset = yOffsetTo - yOffsetFrom;
				
				//Create instance of Actions class
				Actions actions= new Actions(driver);
				
				// perform drag and drop operation
				actions.dragAndDropBy(from, xOffset, yOffset).perform();
				
				//verify dropped message
				String text= to.getText();
				if(text.equals("Dropped!")) {
					System.out.println("PASSED : Source is dropped at target");
				}
				else {
					System.out.println("FAIL : Source is not dropped at target");
				}
				
				//close browser
				driver.quit();
				

	}

}
