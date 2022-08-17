package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemoOne {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();


		//get value Company and print
		WebElement companyHeading = driver.findElement(By.xpath("//th[text()='Company']"));
		System.out.println("Heading of 1st row is : " +companyHeading.getText());

		//get 0th column  of 8th row
		//JavascriptExecutor execute = (JavascriptExecutor)driver;
		WebElement companyName = driver.findElement(By.xpath("//table[@class='dataTable']//tr[3]//td[1]//a"));
		companyName.click();
		Thread.sleep(5000);
		System.out.println("clicked on : "+companyName.getText());

		//close browser
		driver.quit();


	}

}
