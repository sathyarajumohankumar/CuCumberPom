package com.testleaf.pages;

import org.openqa.selenium.By;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPage extends ProjectSpecificMethods {

	
	public void verifyLoginPage() {
		
	}
	
	@Given("Enter username")
	public LoginPage enterUserName() {
		getDriver().findElement(By.id("username")).sendKeys(props.getProperty("username"));
		return this;
	}
	
	@Given("Enter password")
	public LoginPage enterPassword() {
		getDriver().findElement(By.id("password")).sendKeys(props.getProperty("password"));
		return this;
	}
	
	@Given("Enter username as {string}")
	public LoginPage enterUserName(String uName) {
		getDriver().findElement(By.id("username")).sendKeys(uName);
		return this;
	}
	
	@Given("Enter password as {string}")
	public LoginPage enterPassword(String pwd) {
		getDriver().findElement(By.id("password")).sendKeys(pwd);
		return this;
	}

	@When("Click on Login button")
	public HomePage clickLogin() {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new HomePage();

	}

	@But("Error message should be displayed")
	public LoginPage verifyErrorMessage() {

		boolean displayed = getDriver().findElement(By.id("errorDiv")).isDisplayed();
		if (displayed)
			System.out.println(getDriver().findElement(By.xpath("//div[@id='errorDiv']/p[2]")).getText());
		else
			System.out.println("Error message not displayed");
		
		return this;

	}
}