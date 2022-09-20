package testNGFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/*
 * This will execute in this order irrespective of the methods written in 
 * whichever order
 * @BeforeSuite 
 * @BeforeTest
 * @BeforeClass
 * @BeforeMethod
 * @Test
 * @AfterMethod
 * @AfterClass
 * @AfterTest
 * @AfterSuite
 */
public class TestNGAnnotationsDemo {
	
	@Test
	public void testTwo() {
		System.out.println("Inside Test Two");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside After Method executed after each Test");
	}
	
	@Test
	public void testOne() {
		System.out.println("Inside Test One");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method executed before each Test");
	}

	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside Before Class Method");
	}
	
	@Test
	public void testThree() {
		System.out.println("Inside Test Three");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Inside After Class Method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside Before Test Method");
	}
	
	/*To run this method put this class inside testng.xml file and after execution
	of all Tests in Suite, this method will run*/
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside After Suite Method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Inside After Test Method");
	}
	
	@BeforeSuite
		public void beforeSuite() {
			System.out.println("Inside Before Suite Method");
		}

}
