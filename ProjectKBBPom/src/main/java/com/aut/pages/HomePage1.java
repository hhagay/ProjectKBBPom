
/**
 * This class is a copy of the HomePage class. Different implementation of the POM
 * 
 */
package com.aut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage1 extends PageBase{
	
	//WebDriver driver;
	// Page Objects Repository
	By linkZipCode = By.linkText("ZIP CODE:");
	By linkSignin = By.partialLinkText("Sign in");
	By menuCarsForSale = By.xpath(".//*[@id='primaryNav']/ul/li[3]/a");
	//
	By elementZipCode = By.xpath(".//*[@id='zipcode-input-header']");
	By elementLogin = By.xpath(".//*[@id='zipcode-update-btn']");
	//
	By headerZipCode = By.id("zip-code-header");
	//
	By emailSignin = By.id("sign-in-email-header");
	By passwordSignin = By.id("sign-in-password-header");
	By btnSignin = By.xpath(".//*[@id='sign-in-form-header']/li[3]/a");
	By headerSignin = By.id("sign-in-name-header");
	//
	By headerCarsForSale = By.xpath(".//*[@id='Content']/div[3]/section/div[1]/h1");
	
	
	public HomePage1(WebDriver driver){
		//this.driver=driver;
		super(driver);
	}
	
	// getters and setters
	public boolean getZipcode(String zipcode) {
		return driver.findElement(headerZipCode).getText().contains(zipcode);
	}
	public void setZipcode(String zipcode) {
		driver.findElement(linkZipCode).click();
		driver.findElement(elementZipCode).sendKeys(zipcode);
		driver.findElement(elementLogin).click();
	}
	public boolean getSignin(String username) {
		return driver.findElement(headerSignin).getText().contains(username);
	}
	public void setSignin(String email, String password) {
		driver.findElement(linkSignin).click();
		driver.findElement(emailSignin).sendKeys(email);
		driver.findElement(passwordSignin).sendKeys(password);
		driver.findElement(btnSignin).click();
		
	}
	public boolean getMenuCarsForSale(String menuitem) {
		return driver.findElement(headerCarsForSale).getText().contains(menuitem);
	}
	public void setMenuCarsForSale(String menuitem) {
		driver.findElement(menuCarsForSale).click();
	}
	
	
	
	

}
