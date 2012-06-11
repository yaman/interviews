package array;

import org.junit.Assert;
import org.junit.Test;

public class SearchUnknownLengthArray {

	public int find(int[] array, int num) {

		int index = 0;
		int exp = 0;
		while (true) {
			try {
				if (array[index] < num) {
					index = (int) Math.pow(2, exp);
					exp++;
				} else if (array[index] == num) {
					return index;
				} else {
					break;
				}
			} catch (Exception e) { 
				break;
			}
		}

		int left = (index / 2) + 1;
		int right = index - 1; 
		while (left < right) {
			try {
				int mid = left + (right - left) / 2; 
				if (array[mid] == num) {
					return mid;
				} else if (array[mid] < num) {
					left = mid + 1;
				} else if (array[mid] > num) { 
					right = mid - 1;
				}
			} catch (Exception e) {
				break;
			}
		}

		return -1;
	}

	@Test
	public void testSuccess() {
		int[] array = { 1, 3, 4, 5, 6, 8, 9, 11, 15, 28, 32, 49, 55, 66, 78, 98 };
		int num = 32;

		SearchUnknownLengthArray sula = new SearchUnknownLengthArray();

		Assert.assertEquals(10, sula.find(array, num));
	}

}
