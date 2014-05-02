package junitTestCases;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.SelectCase;

public class SelectCaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelect_case() {
		SelectCase select_case = new SelectCase();
		LinkedList<String> retr = select_case.select_case();
		if (retr != null)
			System.out.println("@Test for select case Pass");
		else
			System.out.println("@Test for select case Fail");
	}

}
