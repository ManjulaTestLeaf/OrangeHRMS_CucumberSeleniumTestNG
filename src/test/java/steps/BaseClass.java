package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests {

	public static ChromeDriver driver;
	public ExtentReports extent;
	public String testName, testDesc, testCategory, testAuthor;
	public static ExtentTest test, node;
	
	@BeforeMethod
	public void preCondition() {
		
		
		driver= new ChromeDriver();
		node = test.createNode(testName);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
@AfterMethod
	public void postCondition() {
		
		driver.close();
	}

@BeforeSuite
	public void startReport() {
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	reporter.setAppendExisting(true);
}

@AfterSuite
public void stopReport() {
	extent.flush();
}



@BeforeClass
public void testDetails() {
		test = extent.createTest(testName,testDesc);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
}

public void reportStep(String message, String status) {
if(status.equalsIgnoreCase("Pass")) {

	node.pass(message);
	
	}
	else if(status.equalsIgnoreCase("fail")) {
	node.fail(message);
	
		}
			
}

}




	