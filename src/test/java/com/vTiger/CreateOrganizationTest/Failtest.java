package com.vTiger.CreateOrganizationTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.vTiger.genericLib.RetrySetup;

public class Failtest 
{
	
		@Test(retryAnalyzer = RetrySetup.class)
	    public void test1() {
	        //Fail Scenario
	        assertEquals(2+2,5,"Addition Problem! 2+2 must be 4!\n");
	    }
	 
	    @Test(retryAnalyzer = RetrySetup.class)
	    public void test2() {
	        //Fail Scenario
	        assertEquals(2+2,4,"Addition Problem! 2+2 must be 4!\n");
	    }
	
}
