package array;

import java.util.HashMap;

public class ArrayPairSum {

	public void hash(int[] a, int sum, String hashingIndex) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		System.out.println("Hashing ....." + hashingIndex);

		for (int i = 0; i < a.length; ++i) {
			map.put(sum - a[i], true); 
		}

		for (int i = 0; i < a.length; ++i)
			if (map.containsKey((a[i])) && map.get(a[i])) {
				System.out.println(sum + "(" + a[i] + "," + (sum - a[i]) + ")");
				map.put(a[i], false);
				map.put(sum - a[i], false);
			}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 9, 11 };
		int findNumber = 15;

		int[] input1 = { 2, 3, 8, 12, 1, 4, 7, 3, 8, 22 };
		int[] input2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] input3 = { 2, -3, 8, 12, 1, 4, 7, 3, 8, 22 };
		int target1 = 19;
		int target2 = 16;

		ArrayPairSum arrayPairSum = new ArrayPairSum();

		// arrayPairSum.showPairs(array, findNumber);

		arrayPairSum.hash(array, findNumber, "array+findnumber");
		arrayPairSum.hash(input1, target1, "input1+target1");

		arrayPairSum.hash(input2, target1, "input2+target1");

		arrayPairSum.hash(input3, target1, "input3+target1");

		arrayPairSum.hash(input1, target2, "input1+target2");

		arrayPairSum.hash(input2, target2, "input2+target2");

		arrayPairSum.hash(input3, target2, "inout3+target2");
	}
}
