package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login extends BaseClass {
	//public static ChromeDriver driver ;
	
	/*@Given("Launch the Browser")
	public void launchBrowser() {
		
			driver= new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
	}*/
	
	@And("Enter the username as {string}")
	public void enterUsername(String uName) {
		
		driver.findElement(By.name("username")).sendKeys(uName);

    }
	
	@And("Enter the password as {string}")
	public void enterPassword(String pass) {
		
		driver.findElement(By.name("password")).sendKeys(pass);
	}
	
	@When("Click on the Login button")
	public void login() {
		driver.findElement(By.cssSelector(".oxd-button.orangehrm-login-button")).click();
		
	}
	
	@Then("Verify the dashboard")
	public void VerifyHOmepage() {
		
		String dash=driver.findElement(By.xpath("//span[text()='Dashboard']")).getText();
		
		/*if (dash)
			System.out.println("Dashboard displayed");
		else
		{
			System.out.println("Dashboard is not  displayed");
	}*/
		
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(dash, "Dashboard");
		sa.assertAll();
}
	
	
	@But("Verify the dashboard is not displayed")
	public void verifyErrorMessage() {
		
Boolean dash=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed();
		
		if (dash)
			System.out.println("Invalid credentials");
		else
		{
			System.out.println("Invalid credentials message is not displayed");
	}
		
	}
	
	@When("Click on the Forgotpassword link")
	public void verifyForgotPasswordLink()
	{
		driver.findElement(By.className("orangehrm-login-forgot")).click();
		
	}
	
	@Then("Verify the Reset Password Page is displayed")
	public void resetPasswordPage() {
		
		String reset=driver.findElement(By.className("orangehrm-forgot-password-title")).getText();
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(reset, "Reset Password");
		sa.assertAll();
}
	
	@And("Click on the ResetPassword Button")
	public void resetPasswordButton()
	{
	driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']")).click();	
		
	}
	
	@Then("Verify the Reset Password sent Page is displayed")
	public void resetPasswordSucessPage() {
		
		String sucessMessage=driver.findElement(By.className("orangehrm-forgot-password-title")).getText();
		System.out.println(sucessMessage);
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(sucessMessage, "Reset Password link sent successfully");
		sa.assertAll();
	}
}