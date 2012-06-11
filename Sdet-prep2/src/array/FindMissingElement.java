package array;

import java.util.HashMap;
import java.util.Map;

public class FindMissingElement {

	public int findMissingWithHash(int[] array1, int[] array2) {
		Map<Integer, Boolean> missingArrayHash = new HashMap<Integer, Boolean>();
		for (Integer i : array2) {
			missingArrayHash.put(i, true);
		}

		for (Integer i : array1) {
			if (!missingArrayHash.containsKey(i)) {
				return i;
			}
		}
		return -1;
	}

	public int findMissingWithXOR(int[] array1, int[] array2) {
		int result = 0;

		for (int i : array1) {
			result = i ^ result;
		}

		for (int i : array2) {
			result = i ^ result;
		}

		return result;

	}

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 15, 14, 13, 12, 5, 6, 7, 8, 9, 10 };
		int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 15, 13, 12 };

		FindMissingElement fme = new FindMissingElement();

		int result = fme.findMissingWithXOR(array1, array2);

		System.out.println(result);
	}
}
