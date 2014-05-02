package junitTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.EditLawyer;

public class EditLawyerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public final void testEdit_lawyer() {
		EditLawyer edit_lawyer = new EditLawyer();
		int retr;
		retr = edit_lawyer.edit_lawyer("1", "testLawyer", "testLawyer");
		System.out.println("@Test for editing lawyer with id= 1");
		assertEquals(1,retr);	
	}

}
