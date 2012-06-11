package sort;

import sdet.SdetUtils;

public class QuickSort {

	public void sort(int[] array, int left, int right) {
		int index = partition(array, left, right);

		if (left < index - 1) {
			sort(array, left, index - 1);
		}
		if (right > index) {
			sort(array, index, right);
		}

	}

	private int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];

		while (left <= right) {
			while (pivot > array[left]) {
				left++;
			}
			while (pivot < array[right]) {
				right--;
			}

			if (left <= right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				left++;
				right--;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 7, 2, 4, 6, 8 };

		QuickSort sort = new QuickSort();

		sort.sort(array, 0, array.length - 1);

		SdetUtils.print(array);

	}
}
