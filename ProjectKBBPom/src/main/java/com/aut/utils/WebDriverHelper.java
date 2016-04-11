package com.aut.utils;

import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class WebDriverHelper 
{
	// static method means that you can access these methods directly without instantiating 
	public static WebDriver createDriver(String browser)
	{
		WebDriver driver=null; // not pointing to any driver instance.
		
		if(browser.equalsIgnoreCase("phantomjs"))
		{
			driver = new PhantomJSDriver();
		}
		
		else if(browser.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Temp\\workspace\\browsers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",
					"C:\\Temp\\workspace\\browsers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.ie.driver",
					"C:\\Temp\\workspace\\browsers\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			throw new InvalidParameterException(browser + " - is not a valid web browser for web driver.");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static void quitDriver(WebDriver driver)
	{
		driver.quit();
	}

} 
		
