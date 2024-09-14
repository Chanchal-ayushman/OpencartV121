package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	//contructor
		public MyAccountPage(WebDriver driver)
		{
			super(driver);
		}

		
   //Constructor
		@FindBy(xpath="//h2[normalize-space()='My Account']")
		WebElement msgHeading;
		
		@FindBy(linkText="Logout")
		WebElement linkLogout;
		
		
  //Actions
		public boolean isMyAccountPageExists()
		{
			try
			{
			return(msgHeading.isDisplayed());
			}
			catch(Exception e)
			{
			return false;
			}
		  
			
		}
		
		
		public void clickLogout()
		{
			linkLogout.click();
		}
		
		
}
