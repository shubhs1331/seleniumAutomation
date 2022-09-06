package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActionsDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu");
		
		//find the target elements
		WebElement mainMenu = driver.findElement(By.xpath
				("//a[text()='Main Item 2']"));
		WebElement subMenu = driver.findElement(By.xpath
				("//a[text()='SUB SUB LIST »']"));
		WebElement subMenuItem = driver.findElement(By.xpath
				("//a[text()='Sub Sub Item 1']"));		
		
		//create Actions class object
		Actions actions = new Actions(driver);
		
		//Mouse Hover on mainMenu
		actions.moveToElement(mainMenu).perform();
		
		List <WebElement> mainMenuList = driver.findElements(By.xpath("//a[text()='Main Item 2']//..//child::li"));
		System.out.println("Size of Main Menu List : "+mainMenuList.size());
		for(WebElement ele : mainMenuList) {
			System.out.println(ele.getText());
		}

		//Mouse Hover on Sub-Menu
		actions.moveToElement(subMenu).perform();
		
		//List <WebElement> subMenuList = driver.findElements(By.tagName("a"));
		List <WebElement> subMenuList = driver.findElements(By.xpath("//a[text()='SUB SUB LIST »']//..//child::li"));
		System.out.println("Size of Sub Menu List : "+subMenuList.size());
		for(WebElement subEle : subMenuList) {
			System.out.println(subEle.getText());
		}
		
		//Mouse hover on sub-menu item
		actions.moveToElement(subMenuItem).perform();
		
		//close browser
		driver.quit();
		
		
	}

}
