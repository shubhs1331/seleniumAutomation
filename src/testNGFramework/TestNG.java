package testNGFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/");
	  String expectedTitle = "ToolsQA";
	  String actualTitle = driver.getTitle();
	  AssertJUnit.assertEquals(actualTitle, expectedTitle);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executed before Test ie BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("Executed After Test ie AfterTestMethod");
  }

}
