package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
		Boolean dash=driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
		
		if (dash)
			System.out.println("Dashboard displayed");
		else
		{
			System.out.println("Dashboard is not  displayed");
	}
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
}