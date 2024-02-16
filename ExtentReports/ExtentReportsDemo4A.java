package ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportsDemo4A
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest childextentLogger;
	public static ExtentTest parentExtentLogger;

	@Test
	public void ExtentReport() 

	{

		htmlReporter=new ExtentHtmlReporter("C:\\Users\\admin\\Desktop\\ExtentReports\\test4A.html");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		parentExtentLogger=extent.createTest("login function flow");

		childextentLogger=parentExtentLogger.createNode("valid credentails");
		childextentLogger.log(Status.PASS,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREEN));
		childextentLogger=parentExtentLogger.createNode("invalid credentails");
		childextentLogger.log(Status.FAIL,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.RED));

		parentExtentLogger=extent.createTest("login customer");
		childextentLogger=parentExtentLogger.createNode("valid credentails");
		childextentLogger.log(Status.SKIP,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREY));
		childextentLogger=parentExtentLogger.createNode("invalid credentails");
		childextentLogger.log(Status.SKIP,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREEN));

		extent.flush();
		System.out.println("Done"); 





	}
}
