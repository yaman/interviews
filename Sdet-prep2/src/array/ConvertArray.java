package array;

import org.junit.Assert;
import org.junit.Test;

public class ConvertArray {

	public char[] convert(char abc[], char def[], char ghi[]) {

		int lenght = getLength(abc) + getLength(def) + getLength(ghi);

		char[] convertedArray = new char[lenght];

		for (int i = 0, ai = 0, di = 0, gi = 0; i < convertedArray.length; ai++, di++, gi++) {
			if (null != abc && ai < abc.length) {
				convertedArray[i++] = abc[ai];
			}
			if (di < def.length) {
				convertedArray[i++] = def[di];
			}
			if (gi < ghi.length) {
				convertedArray[i++] = ghi[gi];
			}
		}
		return convertedArray;
	}

	public int getLength(char[] array) {
		if (null == array)
			return 0;
		else
			return array.length;
	}

	@Test
	public void testSuccess1() {
		char abc[] = "abc".toCharArray();
		char def[] = "def".toCharArray();
		char ghi[] = "ghi".toCharArray();

		char expected[] = "adgbehcfi".toCharArray();
		ConvertArray convertArray = new ConvertArray();

		char actual[] = convertArray.convert(abc, def, ghi);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testSuccess2() {
		char abc[] = "abcd".toCharArray();
		char def[] = "xyzf".toCharArray();
		char ghi[] = "fgh".toCharArray();

		char expected[] = "axfbygczhdf".toCharArray();
		ConvertArray convertArray = new ConvertArray();

		char actual[] = convertArray.convert(abc, def, ghi);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testFailure1() {
		char abc[] = null;
		char def[] = "def".toCharArray();
		char ghi[] = "ghi".toCharArray();

		char expected[] = "dgehfi".toCharArray();
		ConvertArray convertArray = new ConvertArray();

		char actual[] = convertArray.convert(abc, def, ghi);
		Assert.assertArrayEquals(expected, actual);
	}
}
