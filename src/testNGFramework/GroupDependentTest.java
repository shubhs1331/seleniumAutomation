package testNGFramework;

import org.testng.annotations.Test;
/*
 * Output Before dependsOnMethod
 * Inside Login Method
 * Inside Logout Method
 * Inside Open Browser Method
 * Inside viewDashBoard Method
 * 
 * Output After dependsOnMethods
 * Inside Open Browser Method
 * Inside Login Method
 * Inside viewDashBoard Method
 * Inside Logout Method
 */
public class  GroupDependentTest{
	
  @Test(groups = {"signIn"})
  public void openBrowser() {
	  System.out.println("Inside Open Browser Method");
  }
  
  @Test(dependsOnMethods= {"openBrowser"}, groups = {"signIn"})
  public void logIn() {
	  System.out.println("Inside Login Method");
  }
  
  @Test(dependsOnGroups = {"signIn"})
  public void viewDashBoard() {
	  System.out.println("Inside View Dashboard Method");
  }
  
  @Test(dependsOnMethods= {"viewDashBoard"})
  public void logOut() {
	  System.out.println("Inside Logout Method");
  }
}
