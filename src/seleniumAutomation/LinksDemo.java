/**
 * Difference between linkText and partialLinkText
 * linkText : It locates element ie <a> tag or link through the name/value specified in the 
 * locator strategy.
 * partialLinkText : It locates element ie <a> tag or link through the partial name/value specified in the 
 * locator strategy.
 */
package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//launch browser and open the demo website
		driver.get("https://demoqa.com/links");
		
		//maximize window
		driver.manage().window().maximize();
		
		//linkText
		WebElement linkElement = driver.findElement(By.linkText("Home"));
		System.out.println("linkText element found : "+linkElement.getAccessibleName());
		
		//partialLinkText
		List <WebElement> partialLinkElement = driver.findElements(By.partialLinkText("Home"));
		System.out.println("partial linkText elements found : ");
		for(WebElement ele : partialLinkElement){
			System.out.println(ele.getAccessibleName());
		}
		
		//close browser
		driver.quit();

	}

}
