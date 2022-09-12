package seleniumAutomation;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class HtmlUnitDriverDemo {

	public static void main(String[] args) {
		// create instance of HtmlUnitDriver
		String expectedTiltle = "ToolsQA";
		HtmlUnitDriver unitDriver = new HtmlUnitDriver();
		unitDriver.manage().window().maximize();
		unitDriver.get("https://demoqa.com/");
		String actualTitle = unitDriver.getTitle();
		if(actualTitle.equals(expectedTiltle)) {
			System.out.println("actual title : "+actualTitle+
					" is same as expected title : "+expectedTiltle);
		}
		else {
			System.out.println("actual title : "+actualTitle+
					" is different from expected title : "+expectedTiltle);
		}
		
		//close driver
		unitDriver.quit();

	}

}
