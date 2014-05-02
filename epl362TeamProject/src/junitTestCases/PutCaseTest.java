package junitTestCases;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.PutCase;

public class PutCaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPut_case() throws ParseException {
		PutCase put_case = new PutCase();
		int retr;
		retr = put_case.put_case("1", "3", "2012-01-03", "2013-08-08", 1, 1);
		System.out.println("@Test for put case");
		assertEquals(1,retr);
	}

}
