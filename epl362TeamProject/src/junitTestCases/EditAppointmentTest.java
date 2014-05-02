package junitTestCases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import webservices.EditAppointment;

public class EditAppointmentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test 
	public final void testEdit_appointment() {
		EditAppointment edit_appointment = new EditAppointment();
		int retr;
		try {
			retr = edit_appointment.edit_appointment("1", "3", "2", "2012-01-01", 0, "B1");
			System.out.println("@Test for editing appointment with id= 1");
			assertEquals(1,retr);	
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}	
	}

}
