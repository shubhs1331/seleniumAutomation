package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIFrameDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/nestedframes");
		
		//get IFrame count on main page
		int noOfFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of frames on main page: "+noOfFrames);
		
		//switch to parent frame
		driver.switchTo().frame("frame1");
		//get parent Iframe text
		String parentText=driver.findElement(By.tagName("body")).getText();
		System.out.println("Text on Parent Frame : "+parentText);
		
		//no of child frames inside parent frame
		int noOfChildFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of child frames : "+noOfChildFrames);
		
		//switch to child Iframe
		driver.switchTo().frame(0);
		//get child Iframe text
		String childText=driver.findElement(By.tagName("body")).getText();
		System.out.println("Text on Parent Frame : "+childText);
		
		//get no of frames inside child frame
		int noOfSubChildFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of sub-child frames : "+noOfSubChildFrames);
		
		//switch back context to parent frame
		driver.switchTo().parentFrame();
		String switchBackToParent =driver.findElement(By.tagName("body")).getText();
		System.out.println("Switched back to parent Iframe : "+switchBackToParent);
		
		//switch back context to main page use defaultContent()
		//driver.switchTo().parentFrame(); //we can use this as parent of parent frame is mainpage
		driver.switchTo().defaultContent();
		String mainHeader = driver.findElement(By.className("main-header")).getText();
		System.out.println("Switched back to Main Page : "+mainHeader);
		
		//close browser
		driver.quit();
		

	}

}
