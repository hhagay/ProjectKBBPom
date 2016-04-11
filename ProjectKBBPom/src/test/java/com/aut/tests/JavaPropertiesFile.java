package com.aut.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * This class tests that TestConfig.properties works properly
 * 
 *
 */
public class JavaPropertiesFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));
		System.out.println(testConfig.getProperty("browser"));
		System.out.println(testConfig.getProperty("baseUrl"));

	}

}
