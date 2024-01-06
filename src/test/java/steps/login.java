package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.login;

public class login extends BaseClass {

	

	
	@And("Enter the username as {string}")
	public  login  enterUsername(String uName) {
		
		WebElement eleUserName =driver.findElement(By.name("username"));
		
		try {
			eleUserName.sendKeys(uName);
			reportStep("The user is able to enter the Username", "Pass");
		} catch (Exception e) {
			System.out.println("Fail");
			reportStep("Username is not entered successfully", "fail");
		}
		return this;
	}
	
	@And("Enter the password as {string}")
	public login enterPassword(String pass) {
		
		WebElement elePassword= driver.findElement(By.name("password"));
		
		try {
			
			elePassword.sendKeys(pass);
			reportStep("The user is able to enter the Password", "Pass");
	}catch (Exception e) {
		System.out.println("Fail");
		reportStep("Password is not entered successfully", "fail");
	}
		 return this;
	}
	
	@When("Click on the Login button")
	public login login() {
		
		WebElement loginButton=driver.findElement(By.cssSelector(".oxd-button.orangehrm-login-button"));
try {
			
			loginButton.click();
			reportStep("The user is able to click on the Login Button", "Pass");
	}catch (Exception e) {
			System.out.println("Fail");
			reportStep("The user is not able to click on the login button", "fail");
	}
return this ;
	}
	
	@Then("Verify the dashboard")
	public void VerifyHOmepage() {
		
		String dash=driver.findElement(By.xpath("//span[text()='Dashboard']")).getText();
		
		System.out.println(dash);
	
	if(dash.equals("Dashboard"))
	{
		reportStep("The dashboard is displayed", "Pass");
	
	}
	else
	{
		reportStep("The dashboard is not  displayed", "fail");
	}
	}
	
	@But("Verify the invalid credentials message  is displayed")
	public void verifyErrorMessage() {
		
Boolean dash=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).isDisplayed();
		
		if (dash)
			//System.out.println("Invalid credentials");
		reportStep("Invalid credentials message is displayed", "Pass");
		else
		{
			//System.out.println("Invalid credentials message is not displayed");
			reportStep("Invalid credentials message is not displayed", "fail");
	}
		
	}
	
	@When("Click on the Forgotpassword link")
	public void verifyForgotPasswordLink()
	{
		WebElement Forgotpwlink= driver.findElement(By.className("orangehrm-login-forgot"));
		
		try {
			Forgotpwlink.click();
			reportStep("Forgot Password Link is clickable", "Pass");
			
		}
		catch (Exception e) {
			
			reportStep("Forgot Password Link is not clickable", "fail");
		}
	}
	
	@Then("Verify the Reset Password Page is displayed")
	public void resetPasswordPage() {
		
		
			
		
			try{
				String reset=driver.findElement(By.className("orangehrm-forgot-password-title")).getText();
				SoftAssert sa= new SoftAssert();
				sa.assertEquals(reset, "Reset Passwords");
			    sa.assertAll();
			    reportStep("Reset passwordpage is displayed", "Pass");
		}
		catch (Exception e) {
			
			// sa.fail("Reset passwordpage failed");
			reportStep("Reset passwordpage is not displayed", "Fail");
		
			
		}
}
	
	@And("Click on the ResetPassword Button")
	public void resetPasswordButton()
	{
	WebElement resetButton= driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']"));	
		
	try {
		
		resetButton.click();
		reportStep("The user is able to click on the Reset Button", "Pass");
		
	}
	catch (Exception e) {
		
		reportStep("The user is not able to click on the Reset Button", "fail");
		
	}
	}
	
	@Then("Verify the Reset Password sent Page is displayed")
	public void resetPasswordSucessPage() {
		
		String sucessMessage=driver.findElement(By.className("orangehrm-forgot-password-title")).getText();
		
		try {
		System.out.println(sucessMessage);
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(sucessMessage, "Reset Password link sent successfully");
		sa.assertAll();
		reportStep("Reset Password link sent to the user ", "Pass");
		}
		catch (Exception e) {
			
			reportStep("Reset Password link is not working  ", "fail");
		}
	}
}