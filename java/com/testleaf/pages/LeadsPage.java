package com.testleaf.pages;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadsPage extends ProjectSpecificMethods{

	@Then("MyLeads Page should be displayed")
	public void verifyMyLeadsPage() {
		verifyPage(props.getProperty("MyLeads_titleName"));
	}
	
	@When("Click on Create Lead Link")
	public CreateLeadPage clickCreateLead() {
		clickLinkText(props.getProperty("Create_Lead_link-text"));
		return new CreateLeadPage();
	}

	@When("Click on Find Leads link")
	public FindLeadsPage clickFindLeads() {
		clickLinkText(props.getProperty("Find_Leads_link-text"));
		return new FindLeadsPage();
	}

	@When("Click on Merge Leads link")
	public MergeLead clickMergeLeads() {
		clickLinkText(props.getProperty("Merge_Leads_link-text"));
		return new MergeLead();
	}
	
	
	
	
	

}