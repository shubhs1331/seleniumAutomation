package seleniumAutomation;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationAlertDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoqa.com/alerts");
		
		//handling confirmation alert
		System.out.println("Do you want to accept or Dismiss the alert ? ");
		System.out.println("Enter Y/y/Yes/yes to accept");
		System.out.println("Enter N/n/No/no to dismiss");
		Scanner sc = new Scanner(System.in);
		String selection = sc.next();
		getConfirmationAlert(selection,driver);
		
		//close browser
		driver.quit();

	}
	
	public static void getConfirmationAlert(String selection, WebDriver driver) {
		WebElement confirmAlertButton=driver.findElement(By.id("confirmButton"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", confirmAlertButton);
		Alert confirmationAlert = driver.switchTo().alert();
		String select = selection.toUpperCase();
		if(select.contains("Y")) {
			confirmationAlert.accept();
		}
		else if(select.contains("N")) {
			confirmationAlert.dismiss();
		}
		
		else {
			System.out.println("Made Wrong Selection!!!!!");
		}
		String selectedOption = driver.findElement(By.id("confirmResult")).getText();
		System.out.println(selectedOption);
		}
}
