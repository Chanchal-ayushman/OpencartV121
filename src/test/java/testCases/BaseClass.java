package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;  //To generate random String alphabet and number

import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;      //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass (groups= {"Sanity", "Regression", "Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException 
	{
		//Loading config.properties file
		FileReader file=new FileReader("./config.properties");
		p=new Properties();
		p.load(file);
		
		
		//Log4j
		logger=LogManager.getLogger(this.getClass());
		
		switch(browser)
		{
		case "chrome"   : driver=new ChromeDriver(); break;
		case "edge"     : driver=new EdgeDriver(); break;
		case "firefox"  : driver=new FirefoxDriver(); break;
		default: System.out.println("Invalid Browser Name"); return;
		
		}
		
		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	
	
	/*@AfterClass(groups= {"Sanity", "Regression", "Master"})
	public void tearDown()
	{
	driver.quit();	
	}  
	*/
	
	
	
	
	public String radomString() 
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		
				return generateString;
	}
	
	public String randomNumber()
	{
		String genrerateNumber=RandomStringUtils.randomNumeric(6);
	    return genrerateNumber;	
	}
	
	public String randomAplbhanumeric()
	{
		String generateString=RandomStringUtils.randomAlphabetic(4);
		String generateNumber=RandomStringUtils.randomNumeric(4);
		return(generateString+"@"+generateNumber);
	}
	
	
	public String captureScreen(String tname)
	{
		String timeStamp= new SimpleDateFormat("yyyyMMhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+ "\\screenshots\\" + tname + "_" +	timeStamp + ".png";	
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
		
		
	}

}
