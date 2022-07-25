package com.testleaf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testleaf.utils.ExcelReadData;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods extends AbstractTestNGCucumberTests {

	public RemoteWebDriver driver;
	public String fileName;
	public static Properties props;

	private static final ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();

	public void setDriver(RemoteWebDriver driver) {
		tlDriver.set(driver);
	}

	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}

	@Parameters("browser")
	@BeforeMethod
	public void preCondition(@Optional("chrome")String browser) throws IOException {
		WebDriverManager.chromedriver().setup();
		setDriver(new ChromeDriver());

		getDriver().get(readPropFile());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	public String readPropFile() throws IOException {
		props = new Properties();

		FileInputStream fis = new FileInputStream(new File("./src/main/resources/configg.properties"));

		props.load(fis);
		
	

		
		return props.getProperty("url");

	}

	public void launchBrowser(String browser) {
		// TODO Auto-generated method stub
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
		}
		
		}
	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}

	@DataProvider(name = "getData", indices=0)
	public String[][] fetchData() throws IOException {

		return ExcelReadData.readFile(fileName);

	}
	
	public void clickLinkText(String value) {
		getDriver().findElement(By.linkText(value)).click();
		
	}
	
	public void verifyPage(String pageName) {

		boolean contains = getDriver().getTitle().contains(pageName);
		Assert.assertTrue(contains);

	}


}