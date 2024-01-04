package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class admin extends BaseClass {
	
	
	
	@And("Click on the Admin tab")
	public void clickAdminTab() {
		
		
		WebElement adminTab=driver.findElement(By.xpath("//a[@class='oxd-main-menu-item']"));
		try {
					
			adminTab.click();
					reportStep("The user is able to click on the Login Button", "Pass");
			}catch (Exception e) {
					System.out.println("Fail");
					reportStep("The user is not able to click on the login button", "fail");
			}
		
		
	}
	
	
	@Then("Verify the Admin Page")
	public void verifyAdminPage() {
		
		String adminTab=driver.findElement(By.className("oxd-topbar-header-breadcrumb-level")).getText();
		
		System.out.println(adminTab);

	if(adminTab.contains("User Management"))
	{
		reportStep("The Admin screen is displayed", "Pass");
	
	}
	else
	{
		reportStep("The Admin screen is not  displayed", "fail");
	}
	}

}
