package junitTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.PutClient;

public class PutClientTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPut_client() {
		PutClient put_client = new PutClient();
		int retr;
		retr = put_client.put_client("1", "testClient", "testClient");
		System.out.println("@Test for put client");
		assertEquals(1,retr);
	}

}
