
/**
 * This Page Object Model is configured to run Singleton design pattern.
 * The singleton pattern is a design pattern that restricts the 
 * instantiation of a class to one object. This is useful when exactly 
 * one object is needed to coordinate actions across the system 
 * (Example: we are making sure that throughout page objects, 
 * we maintain the same single driver instance so all actions are 
 * carried out via one browser instance).
 * 
 */
package com.aut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
	
	// Page Objects Repository
	By zipcode = By.linkText("ZIP CODE:");
	By signin = By.partialLinkText("Sign in");
	By menuCarsForSale = By.xpath(".//*[@id='primaryNav']/ul/li[3]/a");
	
	// Construct
	public HomePage(WebDriver driver) {
		super(driver); // sharing from PageBase
	}
	
	// 
	public ZipCodePage enterZipCode(){
		driver.findElement(zipcode).click();
		return new ZipCodePage(driver);		
	}

	//
	public MyAccountPage clickMyAccountLink(){
		driver.findElement(signin).click();
		return new MyAccountPage(driver);
	}
	
	//
	public CarsForSalePage clickCarsForSaleLink(){
		driver.findElement(menuCarsForSale).click();
		return new CarsForSalePage(driver);
	}
}
