package ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportsDemo2
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest childextentLogger;
	public static ExtentTest parentExtentLogger;

	@Test
	public void ExtentReport() 

	{
		
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\admin\\Desktop\\ExtentReports\\test2.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		parentExtentLogger=extent.createTest("test2");
		childextentLogger=parentExtentLogger.createNode("senario1");
		childextentLogger.log(Status.PASS,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREEN));
		
		childextentLogger.log(Status.FAIL,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.RED));

		extent.flush();
		System.out.println("Done"); 
		
		
		
//		htmlReporter = new ExtentHtmlReporter("C:\\Users\\admin\\Desktop\\ExtentReport‪\\test1.html");
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//		parentExtentLogger = extent.createTest("Test1");
//		childextentLogger = parentExtentLogger.createNode("Senario1");
//		extent.flush();
//		System.out.println("Done");

	}
}
