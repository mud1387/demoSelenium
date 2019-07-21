package com.demo.helper.assertion;
import org.testng.Assert;

public class assertionHelper {
	
	public static void verifyText(String s1, String s2) {
		
		Assert.assertEquals(s1, s2);
		
	}
	
	public static void verifyTrue(boolean x) {
		
		Assert.assertTrue(x);
	
	}
	
	public static void verifyTrue(String msg) {
		
		Assert.assertTrue(true,msg);
	
	}
}
