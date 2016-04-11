package com.aut.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	/**
	 * 
	 * @param linkText
	 */
	public void clickAnElementByLinkText(WebDriver driver, String linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(linkText)));
	    //driver.findElement(By.xpath(linkText)).selectByVisibleText();
	}
	
	public void clickTest(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Loading...')]"));
		System.out.println("Test");
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Loading...')]"))));
		System.out.println("Test");
	}


}
