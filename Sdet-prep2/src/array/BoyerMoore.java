package array;

import java.util.ArrayList;
import java.util.List;

import sdet.SdetUtils;

public class BoyerMoore {

	public int[] preprocess(String pattern) {

		int[] shiftArray = new int[255];
		char[] patternArray = pattern.toCharArray();

		for (int i = 0; i < shiftArray.length; i++) {
			shiftArray[i] = -1;
		}
		int length = pattern.length();

		for (int i = length - 1; i >= 0; i--) {
			char c = patternArray[i];
			int index = shiftArray[c];

			if (index == -1) {
				shiftArray[c] = i;

			}
		}
		return shiftArray;
	}

	public List<Integer> search(String text, String pattern) {
		int[] shiftArray = preprocess(pattern);
		char[] textA = text.toCharArray();
		char[] patternA = pattern.toCharArray();

		List<Integer> result = new ArrayList<Integer>();

		int patternLength = pattern.length() - 1;
		int textLength = text.length();
		int textIndex = patternLength;
 
		while (textIndex < textLength) { 
			boolean found = true;
			int shiftIndex = -1;
			System.out
					.println("------------------------------------------------------------");
			for (int i = patternLength, j = textIndex; i >= 0 && j >= 0; i--, j--) {
			 
				char t = textA[j];
				char p = patternA[i];
				SdetUtils.print2arrayReverse(textA, patternA, textIndex);

				if (t != p) {
					if (shiftArray[t] >= 0) {
						shiftIndex = shiftArray[t];
					}
					found = false;
					break;
				}
			}

			if (found) {
				int foundLocation = textIndex - patternLength;
				result.add(foundLocation);
				System.out
						.println("Found ------------------------------------------------------");
				textIndex++;
			} else if (shiftIndex >= 0) {
				int shiftCount = patternLength - shiftIndex;

				if (shiftCount > 0)
					textIndex = textIndex + shiftCount;
				else
					textIndex = textIndex + patternLength + 1;
			} else {
				textIndex = textIndex + patternLength + 1;
			}
		} 
		return result;
	}

	public static void main(String[] args) {

		String pattern = "abc";
		String text = "abdabcabaabccabccabc";

		BoyerMoore boyerMoore = new BoyerMoore();
		List<Integer> result = boyerMoore.search(text, pattern);

		System.out.println(result);
/*
		int a = 1;
		int b = 2;
		System.out.println("a :"+a);
		System.out.println("b :"+b);
		b = a + b;

		System.out.println("a :"+a);
		System.out.println("b :"+b);
		a = b - a;

		System.out.println("a :"+a);
		System.out.println("b :"+b);
		b = b -a;

		System.out.println("a :"+a);
		System.out.println("b :"+b);*/
	}
}
