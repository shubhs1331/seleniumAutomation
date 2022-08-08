package seleniumAutomation;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchFirefoxBrowser {

	public static void main(String[] args) {
		System.out.println("Select the firefox/gecko driver setup from below:  ");
		System.out.println("1. Using System properties in Environment variables");
		System.out.println("2. Using System properties in Test Script");
		System.out.println("Enter 1 or 2");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch(option) {
		
		//Using System properties in Environment variables
		case 1 : 
			System.out.println("1. Using System properties in Environment variables");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://demoqa.com/login");
			System.out.println("Firefox browser launched !!!");
			driver.quit();
			break;
			
		case 2 : 
			System.out.println("2. Using System properties in Test Script");
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Drivers\\geckodriver.exe");
			WebDriver driver1 = new FirefoxDriver();
			driver1.get("https://demoqa.com/login");
			System.out.println("Firefox browser launched !!!");
			driver1.quit();
			break;
			
			default:
				System.out.println("No option selected");
				break;
	}

	}
}
