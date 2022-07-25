package com.testleaf.pages;

import org.testng.Assert;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyHomePage extends ProjectSpecificMethods {

	@When("Click on {string} link")
	public void clickLeads(String text) {
		clickLinkText(text);
		// return new MyLeadsPage();
	}

	@Then("MyHome Page should be displayed")
	public void verifyMyHomePage() {

		boolean contains = getDriver().getTitle().contains(props.getProperty("MyHome_titleName"));
		Assert.assertTrue(contains);

	}

	@When("Click on Leads link")
	public LeadsPage clickLeads() {
		clickLinkText(props.getProperty("Leads_link-text"));
		return new LeadsPage();
	}

}