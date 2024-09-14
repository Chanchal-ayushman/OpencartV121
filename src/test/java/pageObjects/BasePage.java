package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;  //class type variable
	
	//create Constructor to PageFactory

	  public BasePage(WebDriver driver) 
		  
		  {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		  }
}
