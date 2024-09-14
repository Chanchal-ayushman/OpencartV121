package testCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JustChecking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
			
		
		Thread.sleep(6000);
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//span[text()='My Account']")).click();	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
//	driver.findElement(By.linkText("Register")).click();
		
		
		
		
	}

}
