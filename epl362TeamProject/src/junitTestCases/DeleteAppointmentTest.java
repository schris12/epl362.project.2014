package junitTestCases;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.DeleteAppointment;

public class DeleteAppointmentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDelete_appointment() {
		DeleteAppointment delete_appointment = new DeleteAppointment();
		Random r = new Random();
		int val = r.nextInt(100-1);
		int retr = delete_appointment.delete_appointment(val);
		System.out.println("@Test for deleting appointment with id=" + val);
		assertEquals(1,retr);
	}

}
