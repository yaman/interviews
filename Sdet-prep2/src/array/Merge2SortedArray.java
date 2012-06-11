package array; 

import sdet.SdetUtils;


public class Merge2SortedArray {

	public int[] mergeArrays(int[] array1, int[] array2) {

		int targetArrayMax = array1.length + array2.length;
		int[] targetArray = new int[targetArrayMax];

		int array1Max = array1.length;
		int array2Max = array2.length;

		int array1Index = 0;
		int array2Index = 0;
		int targetArrayIndex = 0;

		while (array1Index < array1Max && array2Index < array2Max) {

			int array1Value = array1[array1Index];
			int array2Value = array2[array2Index];

			if (array1Value < array2Value) {
				targetArray[targetArrayIndex] = array1Value;
				array1Index++;
				targetArrayIndex++;
			} else {
				targetArray[targetArrayIndex] = array2Value;
				array2Index++;
				targetArrayIndex++;
			}
		}

		while (array1Index < array1Max && targetArrayIndex < targetArrayMax) { 
			int array1Value = array1[array1Index];
			System.out.println("Adding array1Value :" + array1Value);
			targetArray[targetArrayIndex] = array1Value;
			array1Index++;
			targetArrayIndex++;
		}

		while (array2Index < array2Max && targetArrayIndex < targetArrayMax) {
			int array2Value = array2[array2Index];
			System.out.println("Adding array2Value :" + array2Value);
			targetArray[targetArrayIndex] = array2Value;
			array2Index++;
			targetArrayIndex++;
		}

		return targetArray;
	}

	public static void main(String[] args) {
		Merge2SortedArray merger = new Merge2SortedArray();

		int[] array1 = { 1, 3, 5, 7, 9 };
		int[] array2 = { 2, 4, 6, 8,10,11 };

		int[] targetArray = merger.mergeArrays(array1, array2);

		SdetUtils.print(targetArray);

	}

}
