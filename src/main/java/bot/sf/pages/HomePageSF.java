package bot.sf.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;


import bot.sf.utils.ProjectSpecificMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSF extends ProjectSpecificMethods {

	public HomePageSF createopp() throws InterruptedException {

		Actions builder = new Actions(getDriver());
		builder.moveToElement(getDriver().findElement(By.xpath("//button[contains(@class,'slds-icon-waffle')]")))
				.click().perform();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		builder.moveToElement(getDriver().findElement(By.xpath("//a[@title='Opportunities']/span"))).click().perform();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(5000);
		String userData = "Sales Force Automation By Hemanth M";
		if (getDriver().findElement(By.xpath("//div[@class='slds-modal__header']//h2")).isDisplayed()) {
			System.out.println("New Opprtunity Window is displayed");
			getDriver().findElement(By.xpath("//input[@name='Name']")).sendKeys(userData);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			String strDate = formatter.format(date);
			System.out.println("Date Format with MM/dd/yyyy : " + strDate + " is the date entered");
			getDriver().findElement(By.xpath("//div[@class='slds-modal__header']//h2"));
			getDriver().findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(strDate);
			getDriver().findElement(By.xpath(
					"//label[(text()='Stage')]/following-sibling::div[contains(@class,'slds-form-element__control')]"))
					.click();
			// java.time.LocalDate.now();
			builder.moveToElement(getDriver().findElement(By.xpath("//span[@title='Needs Analysis']"))).click()
					.perform();
			getDriver().findElement(By.xpath("//button[@name='SaveEdit']")).click();
			System.out.println(getDriver().findElement(By.xpath("//h1//slot//lightning-formatted-text")).getText());

		} else {

			System.out.println("New Opprtunities window is not displayed,Case failed");
		}

		return this;
	}

	@Given("User is on Home Page click on toggle menu from left corner")
	public HomePageSF loginAndSelectToggle() {
		getDriver().findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		getDriver().findElement(By.id("password")).sendKeys("Password@123");
		getDriver().findElement(By.id("Login")).click();
		getBuilder().moveToElement(getDriver().findElement(By.xpath("//button[contains(@class,'slds-icon-waffle')]")))
				.click().perform();
		return this;
	}

	@Given("Click view All and click Sales from App Launcher")
	public HomePageSF clickSales() throws InterruptedException {
		getDriver().findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		return this;
	}

	@Given("Click on Opportunity tab")
	public HomePageSF clickOnOpportunity() throws InterruptedException {
		getBuilder().moveToElement(getDriver().findElement(By.xpath("//a[@title='Opportunities']/span"))).click()
				.perform();
		Thread.sleep(5000);
		return this;
	}

	@Then("New Opprtunity page is opened")
	public HomePageSF newOpprtunityPage() {
		getDriver().findElement(By.xpath("//a[@title='New']")).click();
		if (getDriver().findElement(By.xpath("//div[@class='slds-modal__header']//h2")).isDisplayed()) {
			System.out.println("New Opprtunity Window is displayed");
			return this;
		} else {
			System.out.println("New opprtunity window is not displayed");
			return this;
		}

	}

	@Given("Enter Opprtunity Name as {string} and save the text")
	public HomePageSF enterOppName(String OppName) {
		getDriver().findElement(By.xpath("//input[@name='Name']")).sendKeys(OppName);
		return this;

	}

	@Given("select close date as today")
	public HomePageSF selectCloseDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println("Date Format with MM/dd/yyyy : " + strDate + " is the date entered");
		getDriver().findElement(By.xpath("//div[@class='slds-modal__header']//h2"));
		getDriver().findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(strDate);
		return this;

	}

	@Given("Select Stage as {string}")
	public HomePageSF selectStage(String stageValue) {
		getDriver().findElement(By.xpath(
				"//label[(text()='Stage')]/following-sibling::div[contains(@class,'slds-form-element__control')]"))
				.click();
		getBuilder().moveToElement(getDriver().findElement(By.xpath("//span[@title='" + stageValue + "']"))).click()
				.perform();
		return this;

	}

	@When("click on Save")
	public HomePageSF clickSave() {
		getDriver().findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return this;

	}

	@Then("Opprtunity Name is Verified as {string}")
	public HomePageSF opprtunityVerified(String verifyName) {
		if (getDriver().findElement(By.xpath("//h1//slot//lightning-formatted-text")).getText().equalsIgnoreCase(verifyName)) {
			System.out.println("opprtunity is created successfully");
			return this;

		} else {
			System.out.println("opprtunity is not created Properly");
			return this;

		}

	}
}
