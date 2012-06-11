package array;

import sdet.SdetUtils;

public class Permutation {

	public void permutation(char[] word, int start, int end) {

		if (start == end) { 
			SdetUtils.print(word);
		}

		for (int i = start; i < end; i++) {
			swap(word, start, i);
			permutation(word, start + 1, end);
			swap(word, start, i);
		}

	}

	private void swap(char[] word, int start, int end) {
		char temp = word[start];
		word[start] = word[end];
		word[end] = temp;
	}

	public static void main(String[] args) {
		String word = "abcd";

		Permutation permutation = new Permutation();

		permutation.permutation(word.toCharArray(), 0, 4);
	}

}
