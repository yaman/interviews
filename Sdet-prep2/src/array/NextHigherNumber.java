package array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NextHigherNumber {

	public int nextHigherNumber(int number) {

		char[] na = String.valueOf(number).toCharArray();
		int[] numberArray = new int[na.length];

		for (int i = 0; i < na.length; i++) {
			numberArray[i] = na[i] - '0';
		}

		int pivotIndex = 0;
		for (int i = numberArray.length - 2; i >= 0; i--) {
			if (numberArray[i] < numberArray[i + 1]) {
				pivotIndex = i;
				break;
			}
		}

		int nextSmallerNumber = numberArray[pivotIndex + 1];
		int smallerIndex = -1;
		for (int i = pivotIndex + 2; i < numberArray.length; i++) {
			if (nextSmallerNumber > numberArray[i]) {
				nextSmallerNumber = numberArray[i];
				smallerIndex = i;
			}
		}
		if (smallerIndex >= 0) {
			int pivot = numberArray[pivotIndex];
			numberArray[pivotIndex] = nextSmallerNumber;
			numberArray[smallerIndex] = pivot;
		}

		Arrays.sort(numberArray, pivotIndex + 1, numberArray.length);
		String numberStr = "";
		for (int i : numberArray) {
			numberStr = numberStr + i;
		}
		return Integer.parseInt(numberStr);
	}

	@Test
	public void testSuccess1() {
		int number = 12543;
		int expected = 13245;
		Assert.assertEquals(expected, nextHigherNumber(number));
	}
 
	public void testSuccess2() {
		int number = 12345;
		int expected = 12354;
		Assert.assertEquals(expected, nextHigherNumber(number));
	}
 
	public void testSuccess3() {
		int number = 12343;
		int expected = 12433;
		Assert.assertEquals(expected, nextHigherNumber(number));
	}
}
