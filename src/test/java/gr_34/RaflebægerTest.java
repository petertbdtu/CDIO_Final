package gr_34;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr_34.entity.Raflebæger;

public class RaflebægerTest {
	
	Raflebæger r;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void raflebæger_slag_test() {
		r = new Raflebæger();
		int sum = 0;
		for(int i = 0; i < 10000; i++) {
			r.kastTerninger();
			sum = r.getSum();
			boolean condition = sum >= 2 && 12 >= sum;
			assertTrue(condition);
		}
	}

}
