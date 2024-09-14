package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	//1. Custructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
		
		
	//2. Locator
		@FindBy(xpath="//input[@id='input-firstname']")
		WebElement txtFirstname;
		
		@FindBy(xpath="//input[@id='input-lastname']")
		WebElement txtLastname;
		
		@FindBy(xpath="//input[@id='input-email']")
		WebElement txtEmail;
		
		@FindBy(xpath="//input[@id='input-telephone']")
		WebElement txtTelephone;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement txtpassword;
		
		@FindBy(xpath=" //input[@id='input-confirm']")
		WebElement txtPasswordConfirm;
		
		
		@FindBy(xpath="//input[@name='agree']")
		WebElement chkPrivatePolicy;
		
		
		@FindBy(xpath="//input[@value='Continue']")
		WebElement btncontinue;
		
		@FindBy(xpath="//div[@id='content']//h1")
		WebElement msgConfirmation;
		
		
		
		//Actions
		
		public void setFirstName(String fname)
		{
			txtFirstname.sendKeys(fname);
		}
			
		public void setLastName(String Lname)
		{
			txtLastname.sendKeys(Lname);
		}
		
		public void setEmail(String email) 
		{
			txtEmail.sendKeys(email);
		}
			
		public void setTelephone(String telephone) 
		{
			txtTelephone.sendKeys(telephone);
		}
		
		public void setPassword(String pwd)
		{
			txtpassword.sendKeys(pwd);
		}
		
		public void setPasswordconfirm(String pwd)
		{
			txtPasswordConfirm.sendKeys(pwd);
		}
		
		public void clickPrivatePolicy()
		{
		chkPrivatePolicy.click();
		}
		
		
		public void clickContiune()
		{
			btncontinue.click();
		}
		
		public String getConfirmationMsg()
		{
			try {
			return (msgConfirmation.getText());
			}
			catch(Exception e)
			{
			return (e.getMessage());
			}
			
		}
	}
	
	
	


