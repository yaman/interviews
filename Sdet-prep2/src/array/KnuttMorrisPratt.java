package array;

import java.util.ArrayList;
import java.util.List;

import sdet.SdetUtils;

public class KnuttMorrisPratt {

	public int search(char[] stringContainer, char[] pattern) {
		int containerLength = stringContainer.length;
		int patternLength = pattern.length;
		int[] shiftArray = preprocess(pattern);

		int nextPosition = 0;
		int index = -1;

		for (int containerIndex = 0, patternIndex = 0; containerIndex < containerLength
				&& patternIndex < patternLength; containerIndex++, patternIndex++) {
			SdetUtils.print2array(stringContainer, pattern, containerIndex);
			if (patternIndex != 0
					&& (stringContainer[containerIndex] == pattern[0])) {
				nextPosition = containerIndex;
			}

			if (stringContainer[containerIndex] != pattern[patternIndex]) {
				patternIndex = 0;
				if (nextPosition > 0) {
					containerIndex = nextPosition;
					nextPosition = 0;
				}
			} else if (patternIndex == patternLength - 1) {
				index = containerIndex - (patternLength - 1);

			}
		}
		return index;
	}

	public List<Integer> searchKmp(char[] text, char[] pattern) {
		int textLength = text.length;
		int patternLength = pattern.length;
		int[] shiftArray = preprocess(pattern);
		List<Integer> result = new ArrayList<Integer>();

		int textIndex = 0;

		while (textIndex < textLength) {

			boolean found = true;
			int shiftIndex = -1;
			System.out.println("Text Index : " + textIndex);
			for (int i = 0; i < patternLength && textIndex + i < textLength; i++) {
				char t = text[i + textIndex];
				char p = pattern[i];

				SdetUtils.print2array(text, pattern, textIndex);
				if (t != p) {
					System.out.println("t : " + t + " p : " + p);
					shiftIndex = shiftArray[t];
					if (shiftIndex < 0) {
						shiftIndex = i+1;
					}
					found = false;
					break;
				}
			}

			if (found) {
				result.add(textIndex);
				System.out.println("Found at : " + textIndex);
				textIndex++;
			} else if (shiftIndex > 0) {
				System.out.println("Shift Index :" + shiftIndex);
				textIndex += shiftIndex;
			} else {
				textIndex++;
			}

		}

		return result;
	}

	public int[] preprocess(char[] pattern) {
		int[] shiftArray = new int[255];
		for (int i = 0; i < shiftArray.length; i++) {
			shiftArray[i] = -1;
		}
		int pLength = pattern.length - 1;
		for (int i = pLength; i >= 0; i--) {
			if (shiftArray[pattern[i]] < 0) {
				shiftArray[pattern[i]] = pLength - i;
			}
		}
		return shiftArray;
	}

	public static void main(String[] args) {
		KnuttMorrisPratt functions = new KnuttMorrisPratt();

		/*
		 * String container = "ABC ABCDAB ABCDABCABDE"; String inStr = "ABCABD";
		 */
		String container = "ABABABABCABDABCABCAB";
		String inStr = "ABC";
		/*
		 * String container = "This  name is my names"; String inStr = "name";
		 */
		List<Integer> index = functions.searchKmp(container.toCharArray(),
				inStr.toCharArray());

		System.out.println(index);

	}
}
