package junitTestCases;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.DeleteLawyer;

public class DeleteLawyerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDelete_lawyer() {
		DeleteLawyer delete_lawyer = new DeleteLawyer();
		Random r = new Random();
		int val = r.nextInt(100-1);
		int retr = delete_lawyer.delete_lawyer(val+"");
		System.out.println("@Test for deleting lawyer with id=" + val);
		assertEquals(1,retr);
	}
}
