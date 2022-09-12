package seleniumAutomation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksDemo {

	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		
		List <WebElement> list = driver.findElements(By.tagName("a"));
		
		System.out.println("Total no of links on webpage are : "+list.size());
		
		for(int i =0;i<list.size();i++) {
			WebElement link = list.get(i);
			String url = link.getAttribute("href");
			verifyLinks(url);	
		}
		
		//close browser
		driver.quit();
	}
	
	public static void verifyLinks(String linkURL) {
		
		try {
		URL url = new URL(linkURL);
		HttpsURLConnection httpURLConnect = (HttpsURLConnection)url.openConnection();
		httpURLConnect.setConnectTimeout(5000);
		httpURLConnect.connect();
		if(httpURLConnect.getResponseCode()!=200) {
			System.out.println(linkURL+" - "+ httpURLConnect.getResponseMessage()+" is a broken link");
		}
		else {
			System.out.println(linkURL+" - "+httpURLConnect.getResponseMessage()+" is a valid link");
		}
		}catch(Exception e) {
			
		}
		
	}
}
