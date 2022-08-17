package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SingleSelectDropdownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebElement firstSelectedElement;
		
		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		
		// select old style menu dropdown
		WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(oldSelectMenu);
		
		//print all options of dropdown
		System.out.println("List of all the options of dropdown");
		List <WebElement> allOptions = select.getOptions();
		for(WebElement option : allOptions) {
			System.out.println(option.getText());
		}
		
		//select purple using index
		System.out.println("\nSelect purple by index !!!!!!!!!! ");
		select.selectByIndex(4);
		firstSelectedElement = select.getFirstSelectedOption();
		System.out.println(firstSelectedElement.getText()+" is selected");
		
		//select magenta using visible text
		System.out.println("\nSelect Magenta by visible text !!!!!!!!!! ");
		select.selectByVisibleText("Magenta");
		firstSelectedElement = select.getFirstSelectedOption();
		System.out.println(firstSelectedElement.getText()+" is selected");
		
		//select blue using value
		System.out.println("\nSelect blue by value !!!!!!!!!! ");
		select.selectByValue("1");
		firstSelectedElement = select.getFirstSelectedOption();
		System.out.println(firstSelectedElement.getText()+" is selected");
		
		
		//close the browser
		driver.quit();
		

	}

}
