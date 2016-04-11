package com.aut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {
		
	public MyAccountPage(WebDriver driver) {
		super(driver); // sharing from PageBase
	}
	
	public MyAccountPage loginAs(String username, String password){
		
		driver.findElement(By.id("sign-in-email-header")).sendKeys(username);
		driver.findElement(By.id("sign-in-password-header")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='sign-in-form-header']/li[3]/a")).click();
		
		return new MyAccountPage(driver);
	}
	
	public boolean isLoginSuccesful(String username){
		
		return driver.findElement(By.id("sign-in-name-header")).getText().contains(username);
	}

}
