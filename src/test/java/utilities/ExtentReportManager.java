package utilities;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	String repName;
	
	 public void onStart(ITestContext testcontext) {
		    // not implemented
		 
		 /* SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Date dt= new Date();
		 String timeStamp=df.format(df);
		 */
		 
		 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 
		 
		 //Given ReportName
		 repName= "Test-Report" + timeStamp +".html";
		 sparkReporter=  new ExtentSparkReporter(".\\reports\\ " +repName);
		 sparkReporter.config().setDocumentTitle("OpenCart Automation Report");	
		 sparkReporter.config().setReportName("OpenCart Functional Testing");
		 sparkReporter.config().setTheme(Theme.DARK);
		
		 
		 
		 extent= new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 extent.setSystemInfo("Application", "OpenCart");
		 extent.setSystemInfo("Module", "Admin");
		 extent.setSystemInfo("UserName", System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 
		 String browser= testcontext.getCurrentXmlTest().getParameter("browser");
		 extent.setSystemInfo("Bowser", browser);
		 
		 List<String> includedGroups= testcontext.getCurrentXmlTest().getIncludedGroups();
		 if(!includedGroups.isEmpty())
		 {
			extent.setSystemInfo("Groups", includedGroups.toString());
		 }
	 
		 }
		 
		 
		 
		 
		  public void onTestSuccess(ITestResult result) {
		   
			  test=extent.createTest(result.getTestClass().getName());
			  test.assignCategory(result.getMethod().getGroups());
			  test.log(Status.PASS,result.getName()+" got successfull executed");
			  
			
		  }
		  
		  
		  
		  
		  public void onTestFailure(ITestResult result) {
		 
			  
			  test=extent.createTest(result.getTestClass().getName());
			  test.assignCategory(result.getMethod().getGroups());
			  
			  test.log(Status.FAIL,result.getName()+" got failed");
			  test.log(Status.INFO, result.getThrowable().getMessage());
			  
			  String impath=new BaseClass().captureScreen(result.getName());
			  test.addScreenCaptureFromPath(impath);
		  }

		  
		  public void onTestSkipped(ITestResult result) {
		   
			  test=extent.createTest(result.getTestClass().getName());
			  test.assignCategory(result.getMethod().getGroups());
			  
			  test.log(Status.SKIP,result.getName()+" got Skipped");
			  test.log(Status.INFO, result.getThrowable().getMessage());
			  
		  }

		  
		 
		  public void onFinish(ITestContext context) {
		    
			  extent.flush();
		  }
	
	
	

}
