package sort;

import sdet.SdetUtils;

public class BubbleSort {

	public void sort(int[] array) {
		final int arrayLength = array.length;

		boolean hasMore = true;

		while (hasMore) {
			hasMore = false;

			for (int i = 0; i < arrayLength - 1; i++) {

				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					hasMore = true;
				}
			}
		}
	}

	private void swap(int[] array, int indexa, int indexb) {
		int tmp = array[indexa];
		array[indexa] = array[indexb];
		array[indexb] = tmp;
	}
	
	
	public static void main(String[] args) {
		int [] array = {2,5,1,3,6,7,4,9};
		
		BubbleSort sort = new BubbleSort();
		
		sort.sort(array);
		
		SdetUtils.print(array);
	}
}
