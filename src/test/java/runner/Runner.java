package runner;


import org.testng.annotations.BeforeTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.BaseClass;

@CucumberOptions(features="src/test/java/Features/admin.feature",
				 glue={"steps"},
				 monochrome=true,
				tags="@Smoke"

				 )

public class Runner extends BaseClass{
	

	@BeforeTest
	public void setData()
{
	testName="Admin Page";
	testDesc="Verify the Admin page ";
	testCategory="Functionality";
	testAuthor="Manjula";
	
}	

	
	
}
