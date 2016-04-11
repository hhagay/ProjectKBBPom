package com.aut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectedZipCodePage extends PageBase {
	
	//
	public SelectedZipCodePage(WebDriver driver) {
		
		super(driver);
	}
	
	//
	public SelectedZipCodePage setZipCode(String zipcode){
		
		driver.findElement(By.xpath(".//*[@id='selectedZipCode']")).sendKeys(zipcode);
		driver.findElement(By.xpath(".//*[@id='enterzipsubmit']")).click();
		
		return new SelectedZipCodePage(driver);
	}
	
	//
	public boolean isSuccesfulZipCode(String zipcode){
		return driver.findElement(By.id("zip-code-header")).getText().contains(zipcode);
	}

}
