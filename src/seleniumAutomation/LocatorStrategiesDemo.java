package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorStrategiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		//1. using id locator
		WebElement fname = driver.findElement(By.id("firstName"));
		fname.sendKeys("Shubhangi");
		System.out.println("Entered name as : "+fname.getAttribute("value"));
		
		//2. using xpath locator
		WebElement email = driver.findElement(By.xpath
				("//input[@placeholder ='name@example.com']"));
		email.sendKeys("shubhs1331@gmail.com");
		System.out.println("\nEntered email as : "+email.getAttribute("value"));
		
		//3. using css locator
		WebElement gender = driver.findElement(By.cssSelector("input[value='Female']"));
		js.executeScript("arguments[0].click()", gender);
		System.out.println("\nClicked on : "+gender.getAccessibleName()+" radiobutton");
		
		//We can use below commented lines of code too instead of JavaScriptExecutor
		
		/*WebElement gender = driver.findElement(By.cssSelector("label[for='gender-radio-2']"));
		//gender.click();*/
		
		
		//click on Elements tab
		driver.findElement(By.xpath("//div[text()='Elements']")).click();
		//click on Links tab
		WebElement links = driver.findElement(By.xpath("//span[text()='Links']"));
		js.executeScript("arguments[0].click()", links);
		System.out.println("\nclicked on links");
		
		//4. using linkText
		System.out.println("\nElements found using linkText");
		WebElement linkTextElement = driver.findElement(By.linkText("Home"));
		linkTextElement.click();
		System.out.println(linkTextElement.getAccessibleName());
		
		//5. using partialLinkText
		System.out.println("\nElements found using partialLinkText");
		List <WebElement> partialLinkelements = driver.findElements(By.partialLinkText("Ho"));
		for(WebElement ele:partialLinkelements) {
			System.out.println(ele.getAccessibleName());
		}
		
		//click on textBox
		WebElement textBox = driver.findElement(By.xpath("//span[text()='Text Box']"));
		js.executeScript("arguments[0].click()", textBox);
		
		//6. using tagname locator
		List <WebElement> inputTags= driver.findElements(By.tagName("input"));
		System.out.println("\nFound "+inputTags.size()+" input elements");
		
		//7. using classname locator
		List <WebElement> classes = driver.findElements(By.className("form-control"));
		System.out.println("\nFound "+classes.size()+" elements with same class name");
		
		
		//close browser
		driver.quit();
		

	}

}
