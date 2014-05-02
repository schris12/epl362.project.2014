package junitTestCases;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.DeleteClient;

public class DeleteClientTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDelete_client() {
		DeleteClient delete_client = new DeleteClient();
		Random r = new Random();
		int val = r.nextInt(100-1);
		int retr = delete_client.delete_client(val+"");
		System.out.println("@Test for deleting client with id=" + val);
		assertEquals(1,retr);
	}

}
