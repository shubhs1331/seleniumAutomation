package seleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FirstDemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
				//set path of browser driver
				System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Drivers\\chromedriver.exe");
				
				//create object of WebDriver interface
				WebDriver driver = new ChromeDriver();
				
				//launch the browser and enter the URL
				driver.get("https://demoqa.com/login");
				
				//maximize browser window
				driver.manage().window().maximize();
				
				//Retrieve title of the page
				String title= driver.getTitle();
				System.out.println("Title of the page : "+title);
				
				//Login into application using credentials username :'testuser' password : 'Password@123'
				WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
				WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
				WebElement loginButton = driver.findElement(By.xpath("//button[@id='login']"));
				
				//perform actions on the above login elements
				userName.sendKeys("testuser");
				password.sendKeys("Password@123");
				
				/**unable to perform click on button due to ElementClickInterceptedException,
				So either use Action class or JavaScriptExecutor**/ 
				/*Actions act =  new Actions(driver);
				act.moveToElement(loginButton).click().perform();*/
				
				try {
					loginButton.click();
				  } catch (Exception e) {
				     JavascriptExecutor executor = (JavascriptExecutor) driver;
				     executor.executeScript("arguments[0].click();", loginButton);
				  }
				
				System.out.println("Login Succesfully!!!");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Validate Logout button and welcome valid user
				try {
				String user = driver.findElement(By.xpath("//label[@id='userName-value']")).getText();	
				WebElement logoutBtn = driver.findElement(By.xpath("//button[@id='submit' and text()='Log out']"));
				if(logoutBtn.isDisplayed()) {
					// Logging out from application
					try {
						logoutBtn.click();
					}
					catch(Exception e) {
						 JavascriptExecutor executor = (JavascriptExecutor)driver;
						 executor.executeScript("arguments[0].click();",logoutBtn );
					}
				}
				System.out.println("Welcome "+user+"!!!!!");
				}
				catch(Exception e) {
					System.out.println("Incorrect Login");
				}
				
				//close browser 
				driver.quit();
				


	}

}
