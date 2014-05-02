package junitTestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.AddLog;

public class AddLogTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAdd_log() {
		AddLog add_log = new AddLog();
		add_log.add_log("testString");
		System.out.println("@Test for add Log");
	}

}
