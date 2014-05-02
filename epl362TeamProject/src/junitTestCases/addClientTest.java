/**
 * 
 */
package junitTestCases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import receptionistViewpoint.addClient;

/**
 * @author Constandinos
 *
 */
public class addClientTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link receptionistViewpoint.addClient#addClient()}.
	 */
	@Test
	public final void testAddClient() {
		addClient client = new addClient();
	}

}
