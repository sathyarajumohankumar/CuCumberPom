package com.testleaftestcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testleaf.base.ProjectSpecificMethods;
import com.testleaf.pages.LoginPage;

public class Tc00Edit extends ProjectSpecificMethods {

	@BeforeTest()
	public void setFileName() {
		fileName = "editLead";
	}

	@Test(dataProvider = "getData")
	public void runEditLead(String fName,String compName) throws InterruptedException {
		new LoginPage()
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickCRMSFALink()
		.clickLeads()
		.clickFindLeads()
		.enterFirstName(fName)
		.clickFindLeads()
		.clickFirstResultingLead()
		.clickEdit()
		.clearCompName()
		.verifyClear()
		.enterCompName(compName)
		.clickUpdate()
		.verifyUpdate(compName);
	}
}