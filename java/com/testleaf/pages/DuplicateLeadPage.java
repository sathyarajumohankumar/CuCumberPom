package com.testleaf.pages;

import org.openqa.selenium.By;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuplicateLeadPage extends ProjectSpecificMethods {
	@Then("Duplicate Lead Page should be displayed")
	public void verifyduplicateLeadPage() {
		verifyPage(props.getProperty("DuplicateLead_titleName"));
	}
	
	@When("Click on Create Lead button")
	public ViewLeadsPage clickCreateLead() throws InterruptedException {
		getDriver().findElement(By.xpath("//input[@value='Create Lead']")).click();
		Thread.sleep(3000);
		return new ViewLeadsPage();
	}
}
