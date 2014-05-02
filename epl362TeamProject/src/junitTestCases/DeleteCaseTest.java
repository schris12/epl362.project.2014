package junitTestCases;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.DeleteCase;

public class DeleteCaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDelete_case() {
		DeleteCase delete_case = new DeleteCase();
		Random r = new Random();
		int val = r.nextInt(100-1);
		int retr = delete_case.delete_case(val);
		System.out.println("@Test for deleting case with id=" + val);
		assertEquals(1,retr);
	}

}
