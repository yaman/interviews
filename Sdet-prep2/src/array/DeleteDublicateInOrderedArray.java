package array;

import sdet.SdetUtils;

public class DeleteDublicateInOrderedArray {

	public void deleteDublicate(int[] array) {

		int tmp = array[0];
		int shiftCount = 0;
		for (int i = 1; i < array.length; i++) {
			System.out.println("Tmp : " + tmp);
			if (tmp == array[i]) {
				shift(array, i);
				shiftCount++;
			}
			tmp = array[i];
		}

		for (int i = array.length - 1; i > shiftCount; i--) {
			array[i] = -1;
		}
	}

	private void shift(int[] array, int start) {
		int lenght = array.length;
		System.out.println("Start index:" + start);

		while (start < lenght) {
			if (start + 1 > lenght - 1) {
				break;
			}
			array[start] = array[start + 1];
			start++;
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 1, 2, 2, 3, 4, 5 };

		DeleteDublicateInOrderedArray delete = new DeleteDublicateInOrderedArray();

		delete.deleteDublicate(array);

		SdetUtils.print(array);

	}

}
