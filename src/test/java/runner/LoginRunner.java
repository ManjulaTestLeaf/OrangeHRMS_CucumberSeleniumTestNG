package runner;


import org.testng.annotations.BeforeTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.BaseClass;

@CucumberOptions(features="src/test/java/Features/login.feature",
				 glue={"steps"},
				 monochrome=true,
				tags="@Smoke"

				 )

public class LoginRunner extends BaseClass{
	
	@BeforeTest
	public void setData()
{
	testName="Login Page and Password Reset Link";
	testDesc="Verify the Login page ";
	testCategory="Functionality";
	testAuthor="Manjula";
	
}	
	
	
	
}
