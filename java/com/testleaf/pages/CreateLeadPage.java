package com.testleaf.pages;

import org.openqa.selenium.By;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadPage extends ProjectSpecificMethods {
	@Then("Create Lead Page should be displayed")
	public void verifyCreateLeadPage() {
		verifyPage(props.getProperty("CreateLead_titleName"));
		
	}
	@When("Enter Company name as {string}")
	public CreateLeadPage enterCompanyName(String cName) {
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		return this;
	}
	@When("Enter First name as {string}")
	public CreateLeadPage enterFirstName(String fName) {
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		return this;
	}
	@When("Enter Last name as {string}")
	public CreateLeadPage enterLastName(String lName) {
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		return this;
	}
	@When("Click on create lead button")
	public ViewLeadsPage clickCreateLead() {
		getDriver().findElement(By.name("submitButton")).click();
		return new ViewLeadsPage();
	}
