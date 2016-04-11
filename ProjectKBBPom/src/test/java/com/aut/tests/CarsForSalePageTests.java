package com.aut.tests;

import org.testng.annotations.Test;

import com.aut.listeners.TestListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CarsForSalePageTests extends TestBase {

	/**
	 * Testing the ZIPCODE link of the main page
	 */
	//@Test(dataProvider = "dataProvider")
	public void testEnterZipCode(String zipcode) {

		boolean testResult = homePage.enterZipCode().setZipCode(zipcode).isSuccesfulZipCode(zipcode);
		Assert.assertTrue(testResult, "Zip Code Failed: "+zipcode);
	}

	/**
	 * 1. Selects [Cars For Sale] link 2. Enters search information 3. Verifies
	 * search results 4. Verifies sort functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "dataProvider")
	public void testApplyingSortOrder(String zipcode, String distance, String make, String model, String sortOrder)
			throws InterruptedException {
		
		homePage.enterZipCode().setZipCode(zipcode).isSuccesfulZipCode(zipcode);
		homePage.clickCarsForSaleLink().searchCarClassifieds(distance, make, model);
		// CarsForSalePage cfs = new CarsForSalePage(driver);
		WebElement webelement = driver.findElement(By.xpath(".//*[@id='Slp-header']/h1/span[1]"));
		boolean applyResult = cfs.isPageSuccessful(webelement, make +" "+model+" Vehicles for Sale");
		Assert.assertTrue(applyResult, "Could not verify page: " + make +" "+model+" Vehicles for Sale");

		cfs.setSortOrder(sortOrder);
		String sortResult = cfs.getSortOrder();

		Assert.assertTrue(sortResult.equals(sortOrder), "Could not verify sort: " + sortOrder);

	}

}
