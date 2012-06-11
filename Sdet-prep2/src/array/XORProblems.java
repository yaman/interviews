package array;

import org.junit.Assert;
import org.junit.Test;

public class XORProblems {

	public int xor(int[] array) {

		int result = 0;
		for (int i : array) {
			result = i ^ result;
		}

		return result;
	}

	public int xor2Array(int[] array1, int[] array2) {

		int result = 0;

		for (int i : array1) {
			result = i ^ result;
		}
		System.out.println("Result after first array XOR:" + result);
		for (int i : array2) {
			result = i ^ result;
		}

		System.out.println("Result after second array XOR:" + result);
		return result;
	}

	@Test
	public void testOddElement() {
		int[] array = { 1, 2, 1, 2, 3, 4, 4, 5, 5, 6, 6 };
		int expected = 3;
		Assert.assertEquals(expected, xor(array));
	}

	@Test
	public void testAllElement() {
		int[] array = { 1, 2, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
		int expected = 0;
		Assert.assertEquals(expected, xor(array));
	}

	@Test
	public void testEvenElement() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 7 };
		int expected = 7;
		Assert.assertEquals(expected, xor(array));
	}

	@Test
	public void testMissingElement() {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 7 };
		int[] array2 = { 6, 7, 5, 7, 3, 2, 1 };

		int expected = 4;

		Assert.assertEquals(expected, xor2Array(array1, array2));

	}
}
