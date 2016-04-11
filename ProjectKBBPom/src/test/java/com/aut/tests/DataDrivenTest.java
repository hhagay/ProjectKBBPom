package com.aut.tests;

import com.aut.utils.DataDrivenHelper;

/**
 * 
 * This is just to verify the functionality of DataDrivenHelper class in Utils package.
 *
 */
public class DataDrivenTest {

	public static void main(String[] args) {
		
		DataDrivenHelper ddh = new DataDrivenHelper("MasterTestDataFile.xlsx");
		Object[][] testData = ddh.getTestCaseDataSets("TestCaseDataSets", "testApplyingSortOrder");
		for (Object[] testRow:testData){
			System.out.print(" | ");
			for(Object cell:testRow){
				System.out.print(cell.toString()+" ");
			}
			System.out.print(" | \n");
		}

	}

}
