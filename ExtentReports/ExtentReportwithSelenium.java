package ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportwithSelenium 
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest childextentLogger;
	public static ExtentTest parentExtentLogger;

	
	@Test
	public void extentreporttest() throws IOException, InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(5000);
	TakesScreenshot screenshort=(TakesScreenshot)driver;
	File source=screenshort.getScreenshotAs(OutputType.FILE);
	File target=new File("C:\\Users\\admin\\Desktop\\ScreenShorts\\screen1.png");
	FileUtils.copyFile(source, target);

	htmlReporter=new ExtentHtmlReporter("C:\\Users\\admin\\Desktop\\ExtentReports\\extentreportwithselenium.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	parentExtentLogger=extent.createTest("test1");
	childextentLogger=parentExtentLogger.createNode("senario1");
	childextentLogger.pass("",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\admin\\Desktop\\ExtentReports\\extentreportwithselenium.html").build());
	extent.flush();
	System.out.println("Done"); 
	
	}

}
