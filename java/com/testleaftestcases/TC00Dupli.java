package com.testleaftestcases;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testleaf.base.ProjectSpecificMethods;
import com.testleaf.pages.LoginPage;

public class TC00Dupli extends ProjectSpecificMethods{

	@BeforeTest
	public void setFileName() {
		fileName="duplicateLead";
		
	}
	@Test(dataProvider="getData")
	public void runDuplicateLead(String email) throws InterruptedException {
		new LoginPage()
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickCRMSFALink()
		.clickLeads()
		.clickFindLeads()
		.clickOnEmail()
		.enterEmail(email)
		.clickFindLeads()
		.clickFirstResultingLead()
		.getLeadName()
		.clickDuplicateLead()
		.clickCreateLead()
		.verifyDupLeadName();
	}
}