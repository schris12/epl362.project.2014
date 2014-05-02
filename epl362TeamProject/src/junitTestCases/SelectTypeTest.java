package junitTestCases;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.SelectType;

public class SelectTypeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelect_Type() {
		SelectType select_type = new SelectType();
		int testValue = 1;
		LinkedList<String> retr = select_type.select_type(testValue);
		if (retr != null)
			System.out.println("@Test for select type Pass");
		else
			System.out.println("@Test for select type Fail");
	}

}
