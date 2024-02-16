package ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportsDemo4
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest childextentLogger;
	public static ExtentTest parentExtentLogger;

	@Test
	public void ExtentReport() 

	{
		
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\admin\\Desktop\\ExtentReports\\test4.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		parentExtentLogger=extent.createTest("test1");
		childextentLogger=parentExtentLogger.createNode("senario1");
		childextentLogger.log(Status.PASS,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREEN));
		childextentLogger=parentExtentLogger.createNode("senario2");
		childextentLogger.log(Status.FAIL,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.RED));
		
		
		parentExtentLogger=extent.createTest("test2");
		childextentLogger=parentExtentLogger.createNode("senario1");
		childextentLogger.log(Status.SKIP,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREY));
		childextentLogger=parentExtentLogger.createNode("senario2");
		childextentLogger.log(Status.SKIP,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREEN));

		extent.flush();
		System.out.println("Done"); 
		
		
		


	}
}
