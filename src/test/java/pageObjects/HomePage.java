package pageObjects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	
	// To Create Page Object Class we need three things: constructor, Locator and Action
	
     //1. Here calling the BasePage Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	
	}
	
	//2. Create Locator
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	
	//3. Action
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	
	
	
	
	
	

	
	}


