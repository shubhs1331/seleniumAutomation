package testNGFramework;

import org.testng.annotations.Test;
/*
 * Group dependencies are added in XMLDependentTestNG.xml file
 */
public class  XMLDependentTest{
	
  @Test(groups= {"openbrowser"})
  public void openBrowser() {
	  System.out.println("Inside Open Browser Method");
  }
  
  @Test(groups= {"login"})
  public void logIn() {
	  System.out.println("Inside Login Method");
  }
  
  @Test(groups= {"viewdashboard"})
  public void viewDashBoard() {
	  System.out.println("Inside View Dashboard Method");
  }
  
  @Test(groups= {"logout"})
  public void logOut() {
	  System.out.println("Inside Logout Method");
  }
}
