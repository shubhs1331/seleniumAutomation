package seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverSliderDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demoqa.com/slider");
		
		//find slider web element
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		
		//Create Actions class object
		Actions actions = new Actions(driver);
		
		//move slider and get it's value
		actions.moveToElement(slider,50, 0).perform();
		slider.click();
		String inputValue = slider.getAttribute("value");
		System.out.println("Slider moved by : "+inputValue);
		
		//close browser
		driver.quit();
		
		
		

	}

}
