package junitTestCases;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.SelectClient;

public class SelectClientTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelect_client() {
		SelectClient select_client = new SelectClient();
		LinkedList<String> retr = select_client.select_client();
		if (retr != null)
			System.out.println("@Test for select client Pass");
		else
			System.out.println("@Test for select client Fail");
	}

}
