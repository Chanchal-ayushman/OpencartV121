package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		Thread.sleep(5000);
		logger.info("*****Starting TC003_LoginDDT_Test *****");
		try
		{
		HomePage hp1= new HomePage(driver);
		Thread.sleep(5000);
		hp1.clickMyAccount();
		Thread.sleep(5000);
		hp1.clickLogin();
		Thread.sleep(5000);
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(pwd);
		Thread.sleep(5000);
		lp.clickLogin();
		
		
		MyAccountPage ap= new MyAccountPage(driver);
		boolean targetPage=ap.isMyAccountPageExists();
		
		
		/*
		 
		 Data is valid----- login success---- test pass-----logout
		 Data is valid ----login failed------- test fail----
		 
		 
		 Data is invalid--- login success----  test failed ----logout
		 Data is invalid---- login failed--------test pass------
		 
		 */
		
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				ap.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				ap.clickLogout();
				Assert.assertTrue(false);
			}
			else
				Assert.assertTrue(true);
				
		}
		
		
		
		
		
	 
		}
		catch(Exception e)
		{
				
			Assert.fail();
			
		}
		
		logger.info("*****Finish TC003_LoginDDT_Test *****");
	}
	
	

}
