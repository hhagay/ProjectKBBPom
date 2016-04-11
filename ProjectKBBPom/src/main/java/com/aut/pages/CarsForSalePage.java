package com.aut.pages;
import com.aut.utils.*;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarsForSalePage extends PageBase{
	
	// Page Objects Repository
	By elementDistance = By.xpath(".//*[@id='Distance']");
	By elementMake = By.xpath(".//*[@id='Make-model-dropdowns']/div[1]/select");
	By elementModel = By.xpath(".//*[@id='Make-model-dropdowns']/div[2]/select");
	By listCarsFound = By.xpath(".//*[@id='Search-preview-count-listings']/span[1]");
	By btnView = By.xpath(".//*[@id='Search-submit']");
	By elementSort = By.xpath(".//*[@id='Content']/div[5]/div[2]/div[4]/div[1]/div/div[1]/select");
	
	// Constructor
	public CarsForSalePage(WebDriver driver) {
		super(driver);
	}
	
	//
	public boolean isPageSuccessful(WebElement webelement, String acceptanceCriteria){
		
		return webelement.getText().contains(acceptanceCriteria);
	}

	//
	public CarsForSalePage searchCarClassifieds(String distance, String make) throws InterruptedException{
		/**
		 * Page 1
		 */
		//
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element;
		// (miles) Matches within dropdown
		element = wait.until(ExpectedConditions.elementToBeClickable(elementDistance));
		Select milesList = new Select(driver.findElement(elementDistance));
		milesList.selectByVisibleText(distance);
		
		// Make dropdown
		element = wait.until(ExpectedConditions.elementToBeClickable(elementMake));
		Select makeList = new Select(driver.findElement(elementMake));
		makeList.selectByVisibleText(make);		
		
		// Number of Cars found
		String numOfCarsFound = driver.findElement(listCarsFound).getText();
		System.out.println("Number of cars found: "+numOfCarsFound);
		
		// Click View
		driver.findElement(btnView).click();
		
		return new CarsForSalePage(driver);
	}
	//
	public CarsForSalePage searchCarClassifieds(String distance, String make, String model){
		/**
		 * Page 1
		 */
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element;
		// (miles) Matches within dropdown
		element = wait.until(ExpectedConditions.elementToBeClickable(elementDistance));
		Select milesList = new Select(driver.findElement(elementDistance));
		milesList.selectByVisibleText(distance);
		
		// Make dropdown
		element = wait.until(ExpectedConditions.elementToBeClickable(elementMake));
		Select makeList = new Select(driver.findElement(elementMake));
		makeList.selectByVisibleText(make);		
		
		// Model dropdown
		element = wait.until(ExpectedConditions.elementToBeClickable(elementModel));
		Select modelList = new Select(driver.findElement(elementModel));
		modelList.selectByVisibleText(model);
		
		
		// Number of Cars found
		String numOfCarsFound = driver.findElement(listCarsFound).getText();
		System.out.println("Number of cars found: "+numOfCarsFound);
		
		// Click View
		driver.findElement(btnView).click();
		
		return new CarsForSalePage(driver);
		
	}
	//
	public CarsForSalePage setSortOrder(String sortOrder){
		
		// Sort drop down
		Select sortList = new Select(driver.findElement(elementSort));
		sortList.selectByVisibleText(sortOrder);
		
		return new CarsForSalePage(driver);
	}
	
	//
	public String getSortOrder(){
		Select sortList = new Select(driver.findElement(elementSort));
		return sortList.getFirstSelectedOption().getText();
		
	}
	
}
