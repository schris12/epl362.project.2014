package junitTestCases;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.SelectAppointment;

public class SelectAppointmentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelect_appointment() {
		SelectAppointment select_appointment = new SelectAppointment();
		LinkedList<String> retr = select_appointment.select_appointment();
		if (retr != null)
			System.out.println("@Test for select appointment Pass");
		else
			System.out.println("@Test for select appointment Fail");
	}

}
