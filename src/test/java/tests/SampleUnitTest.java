package tests;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appcode.SomeClassToTest;

public class SampleUnitTest {
	
	protected SoftAssert ass =new SoftAssert();
  
	
	@Parameters({"Smoke","Reg"})
	@Test
	public void testMethod1(String Smoke, String Reg) {
		SomeClassToTest obj = new SomeClassToTest();
		int result = obj.sumNumber(10, 20);
		ass.assertEquals(result, 30);
		
	}
	
	@Test
	public void testMethod2() {
		//Reporter.log("Running Test -> testMethod2", true);
		String expectedResult = "Hello World";
		SomeClassToTest obj = new SomeClassToTest();
		obj.addString("Hello", "world");
		ass.assertEquals(obj, expectedResult, "testMethod2 - Values do not match");
		ass.assertAll();
	}
	
	
	@Test
	public void testMethod3() {
		Reporter.log("Running Test -> testMethod3", true);
		SomeClassToTest obj = new SomeClassToTest();
		int[] expected = {1,2,3,4};
		int[] actual = obj.returnArray();
		ass.assertEquals(expected, actual);
	}
	
	@Test
	public void testmethod4(){
		Reporter.log("Running Test -> testMethod4", true);
		SomeClassToTest obj = new SomeClassToTest();
		int result = obj.subNumber(20,10);
		Reporter.log("Running Test -> testMethod4 -> Soft Assert 1", true);
		ass.assertEquals(20, result);
		
		Reporter.log("Running Test -> testMethod4 -> Soft Assert 2", true);
		ass.assertEquals(10, result);
		ass.assertAll();
		
	}
	
	@Test
	public void testmethod5(){
		Reporter.log("Running Test -> testMethod4 -> Soft Assert", true);
		SomeClassToTest obj = new SomeClassToTest();
		int result = obj.subNumber(20,10);
		ass.assertEquals(10, result);
		
	}
	
}
