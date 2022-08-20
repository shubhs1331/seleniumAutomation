package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch broswer
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		
		//Single slash "/" to validate image at the start of the page
		Boolean imgPresent = driver.findElement(By.xpath("/html/body/div/header/a/img"))
				.isDisplayed();
		if(imgPresent) {
			System.out.println("Element found using slash : "+imgPresent);
		}
		
		// Double slash "//" to validate image
		Boolean firstImg = driver.findElement(By.xpath("//img")).isDisplayed();
		if(firstImg) {
			System.out.println("Element found using double slash : "+firstImg);
		}
		
		//Address "@" fullname textbox
		WebElement firstName = driver.findElement(By.xpath("//input[@id='userName']"));
		System.out.println("Element found using @ : "+firstName.getAccessibleName());
		
		//Dot "." full name textbox
		WebElement firstNameDot = driver.findElement(By.xpath("//input[contains(@id , 'userN')]/."));
		System.out.println("Element found using dot :  "+firstNameDot.getAccessibleName());
		
		//Double dot ".." - full name label
		WebElement firstNameDouble = driver.findElement(By.xpath("//input[contains(@id , 'userN')]"
				+ "/../../div/label"));
		System.out.println("Element found using Double dot : "+firstNameDouble.getText());
		
		//asterisk "*" full name label
		WebElement firstNameAsterisk = driver.findElement(By.xpath("//*[@id ='userName']"));
		System.out.println("Element found using Asterisk : "+firstNameAsterisk.getAccessibleName());
		
		//Address and Asterisk "@*" - fullname label
		WebElement addressAsterisk = driver.findElement(By.xpath("//input[@* ='userName']"));
		System.out.println("Element found using Address and Asterisk : "+addressAsterisk.getAccessibleName());
		
		//Pipe "|" to locate both fullname and email label
		List <WebElement> pipeElements = driver.findElements(By.xpath("//label[contains(@id ,'userName')]|"
				+ "//label[text()='Email']"));
		
		System.out.println("Pipe Elements found are :");
		for(WebElement ele : pipeElements) {
			System.out.println(ele.getText());
		}
				
		//close browser
		driver.quit();

	}

}
