package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTypesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		
		//Absolute xpath for header image
		String absoluteXpath = "/html/body/div/header/a/img";
		Boolean isAbsoluteXpath = driver.findElement(By.xpath(absoluteXpath)).isDisplayed();
		System.out.println("Element found using Absolute Xpath : "+isAbsoluteXpath);
		
		String relativeXpath = "//header//a[img]";
		Boolean isRelativeXpath = driver.findElement(By.xpath(relativeXpath)).isDisplayed();
		System.out.println("Element found using Relative Xpath : "+isRelativeXpath);
		
		//close browser
		driver.quit();
		

	}

}
