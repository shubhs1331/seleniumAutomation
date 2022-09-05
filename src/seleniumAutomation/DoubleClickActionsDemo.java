package seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleClickActionsDemo {

	public static void main(String[] args) {
		// launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		//find double click button
		WebElement doubleClickButton = driver.findElement
				(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		
		//perform normal click
		//doubleClick.click(); //no action will be performed
		
		//Instantiate Actions object reference
		Actions actions = new Actions(driver);
		
		//perform double click
		actions.doubleClick(doubleClickButton).perform();
		System.out.println("double clicked action performed");
		
		//explicit wait for alert to be present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		//accept alert
		Alert alerts = driver.switchTo().alert();
		String text = alerts.getText();
		alerts.accept();
		System.out.println(text);
		
		//close broswer
		driver.quit();

	}

}
