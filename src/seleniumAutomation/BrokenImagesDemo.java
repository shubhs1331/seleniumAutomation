package seleniumAutomation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImagesDemo {

	public static void main(String[] args) {
		// Launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/broken");
		
		//find images on webpage
		List <WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total no. of images on webpage : "+images.size()+"\n");
		
		//validate image URL
		for(int i =0; i<images.size();i++) {
			WebElement image = images.get(i);
			String imgURL = image.getAttribute("src");
			System.out.println("URL of the image "+(i+1)+" : "+imgURL);
			verifyImageURL(imgURL);
		
		//validate image display
		try {
			
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean imgDisplayed = (boolean)js.executeScript("return "
				+ "(typeof arguments[0].naturalWidth !=\'undefined' && "
				+ "arguments[0].naturalWidth>0);", image);
		if(imgDisplayed) {
			System.out.println("DISPLAY - OK\n");
		}
		else {
			System.out.println("DISPLAY - BROKEN\n");
		}
		}
		catch(Exception e) {
			
		}
		}
		
		//close browser
		driver.quit();
	}
	
	public static void verifyImageURL(String imgURL) {
		try {
			URL url = new URL(imgURL);
			HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();
			urlConnect.setConnectTimeout(5000);
			urlConnect.connect();
			
			if(urlConnect.getResponseCode()!=200) {
				System.out.println("HTTP STATUS :  "+urlConnect.getResponseMessage());
			}
			else {
				System.out.println("HTTP STATUS :  "+urlConnect.getResponseMessage());
			}
		}
		catch(Exception e) {
			
		}
	
	}

}
