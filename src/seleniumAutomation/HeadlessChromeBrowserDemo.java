package seleniumAutomation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeBrowserDemo {

	public static void main(String[] args) {
		
		// create instance of ChromeOptions to change default behavior of chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		ChromeDriver driver = new ChromeDriver(options);
		
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
