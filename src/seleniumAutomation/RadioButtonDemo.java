package seleniumAutomation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebElement element;
		Boolean status;
		
		//Ask to select Radio Button
		System.out.println("Do you like the site?");
		System.out.println("1. Yes \n2. Impressive \n3. No");
		
		Scanner sc = new Scanner(System.in);
		int selection = sc.nextInt();
		
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		RadioButtonDemo rd = new RadioButtonDemo();
		
		switch(selection) {
		case 1 : 
			element = driver.findElement(By.id("yesRadio"));
			status = element.isEnabled();
			rd.selectRadioButton(element,status,executor,driver);
			break;
			
		case 2:
			element = driver.findElement(By.id("impressiveRadio"));
			status = element.isEnabled();
			rd.selectRadioButton(element,status,executor,driver);
			break;
		
		case 3:
			element = driver.findElement(By.id("noRadio"));
			status = element.isEnabled();
			rd.selectRadioButton(element,status,executor,driver);	
			break;
			
		default :
			System.out.println("you have selected incorrect option !!!");
				
		}
		
		//close browser
		driver.quit();

	}
	
	public void selectRadioButton(WebElement element, Boolean status, JavascriptExecutor executor, WebDriver driver) {
		try{
			String optionName = element.getAccessibleName();
			if(status == true) {
			System.out.println(optionName+ "Radio button is enabled");
			//yesRadio.click(); //if normal click method doesn't work use JavaScriptExecutor
			executor.executeScript("arguments[0].click()", element);
			Thread.sleep(3000);
			try {
			String optionText = "//span[text()='"+optionName+"']";
			String selectedOption = driver.findElement(By.xpath(optionText)).getText();
			
			if(optionName.equals(selectedOption)){
				System.out.println("You have selected correct option "+selectedOption);
			}
			else {
				System.out.println("You have selected "+selectedOption);
				System.out.println("Expected option is : "+optionName);
			}
		     }
			catch(Exception e) {
				System.out.println("unable to display selected option");
			}
			}
		else {
			System.out.println(optionName+"Radio Button is not enabled");
		}
		}
		catch(Exception e) {
			System.out.println(element.getAccessibleName()+"webelement not found !!!!");
		}
	}
}
