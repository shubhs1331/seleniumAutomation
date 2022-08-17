package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdownDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String firstSelectedText;

		//launch browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();

		//select standard multi-select menu
		WebElement multiOption = driver.findElement(By.id("cars"));
		Select select = new Select(multiOption);

		//Verify that the element is multi-select
		Boolean isMultiSelectDropdown = select.isMultiple();
		if(isMultiSelectDropdown) {
			System.out.println("It is a multi-select dropdown");
		}
		else {
			System.out.println("It is not a multi-select dropdown");
		}

		//select and deselect Opel by index
		select.selectByIndex(2);
		firstSelectedText = select.getFirstSelectedOption().getText();
		System.out.println(firstSelectedText + " is selected by index");
		select.deselectByIndex(2);
		Thread.sleep(2000);
		System.out.println(firstSelectedText + " is de-selected by index");

		//select and deselect Saab by value
		select.selectByValue("saab");
		firstSelectedText = select.getFirstSelectedOption().getText();
		System.out.println(firstSelectedText + " is selected by value");
		select.deselectByValue("saab");
		Thread.sleep(2000);
		System.out.println(firstSelectedText + " is de-selected by value");
		
		//deselect all options
		select.selectByVisibleText("Volvo");
		select.selectByVisibleText("Audi");
		select.deselectAll();
		System.out.println("Deselected all options");

		//close browser
		driver.quit();


	}

}
