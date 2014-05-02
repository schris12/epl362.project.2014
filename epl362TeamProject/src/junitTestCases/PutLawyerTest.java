package junitTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.PutLawyer;

public class PutLawyerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPut_lawyer() {
		PutLawyer put_lawyer = new PutLawyer();
		int retr;
		retr = put_lawyer.put_lawyer("1", "testLawyer", "testLawyer");
		System.out.println("@Test for put lawyer");
		assertEquals(1,retr);
	}

}
