package com.testleaf.pages;

import org.openqa.selenium.By;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage extends ProjectSpecificMethods {

	public LoginPage clickLogout() {
		
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new LoginPage();
	}
	


	@Then("HomePage should be displayed")
	public HomePage verifyHomePage() {
		verifyPage(props.getProperty("Home_titleName"));
		return this;
		
	}
	public HomePage verifyLoginSucess() {
		String text = getDriver().findElement(By.tagName("h2")).getText();
		System.out.println(text);
		return this;
	}

	@When("Click on CRMSFA link")
	public MyHomePage clickCRMSFALink() {

		clickLinkText(props.getProperty("CRM/SFA_link-text"));
		return new MyHomePage();
	}

}