package testNGFramework;

import org.testng.annotations.Test;
/*
 * Output Before dependsOnMethod
 * Inside Login Method
 * Inside Logout Method
 * Inside Open Browser Method
 * 
 * Output After Multiple dependsOnMethods usage
 * Inside Login Method
 * Inside Open Browser Method
 * Inside Logout Method
 */
public class  MultipleDependentTest{
	
  @Test
  public void openBrowser() {
	  System.out.println("Inside Open Browser Method");
  }
  
  @Test(dependsOnMethods = {"logIn","openBrowser"})
  public void logOut() {
	  System.out.println("Inside Logout Method");
  }
  
  @Test
  public void logIn() {
	  System.out.println("Inside Login Method");
  }
  
}
