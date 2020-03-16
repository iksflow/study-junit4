package practice01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAssert {
	@Test
	public void testAssert() {
		String today = DateUtil.getCurTimeAs8Digit();
		assertNotNull(today);
		assertEquals("20200316", today);
	}
}
