package com.test;

import com.junit.div.Div;

import android.test.AndroidTestCase;

public class Test extends AndroidTestCase{

	public void test() throws Exception
	{
		Div d = new Div();
		int result=d.div(8, 4);
		assertEquals(2, result);
	}
}
