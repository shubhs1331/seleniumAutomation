package seleniumAutomation;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandlesDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoqa.com/alerts");
		
		//handling simple alert
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
//		Alert simpleAlert = driver.switchTo().alert();
//		simpleAlert.accept();
		//You can write below line as well instead of above two lines
		driver.switchTo().alert().accept();
		System.out.println("This is simple alert!!!!");
		
		//handling prompt alert
		WebElement element = driver.findElement(By.id("promtButton"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Shubhangi Goel");
		promptAlert.accept();
		System.out.println("This is a prompt alert!!!!");
		String text = driver.findElement(By.id("promptResult")).getText();
		System.out.println(text);
		
		//handling confirmation alert
		getConfirmationAlert(true,driver);
		getConfirmationAlert(false,driver);
		
		//close browser
		driver.quit();

	}
		
	public static void getConfirmationAlert(Boolean flag, WebDriver driver) {
		
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmationAlert = driver.switchTo().alert();
		//String select = selection.toUpperCase();
		if(flag==true) {
			confirmationAlert.accept();
		}
		else{
			confirmationAlert.dismiss();
		}
		String selectedOption = driver.findElement(By.id("confirmResult")).getText();
		System.out.println(selectedOption);
		}

}
