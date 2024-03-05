package com.jay.visa.api.connector;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	VisaApiUnitTest.class, 
	VisaApiIntegrationTest.class
})
public class TestSuite {

}
