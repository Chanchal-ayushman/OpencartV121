package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_Logintest extends BaseClass {
	
	@Test(groups= {"Sanity"})
	public void verify_Login() throws InterruptedException
	{
		logger.info("*****Starting TC002_Login_Test *****");
		try
		{
		HomePage hp1= new HomePage(driver);
		Thread.sleep(5000);
		hp1.clickMyAccount();
		Thread.sleep(5000);
		hp1.clickLogin();
		Thread.sleep(5000);
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		Thread.sleep(5000);
		lp.clickLogin();
		
		
		MyAccountPage ap= new MyAccountPage(driver);
		boolean targetPage=ap.isMyAccountPageExists();
		 
		Assert.assertTrue(targetPage);
	 
		}
		catch(Exception e)
		{
				
			Assert.fail();
			
		}
		
		logger.info("*****Finish TC002_Login_Test *****");
	}
}
		
	


