package com.aut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZipCodePage extends PageBase {
	
	// Page Objects Repository
	By elementZipCode = By.xpath(".//*[@id='zipcode-input-header']");
	By elementLogin = By.xpath(".//*[@id='zipcode-update-btn']");
	
	
	
	/**
	 * 
	 * @param driver
	 */
	public ZipCodePage(WebDriver driver) {

		super(driver);
	}

	/**
	 * 
	 * @param zipcode
	 * @return
	 */
	public ZipCodePage setZipCode(String zipcode) {

		driver.findElement(elementZipCode).sendKeys(zipcode);
		driver.findElement(elementLogin).click();
		return new ZipCodePage(driver);
	}

	/**
	 * 
	 * @param zipcode
	 * @return
	 */
	public boolean isSuccesfulZipCode(String zipcode) {
		return driver.findElement(By.id("zip-code-header")).getText().contains(zipcode);
	}
}
