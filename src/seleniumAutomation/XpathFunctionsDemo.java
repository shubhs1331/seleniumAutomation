package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathFunctionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Launch broswer
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		
		//contains()
		WebElement fullname = driver.findElement(By.xpath("//input[contains(@placeholder,'Full')]"));
		System.out.println("Element found using contains() function : "+fullname.getAccessibleName());
		
		//starts-with
		WebElement email = driver.findElement(By.xpath("//input[starts-with(@placeholder,'name@')]"));
		System.out.println("Element found using starts-with function : "+email.getAccessibleName());
		
		//text()
		WebElement currentAddress = driver.findElement(By.xpath("//label[text()='Current Address']"));
		System.out.println("Element found using text function : "+currentAddress.getText());
		
		//using AND operator
		WebElement permanentAddress = driver.findElement(By.xpath
				("//textarea[@rows='5' and @id='permanentAddress']"));
		permanentAddress.sendKeys("PO BOX 1234");
		System.out.println("Found Element using AND operator : "+permanentAddress.getAttribute("value"));
		
		//using OR operator
		WebElement username = driver.findElement(By.xpath
				("//label[text()='Full Name' or @id='userName-label']"));
		System.out.println("Found Element using OR operator : "+username.getText());
		
		//close broswer
		driver.quit();
		

	}

}
