package seleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxBrowserDemo {

	public static void main(String[] args) {
		
		// create instance of ChromeOptions to change default behavior of chrome
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		WebDriver driver = new FirefoxDriver(options);
		
		//launch browser
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		String expectedTitle = "ToolsQA";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Actual title : "+actualTitle+" is same as expected"
					+ "title : "+expectedTitle);
		}
		else {
			System.out.println("Actual title : "+actualTitle+" is different from"
					+ " expected title : "+expectedTitle);
		}
		
		//close browser
		driver.quit();
	}

}
