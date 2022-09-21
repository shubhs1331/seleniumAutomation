package testNGFramework;

import org.testng.annotations.Test;

/*
 * Without priority it will run in this order
 * testFour, testOne, testThree, testTwo
 */

public class TestNGPriorityDemo {
	
	@Test(priority=2)
	public void testTwo() {
		System.out.println("Inside Test Two");
	}
	
	
	@Test(priority = 1)
	public void testOne() {
		System.out.println("Inside Test One");
	}
	
	
	@Test(priority=1)
	public void testThree() {
		System.out.println("Inside Test Three");
	}
	
	
	@Test(priority=3)
	public void testFour() {
		System.out.println("Inside Test Four");
	}

}
