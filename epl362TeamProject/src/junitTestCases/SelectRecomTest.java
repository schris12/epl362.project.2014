package junitTestCases;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.SelectRecom;

public class SelectRecomTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelect_recom() {
		SelectRecom select_recom = new SelectRecom();
		LinkedList<String> retr = select_recom.select_recom(1);
		if (retr != null)
			System.out.println("@Test for select recommendation Pass");
		else
			System.out.println("@Test for select recommendation Fail");
			
	}

}
