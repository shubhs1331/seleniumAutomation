package seleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		// launch chrome browser and open shop.demoqa.com
		String URL = "https://shop.demoqa.com";
		driver.get(URL);
		
		//get page title and title length
		String title = driver.getTitle();
		int titleLength = title.length();
		
		// print page title and length
		System.out.println("Page title is : "+title);
		System.out.println("Page title length is : "+titleLength);
		
		//get page URL and verify it is correct or not
		String actualURL = driver.getCurrentUrl();
		if(URL.equals(actualURL)) {
			System.out.println(actualURL + " is correct URL");
		}
		else {
			System.out.println("Verification failed !!!");
			System.out.println("Actual URL is : "+ actualURL);
			System.out.println("Expected URL is : "+ URL);
		}
		
		//get page source and page source length
		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();
		
		//print page source length
		System.out.println("Page source length is : "+pageSourceLength);
		
		// close the browser
		driver.close();
	}

}
