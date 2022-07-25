package com.testleaftestcases;



import org.testng.annotations.Test;

import com.testleaf.base.ProjectSpecificMethods;
import com.testleaf.pages.LoginPage;

public class TC00Merge extends ProjectSpecificMethods {

	@Test
	public void runMergeLeads() throws InterruptedException {
		new LoginPage()
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickCRMSFALink()
		.clickLeads()
		.clickMerge()
		.clickFromLeadToMerge()
		.clickToLeadToMerge()
		.clickMergeLink()
		.getLeadName();
		
		
	}
}