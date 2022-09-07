/**
 * We can do method chaining for contiguous keyboard actions in one go
 */
package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEventsDemoThree {

	public static void main(String[] args) {
		// launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		
		//Enter the full-name
		WebElement fullname = driver.findElement(By.id("userName"));
		fullname.sendKeys("Henry Ford");
		
		//Enter email address
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("henryford@gmail.com");
		
		//Enter Current Address
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		currentAddress.sendKeys("PO BOX 12345");
		
		//select the current address
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build()
		.perform();
		
		//copy the current address
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build()
		.perform();
		
		//scroll the vertical bar to see permanent address field
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
		
		//paste the current address to permanent address
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		actions.keyDown(permanentAddress,Keys.CONTROL).sendKeys("V").
		keyUp(permanentAddress,Keys.CONTROL).build().perform();
		
		//validate text
		String currentAddressText = currentAddress.getAttribute("value");
		String permanentAddressText = permanentAddress.getAttribute("value");
		if(permanentAddressText.equals(currentAddressText)) {
			System.out.println("PASS : current address : "+currentAddressText+
					" and permanent address : "+permanentAddressText+" are same");
		}
		else {
			System.out.println("FAIL : current address : "+currentAddressText+
					" and permanent address : "+permanentAddressText+" are not same");
		}
		
		//close browser
		driver.quit();
	}

}
