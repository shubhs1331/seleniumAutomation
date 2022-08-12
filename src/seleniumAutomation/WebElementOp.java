package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/** Difference between findElement and findElements method 
 * findElement: returns the first most element found by the given locator strategy, if no element
 * found it throws NoSuchElementException
 * findElements : returns the list of all the elements found by the given locator strategy, if no
 * element found it returns empty list
 * @author Shubhangi Goel
 *
 */

public class WebElementOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//launch the browser and open website
		driver.get("https://demoqa.com/text-box/");
		
		//maximize window
		driver.manage().window().maximize();
		
		//findElement method
		WebElement element = driver.findElement(By.tagName("input"));
		System.out.println(element.getAccessibleName());
		
		//findElements Method
		List <WebElement> elements = driver.findElements(By.tagName("input"));
		System.out.println(elements.size());
		for(WebElement ele:elements) {
			System.out.println(ele.getAccessibleName());
		}
		
		//close browser
		driver.quit();
		

	}

}
