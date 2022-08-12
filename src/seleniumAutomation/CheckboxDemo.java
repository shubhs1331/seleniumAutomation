package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//launch browser and open demo website
		driver.get("https://demoqa.com/automation-practice-form");
		
		//maximize window
		driver.manage().window().maximize();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		//select checkbox using id
		
		WebElement sportsCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		
		//isSelected() method
		if(sportsCheckbox.isSelected()== false) {
		executor.executeScript("arguments[0].click()", sportsCheckbox);
		System.out.println("checkbox selected using id locator");
		}
		
		//select checkbox using xpath
		String readingXpath = "//input[@type='checkbox' and @id='hobbies-checkbox-2']";
		WebElement readingCheckbox = driver.findElement(By.xpath(readingXpath));
		
		//isDisplayed() method
		if(readingCheckbox.isDisplayed()|| readingCheckbox.isEnabled()) {
					executor.executeScript("arguments[0].click()", readingCheckbox);
					System.out.println("checkbox selected using xpath locator");
				}
				
		
		//select checkbox using css selector
		String musicCssSelector = "label[for='hobbies-checkbox-3']";
		WebElement musicCheckbox = driver.findElement(By.cssSelector(musicCssSelector));
		
		//isEnabled() method
		if(musicCheckbox.isEnabled()==true) {
			executor.executeScript("arguments[0].click()", musicCheckbox);
			System.out.println("checkbox selected using css locator");
		}
		
		//close browser
		driver.quit();

	}

}
