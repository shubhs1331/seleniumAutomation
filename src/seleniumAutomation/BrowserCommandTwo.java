package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommandTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//driver path set as system environment variables
		WebDriver driver = new ChromeDriver();
		
		//launch browser and open demo website
		String url = "https://demoqa.com/browser-windows/";
		driver.get(url);
		
		// click on New Window Button
		try {
			String WinId = "//button[@id = 'windowButton']";
			WebElement newWindowBtn = driver.findElement(By.xpath(WinId));
			if(newWindowBtn.isDisplayed()) {
				try {
					newWindowBtn.click();
					System.out.println("Succesfully clicked on New Window Button...");
				}
				catch(Exception e) {
					System.out.println("Unable to click on New Window button");
				}
		}
		}
		catch(Exception e){
			System.out.println(" New Window button is not present on page");
		}
		
		// close browser
		driver.quit();

	}

}
