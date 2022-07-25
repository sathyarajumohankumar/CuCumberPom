package com.testleaf.pages;

public class FindLeadPage {

}
package com.testleaf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindLeadsPage extends ProjectSpecificMethods {

	public static String firstLead;
	@Then("Find Leads Page should be displayed")
	public void verifyFindLeadPage() {
		verifyPage(props.getProperty("FindLeads_titleName"));
	}

	@When("Click on the Phone link")
	public FindLeadsPage clickOnPhone() {
		getDriver().findElement(By.xpath(props.getProperty("Phone_xpath"))).click();
		return this;
	}

	@When("Enter phone number")
	public FindLeadsPage enterPhoneNumber() {
		getDriver().findElement(By.xpath("//div[@class='x-plain-bwrap']//input[@name='phoneNumber']")).sendKeys("99");
		return this;
	}

	@Then("Phone Number text field should be displayed")
	public FindLeadsPage verifyField() {
		boolean displayed = getDriver().findElement(By.xpath("//div[@class='x-plain-bwrap']//input[@name='phoneNumber']"))
				.isDisplayed();
		Assert.assertTrue(displayed);
		return this;

	}
	
	@And("Click on Find Leads button")
	public FindLeadsPage clickFindLeads() {
		getDriver().findElement(By.xpath(props.getProperty("FindLeadsButton_xpath"))).click();
		return this;

	}

	@Then("Lead List should be displayed")
	public FindLeadsPage verifyLeadList() {
		boolean displayed = getDriver().findElement(By.xpath("//span[text()='Lead List']")).isDisplayed();
		Assert.assertTrue(displayed);
		return this;

	}
	
	@When("Click on first lead")
	public ViewLeadsPage clickFirstResultingLead() {
		// Capture lead ID of First Resulting lead
		WebElement eleFirstLead = getDriver().findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]"));
		firstLead = eleFirstLead.getText();

		// Click First Resulting lead
		eleFirstLead.click();
		return new ViewLeadsPage();
	}

	@And("Enter lead id")
	public FindLeadsPage enterLeadID() {
		getDriver().findElement(By.name("id")).sendKeys(firstLead);
		return this;
	}

	@Then("Lead should not be displayed")
	public FindLeadsPage verifyLeadDisplayed() throws InterruptedException {
		// Verify message "No records to display" in the Lead List
		Thread.sleep(3000);
		String displayedText = getDriver().findElement(By.xpath("//div[@class ='x-paging-info']")).getText();
		System.out.println(displayedText);
		return this;
	}

	@When("Click on Email")
	public FindLeadsPage clickOnEmail() {
		getDriver().findElement(By.xpath("//span[text()='Email']")).click();
		return this;
	}

	@Then("Email field should be displayed")
	public FindLeadsPage verifyEmailField() {
		Assert.assertTrue(getDriver().findElement(By.name("emailAddress")).isDisplayed());
		return this;
	}
	
	@When("Enter email as {string}")
	public FindLeadsPage enterEmail(String email) {
		getDriver().findElement(By.name("emailAddress")).sendKeys(email);
		return this;
	}

	@When("Enter firstName as {string}")
	public FindLeadsPage enterFirstName(String fName) {
		getDriver().findElement(By.xpath("//div[@id='findLeads']//input[@name='firstName']")).sendKeys(fName);
		return this;

	}

}