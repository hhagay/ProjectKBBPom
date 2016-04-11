/**
 * 
 * 
 * 
 */

package com.aut.tests;

import org.testng.annotations.Test;
import com.aut.pages.CarsForSalePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginTests extends TestBase {
	/**
	 * Testing the ZIPCODE link of the main page
	 */
	@Test(dataProvider = "dataProvider")
	public void testZipCodeHomePage(String zipcode) {
		boolean testResult = homePage.enterZipCode().setZipCode(zipcode).isSuccesfulZipCode(zipcode);
		Assert.assertTrue(testResult, "Zip Code Failed: "+zipcode);
	}
	/**
	 * Testing the pop up window the requests the user to enter zipcode
	 */
	@Test(dataProvider="dataProvider")
	public void testZipCodePopUp(String zipcode, String acceptanceCriteria) {
		homePage.clickCarsForSaleLink();
		if (driver.findElement(By.xpath(".//*[@id='enterzipsubmit']")).isDisplayed()) {
			boolean testResult = szc.setZipCode(zipcode).isSuccesfulZipCode(zipcode);
			Assert.assertTrue(testResult, "Could not verify the popup Zip Code");
		}
		WebElement webelement = driver.findElement(By.xpath(".//*[@id='Content']/div[3]/section/div[1]/h1"));
		CarsForSalePage cfs = new CarsForSalePage(driver);
		boolean testResult = cfs.isPageSuccessful(webelement, acceptanceCriteria);
		Assert.assertTrue(testResult, "Could not verify page: "+acceptanceCriteria);
	}
	/**
	 * 
	 */
	@Test(dataProvider = "dataProvider")
	public void testSuccesfulLogin(String username, String password, String email) {
		// because each method returns a page object on navigation, you can
		// write this test
		boolean testResult = homePage.clickMyAccountLink().loginAs(email, password).isLoginSuccesful(username);
		Assert.assertTrue(testResult, "Login is not successful for user: " + username);
	}

}
