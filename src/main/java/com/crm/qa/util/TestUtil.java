package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIME_OUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	public static void switchToFrame(String fr)
	{
		dr.switchTo().frame(fr);
	}
}
