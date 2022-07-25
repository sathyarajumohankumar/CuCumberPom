package com.testleaf.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testleaf.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLead extends ProjectSpecificMethods {

	public static String parentWindow;
	public Alert alert;

	@Then("Merge Leads Page should be displayed")
	public MergeLead verifyMergeLeadsPage() {
	  verifyPage(props.getProperty("MergeLeads_titleName"));
		return this;
	}
	
	public void getParentWindow() {
		// get parent window handle
		parentWindow = getDriver().getWindowHandle();
	}

	@When("Click From lead")
	public MergeLead clickFromLead() {
		// click from lead
		getDriver().findElement(By.xpath("//span[text()='From Lead']/ancestor::tr//img")).click();
		return this;
	}

	@When("Select {string} lead")
	public MergeLead selectLeads(String str) throws InterruptedException {
		selectLead(Integer.parseInt(str));
		return this;
	}

	@When("Click To lead")
	public MergeLead clickToLead() {
		// click to lead
		getDriver().findElement(By.xpath("//span[text()='To Lead']/ancestor::tr//img")).click();
		return this;
	}

	@Then("Confirmation alert should be displayed")
	public MergeLead confirmAlert() {
		alert = getDriver().switchTo().alert();
		return this;
	}

	@When("Click ok in alert")
	public ViewLeadPage acceptAlert() throws InterruptedException {
		alert.accept();
		Thread.sleep(3000);
		return new ViewLeadPage();

	}

	public MergeLead selectLead(int i) throws InterruptedException {

		WebElement eleLeadId = getDriver().findElement(By.xpath("(//table[@class='x-grid3-row-table'])[" + i + "]//a"));
		System.out.println(eleLeadId.getText());

		if (eleLeadId.isEnabled())
			eleLeadId.click();
		// switch to parentWindow
		getDriver().switchTo().window(parentWindow);
		return this;
	}

	@Then("Find Leads page should open in new window")
	public MergeLead switchWindow() {
		getParentWindow();
		Set<String> windowHandles = getDriver().getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		getDriver().switchTo().window(windows.get(1));
		return this;
	}

	@When("Click on Merge link")
	public MergeLead clickMerge() {
		clickLinkText(props.getProperty("Merge_link-text"));
		return this;
	}
	
	public MergeLead clickFromLeadToMerge() throws InterruptedException {
		parentWindow = getDriver().getWindowHandle();
		getDriver().findElement(By.xpath("//span[text()='From Lead']/ancestor::tr//img")).click();
		selectLeadToMerge(1);
		return this;
	}

	private void selectLeadToMerge(int i) throws InterruptedException {
		// TODO Auto-generated method stub
		switchWindow();
		// click leadId
		Thread.sleep(3000);
		
		WebElement eleLeadId = getDriver().findElement(By.xpath("(//table[@class='x-grid3-row-table'])[" + i + "]//a"));
		
		if (eleLeadId.isEnabled())
			eleLeadId.click();
		// switch to parentWindow
		getDriver().switchTo().window(parentWindow);
		
	}

	public MergeLead clickToLeadToMerge() throws InterruptedException {
		
		getDriver().findElement(By.xpath("//span[text()='To Lead']/ancestor::tr//img")).click();
		selectLeadToMerge(2);
		return this;
	}

	public ViewLeadPage clickMergeLink() {
		getDriver().switchTo().window(parentWindow);
		getDriver().findElement(By.linkText("Merge")).click();
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
		return new ViewLeadPage();
	}
	
	public void switchWindowMerge() {
		Set<String> windowHandles = getDriver().getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		getDriver().switchTo().window(windows.get(1));
	
	}

}