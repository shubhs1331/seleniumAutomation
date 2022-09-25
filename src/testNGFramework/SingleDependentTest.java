package testNGFramework;

import org.testng.annotations.Test;
/*
 * Output Before dependsOnMethod
 * Inside Login Method
 * Inside Logout Method
 * Inside Open Browser Method
 * 
 * Output After dependsOnMethods
 * Inside Open Browser Method
 * Inside Login Method
 * Inside Logout Method
 */
public class  SingleDependentTest{
	
  @Test
  public void openBrowser() {
	  System.out.println("Inside Open Browser Method");
  }
  
  @Test(dependsOnMethods = {"openBrowser"})
  public void logIn() {
	  System.out.println("Inside Login Method");
  }
  
  @Test(dependsOnMethods = {"logIn"})
  public void logOut() {
	  System.out.println("Inside Logout Method");
  }
}
