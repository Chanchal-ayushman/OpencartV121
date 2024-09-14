package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	@Test(groups= {"Regression"})
	public void verify_account_registration() throws InterruptedException 
	{
		logger.info("*****Starting TC001_AccountRegistrationTest *****");
		
		
		try
		{
	
		HomePage hp1= new HomePage(driver);
		Thread.sleep(5000);
		hp1.clickMyAccount();
		Thread.sleep(5000);
		
		hp1.clickRegister();
		
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		Thread.sleep(5000);
		regPage.setFirstName("Chanchal");
		regPage.setLastName("Singh");
		regPage.setEmail(radomString()+"@yopmail.com");
		regPage.setTelephone(randomNumber());
		Thread.sleep(5000);
		
		String pwd=randomAplbhanumeric();
		regPage.setPassword(pwd);
		regPage.setPasswordconfirm(pwd);
		
		
		regPage.clickPrivatePolicy();
		regPage.clickContiune();
		
		logger.info("Validate expected Message");
		String confmsg=regPage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debugs Logs.......");
			Assert.assertTrue(false);
		}
		}
		
		catch(Exception e)
		{
		
			Assert.fail();
		}
		
		logger.info("*****Finish TC001_AccountRegistrationTest *****");
		
		
	

	}
	
	
	

}
