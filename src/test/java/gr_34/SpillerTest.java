package gr_34;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr_34.entity.Spiller;

public class SpillerTest {
	
	Spiller s;

	@Before
	public void setUp() throws Exception {
		//1500kr er standard startbeløb
		s = new Spiller("", 1500);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tilføj_penge_test() {
		s.tilføjPenge(500);
		int expected = 1500 + 500;
		int actual = s.getPenge();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void fratræk_penge_test() {
		s.fratrækPenge(500);
		int expected = 1500 -500;
		int actual = s.getPenge();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void negativ_test_0() {
		s.fratrækPenge(1501);
		boolean condition = s.getPenge() == 0;
		
		assertTrue(condition);
	}

}
