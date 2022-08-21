package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Launch browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();

		//using ancestor to locate form tag
		Boolean isFormPresent = driver.findElement(By.xpath
				("//input[@id='userName']/ancestor::form")).isDisplayed();
		System.out.println("Element found using ancestor axes : "+isFormPresent);

		//using child to locate full name text box from form
		WebElement fullname = driver.findElement(By.xpath
				("//form[@id='userForm']/child::div//input"));
		Boolean isFullnamePresent = fullname.isDisplayed();
		System.out.println("Element found using child axes : "+isFullnamePresent+
				" and the inner text is : "+fullname.getAccessibleName());

		//using descendant axes to locate yes radio button
		driver.navigate().to("https://demoqa.com/radio-button");
		Boolean isYesRadioButtonDisplayed = driver.findElement(By.xpath
				("//div[@class='custom-control custom-radio custom-control-inline'][1]"
						+ "/descendant::label")).isDisplayed();
		System.out.println("Element found using descendant axes : "+isYesRadioButtonDisplayed);

		//using parent axis to locate No radion button
		Boolean isNoRadioButtonEnabled = driver.findElement(By.xpath
				("//input[@id ='noRadio']/parent::div")).isEnabled();
		System.out.println("Element found using parent axes and No radio button is disabled : "
				+isNoRadioButtonEnabled);

		//using following axes to locate current address
		driver.navigate().back();
		Boolean isCurrentAddDisplay = driver.findElement(By.xpath
				("//input[@id ='userName']/following::textarea[1]")).isDisplayed();
		System.out.println("Element found using following axes : "+isCurrentAddDisplay);

		//using following-sibling to locate yes radio button
		driver.navigate().forward();
		Boolean isYesRadioButtonEnabled = driver.findElement(By.xpath
				("//div[@class='mb-3']/following-sibling::div[1]//input")).isEnabled();
		System.out.println("Element found using following-sibling axes : "+isYesRadioButtonEnabled);

		//using preceding axis to locate fullname
		driver.navigate().back();
		Boolean isFullNameDisplayed = driver.findElement
				(By.xpath("//input[@id ='userEmail']/preceding::input")).isDisplayed();
		System.out.println("Element found using preceding axes : "+isFullNameDisplayed);

		//close browser
		driver.quit();



	}

}
