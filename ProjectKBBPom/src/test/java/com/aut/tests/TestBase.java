/**
 * 
 * 
 * 
 */

package com.aut.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aut.pages.CarsForSalePage;
import com.aut.pages.HomePage;
import com.aut.pages.SelectedZipCodePage;
import com.aut.utils.DataDrivenHelper;
import com.aut.utils.WebDriverHelper;

public class TestBase {

	protected WebDriver driver;
	protected HomePage homePage;
	protected CarsForSalePage cfs;
	protected SelectedZipCodePage szc;
	protected Properties testConfig;
	
	

	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));

	}

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {

		driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"));
		driver.manage().window().maximize();
		driver.get(testConfig.getProperty("baseUrl"));
		

		homePage = new HomePage(driver);
		cfs = new CarsForSalePage(driver);
		szc = new SelectedZipCodePage(driver);

	}

	@DataProvider
	public Object[][] dataProvider(Method method) {
		DataDrivenHelper ddh = new DataDrivenHelper(testConfig.getProperty("mastertestdatafile"));
		Object[][] testData = ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());
		return testData;
	}

	@AfterMethod
	public void afterMethod() {

		WebDriverHelper.quitDriver(driver);
	}
	
	@AfterSuite
	public void afterSuite(){
		//WebDriverHelper.quitDriver(driver);
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

}
