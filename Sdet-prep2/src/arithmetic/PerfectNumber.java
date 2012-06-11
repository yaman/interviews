package arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class PerfectNumber {

	public boolean isPerfect(long number) {

		long pn = 0;
		for (int i = 2; pn < number; i++) {
			pn = (long) (Math.pow(2, i - 1) * (Math.pow(2, i) - 1));
			if (pn == number) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void testSuccess1() {
		Assert.assertTrue(isPerfect(6));
	}

	@Test
	public void testSuccess2() {
		Assert.assertTrue(isPerfect(28));
	}

	@Test
	public void testSuccess3() {
		Assert.assertTrue(isPerfect(496));
	}

	@Test
	public void testSuccess4() {
		Assert.assertTrue(isPerfect(8128));
	}

	@Test
	public void testSuccess5() {
		Assert.assertTrue(isPerfect(33550336));
	}

	@Test
	public void testSuccess6() {
		Assert.assertTrue(isPerfect(8589869056l));
	}

	@Test
	public void testSuccess7() {
		Assert.assertTrue(isPerfect(137438691328l));
	}

	@Test
	public void testSuccess8() {
		Assert.assertTrue(isPerfect(2305843008139952128l));
	}

	@Test
	public void testFail1() {
		Assert.assertFalse(isPerfect(3));
	}

}
