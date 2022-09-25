package testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngDependencyDemo {
	
	static WebDriver driver;
	String expectedTitle = "ToolsQA";
	String expectedHeader = "Sortable";
	
  @BeforeTest(groups = {"demo"})
  public void launchSite() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/sortable"); 
  }
  
  @Test(dependsOnMethods ={"launchSite"})
  public void verifyTitle() {
	 String actualTitle = driver.getTitle();
	 System.out.println("Actual Title is : "+actualTitle);
	 System.out.println("Expected Title is : "+expectedTitle);
	 Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(dependsOnGroups = {"demo"})
  public void verifyHeader() {
	  String actualHeader = driver.findElement(By.className("main-header")).getText();
	  Assert.assertEquals(actualHeader, expectedHeader);
	  System.out.println("Actual Header is : "+actualHeader);
	  System.out.println("Expected Header is : "+expectedHeader);
  }
  
  @Test(dependsOnGroups = {"demo"})
  public void verifyElementClick() {
	  driver.findElement(By.id("demo-tab-grid")).click();
	  System.out.println("Clicked on Grid Element!!!");
  }
  
  @AfterTest(groups= {"demo1"})
  public void closeBrowser() {
	  driver.quit();
	  System.out.println("Browser closed!!!!");
  }
  
}
