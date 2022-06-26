package bot.sf.pages;

import org.openqa.selenium.By;

import bot.sf.base.BaseSF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSF extends BaseSF {

	public HomePageSF enterCreditianls() {
		
		getDriver().findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		getDriver().findElement(By.id("password")).sendKeys("Password@123");
		getDriver().findElement(By.id("Login")).click();
		return new HomePageSF();
	}
	
	
	@Given("User is in Login Page")
	public LoginSF LPIsDisplayed() {
		
		if(getDriver().getTitle().contains("Login | Salesforce")) {
			System.out.println("Sales Force Login Page is displayed");
			
			return this;
		}
		else {
			System.out.println("Wrong login page is displayed");
	
			return this;
		}
	}

	@Given("User Enter Username as {string}")
	public LoginSF enterUserName(String uName) {
		getDriver().findElement(By.id("username")).sendKeys(uName);

		return this;
	    
	}

	@Given("User Enter Password as {string}")
	public LoginSF enterPwd(String pwd) {
		getDriver().findElement(By.id("password")).sendKeys(pwd);

		return this;
	   
	}

	@When("User clicks on Login")
	public LoginSF clickOnLogin() {
	getDriver().findElement(By.id("Login")).click();

	return this;
	}

	@Then("Home page is displayed")
	public HomePageSF homePageDisplayed() {
	if(getDriver().getTitle().contains("Home | Salesforce")) {
		System.out.println("Home Page is displayed successfully");

	}
	else 
	{
		System.out.println("Home Page is not displayed,creditinals are wrong or Home page title is different");
	
	}
	return new HomePageSF();
	}
	
	
	
	
}
