package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TooltipDemo {

	public static void main(String[] args) {
		
		String expectedTooltipText = "Github";
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/social-icon.html");
		
		//find tool-tip element using WebDriver By locator strategy
		WebElement tooltipOne = driver.findElement(By.xpath("//a[@class='github']"));
		String actualTooltipText = tooltipOne.getAttribute("title");
		verifyText(actualTooltipText,expectedTooltipText);
	
		//expected tool-tip text
		expectedTooltipText = "Google+";
		
		//find tool-tip web element
		WebElement tooltipTwo = driver.findElement(By.xpath("//a[@class='google']"));
		
		//find tool-tip text using Actions class
		Actions actions = new Actions(driver);
		actions.moveToElement(tooltipTwo).perform();
		WebElement tooltip = driver.findElement(By.xpath("//span[text()='Google+']"));
	    actualTooltipText = tooltip.getText();
		verifyText(actualTooltipText,expectedTooltipText);
		
		//close browser
		driver.quit();
		

	}
	
	public static void verifyText(String actualTooltipText, String expectedTooltipText) {
		if(actualTooltipText.equals(expectedTooltipText)) {
			System.out.println("Actual Tooltip text : "+actualTooltipText+
					" is same as Expected Tooltip Text : "+ expectedTooltipText);
		}
		else {
			System.out.println("Actual Tooltip text : "+actualTooltipText+
					" is different from Expected Tooltip Text : "+ expectedTooltipText);
		}
		
	}

}
