package junitTestCases;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import webservices.SelectUser;

public class SelectUserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSelect_User() {
		SelectUser select_user = new SelectUser();
		LinkedList<String> retr = select_user.select_user();
		if (retr != null)
			System.out.println("@Test for select type Pass");
		else
			System.out.println("@Test for select type Fail");
	}

}
