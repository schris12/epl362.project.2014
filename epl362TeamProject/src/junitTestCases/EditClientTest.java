package junitTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.EditClient;

public class EditClientTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	public final void testEdit_client() {
		EditClient edit_client = new EditClient();
		int retr;
		retr = edit_client.edit_client("1", "testClient", "testClient");
		System.out.println("@Test for editing client with id= 3");
		assertEquals(1,retr);	
	}

}
