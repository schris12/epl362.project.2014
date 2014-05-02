package junitTestCases;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.SelectLawyer;

public class SelectLawyerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelect_lawyer() {
		SelectLawyer select_lawyer = new SelectLawyer();
		LinkedList<String> retr = select_lawyer.select_lawyer();
		if (retr != null)
			System.out.println("@Test for select lawyer Pass");
		else
			System.out.println("@Test for select lawyer Fail");
	}

}
