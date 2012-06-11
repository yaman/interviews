package array;

import org.junit.Assert;
import org.junit.Test;

public class Combine2Strings {

	public boolean isCombined(char[] str1, char[] str2, char[] combinedString) {

		int str1Index = 0;
		int str2Index = 0;

		for (char c : combinedString) {
			if (str1Index < str1.length && str1[str1Index] == c) {
				str1Index++;
			} else if (str2Index < str2.length && str2[str2Index] == c) {
				str2Index++;
			} else {
				return false;
			}
		}
		if (str1Index != str1.length || str2Index != str2.length)
			return false;
		return true;
	}

	@Test
	public void testSuccess1() {
		char[] abc = { 'A', 'B', 'C' };
		char[] def = { 'D', 'E', 'F' };
		char[] combinedString = "ADBECF".toCharArray();
		Combine2Strings combine2Strings = new Combine2Strings();

		boolean result = combine2Strings.isCombined(abc, def, combinedString);

		Assert.assertTrue(result);
	}

	@Test
	public void testSuccess2() {
		char[] abc = { 'A', 'B', 'C' };
		char[] def = { 'D', 'E', 'F' };
		char[] combinedString = "ABCDEF".toCharArray();
		Combine2Strings combine2Strings = new Combine2Strings();

		boolean result = combine2Strings.isCombined(abc, def, combinedString);

		Assert.assertTrue(result);
	}

	@Test
	public void testFailure1() {
		char[] abc = { 'A', 'B', 'C' };
		char[] def = { 'D', 'E', 'F' };
		char[] combinedString = "AEBDCF".toCharArray();
		Combine2Strings combine2Strings = new Combine2Strings();

		boolean result = combine2Strings.isCombined(abc, def, combinedString);

		Assert.assertFalse(result);
	}
	

	@Test
	public void testFailure2() {
		char[] abc = { 'A', 'B', 'C' };
		char[] def = { 'D', 'E', 'F' };
		char[] combinedString = "FEBDCA".toCharArray();
		Combine2Strings combine2Strings = new Combine2Strings();

		boolean result = combine2Strings.isCombined(abc, def, combinedString);

		Assert.assertFalse(result);
	}

}
