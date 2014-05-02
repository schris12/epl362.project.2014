package junitTestCases;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.PutAppointment;

public class PutAppointmentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPut_appointment() throws ParseException {
		PutAppointment put_appointment = new PutAppointment();
		int retr;
		retr = put_appointment.put_appointment("1", "2", "2012-01-01", "B1");
		System.out.println("@Test for put appointment");
		assertEquals(1,retr);
	}

}
