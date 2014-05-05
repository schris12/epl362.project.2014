package junitTestCases;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.PutRecom;

public class PutRecomTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPut_recom() throws ParseException {
		PutRecom put_recom = new PutRecom();
		int retr;
		retr = put_recom.put_recom("1", "test recom", "test opinion", "2013-01-01");
		System.out.println("@Test for put recommendation");
		assertEquals(1,retr);
	}

}
