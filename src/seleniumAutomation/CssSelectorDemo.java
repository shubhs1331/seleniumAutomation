package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//launch browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		//using id attribute find FirstName
		WebElement firstname= driver.findElement(By.cssSelector("input[id='firstName']"));
		firstname.sendKeys("First name");
		System.out.println("Element found using id : "+firstname.isDisplayed());
		
		// # can be used in place of id in css path
		WebElement lastName = driver.findElement(By.cssSelector("input#lastName"));
		lastName.clear();
		lastName.sendKeys("Last name");
		System.out.println("Element found using # in place of id : "+
		lastName.isDisplayed());
		
		//using class attribute to find header
		Boolean isHeaderVisible = driver.findElement(By.cssSelector("div[class='main-header']"))
				.isDisplayed();
		System.out.println("Element found using class : "+isHeaderVisible);
		
		// . can be used in place of class in css path
		Boolean isRegisterationFormVisible = driver.findElement(By.cssSelector
				("div.practice-form-wrapper")).isDisplayed();
		System.out.println("Element found using . in place of class : "+isRegisterationFormVisible);
		
		//Attribute to find Mobile number
		Boolean isMobileNoVisible = driver.findElement(By.cssSelector
				("input[placeholder='Mobile Number']")).isDisplayed();
		System.out.println("Element found using other attribute : "+isMobileNoVisible);
		
		//Sub-String starts, ends, contains text
		Boolean isEmailVisible = driver.findElement(By.cssSelector("input[placeholder*='name@']"))
				.isDisplayed();
		System.out.println("Element found using starting text substring : "+isEmailVisible);
		
		Boolean isMaleRadioButton = driver.findElement(By.cssSelector
				("input[value$='ale']")).isEnabled();
		System.out.println("Element found using ending text substring : "+isMaleRadioButton);
		
		Boolean isFemaleRadioButton = driver.findElement(By.cssSelector
				("input[value*='emal']")).isEnabled();
		System.out.println("Element found using contains text : "+isFemaleRadioButton);
		
		//combine attribute
		WebElement hobbies = driver.findElement(By.cssSelector
				("input#hobbies-checkbox-1[type='checkbox']"));
		System.out.println("Element found by combining attributes : "+hobbies.isEnabled());
		
		//close browser
		driver.quit();

	}

}
