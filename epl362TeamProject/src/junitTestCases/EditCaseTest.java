package junitTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.EditCase;

public class EditCaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public final void testEdit_case() {
		EditCase edit_case = new EditCase();
		int retr;
		retr = edit_case.edit_case("1", "3", "2", "2012-01-01", "2012-05-05", "1", 1);
		System.out.println("@Test for editing case with id= 1");
		assertEquals(1,retr);	
	}

}
