package com.aut.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aut.pages.CarsForSalePage;
import com.aut.pages.HomePage1;


public class HomePage1Test extends TestBase{
	
	//WebDriver driver;
	HomePage1 objHomePage;
	CarsForSalePage objCFS;
	
	@Test(dataProvider="dataProvider")
	public void setZipCode(String zipcode){
		objHomePage = new HomePage1(driver);
		objHomePage.setZipcode(zipcode);
		objHomePage.getZipcode(zipcode);
	}
	
	
	@Test(dataProvider="dataProvider")
	public void setSignin(String email, String password, String username, String menuitem){
		objHomePage = new HomePage1(driver);
		objHomePage.setSignin(email, password);
		objHomePage.getSignin(username);
		objHomePage.setMenuCarsForSale(menuitem);
		objHomePage.getMenuCarsForSale(menuitem);
	}
	
	@Test(dataProvider="dataProvider")
	public void testCarsForSale(String menuitem, String distance, String make, String model, String sortOrder){
		objHomePage = new HomePage1(driver);
		objHomePage.setMenuCarsForSale(menuitem);
		if (driver.findElement(By.xpath(".//*[@id='enterzipsubmit']")).isDisplayed()) {
			boolean testResult = szc.setZipCode("91607").isSuccesfulZipCode("91607");
			Assert.assertTrue(testResult, "Could not verify the popup Zip Code");
		}
		objHomePage.getMenuCarsForSale(menuitem);
		objCFS = new CarsForSalePage(driver);
		objCFS.searchCarClassifieds(distance, make, model);
		objCFS.setSortOrder(sortOrder);
		objCFS.getSortOrder();
		
	}

}
