
package com.testleaf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadPage extends ProjectSpecificMethods {

	public WebElement eleCompanyName;
	
	@Then("Edit Lead Page should be displayed")
	public void verifyEditLeadPage()
	{
		
		Assert.assertEquals(getDriver().getTitle(), props.getProperty("EditLead_titleName"));
		
		
	}
	@When("Clear company name")
	public EditLeadPage clearCompName() {

		eleCompanyName = getDriver().findElement(By.id("updateLeadForm_companyName"));

		eleCompanyName.clear();
		return this;

	}
	
	@Then("Company name should be cleared")
	public EditLeadPage verifyClear() {

		boolean equals = eleCompanyName.getText().equals("");
		Assert.assertTrue(equals);
		return this;
	}
	
	@When("Update company name to {string}")
	public EditLeadPage enterCompName(String cName) {
		eleCompanyName.sendKeys(cName);
		return this;
	}
	
	@When("Click on Update button")
	public ViewLeadsPage clickUpdate() throws InterruptedException {
		getDriver().findElement(By.xpath(props.getProperty("UpdateButton_xpath"))).click();
		Thread.sleep(3000);
		return new ViewLeadsPage();
	}
	
}