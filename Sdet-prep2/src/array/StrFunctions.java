package array;

import sdet.SdetUtils;

public class StrFunctions {

	public int str2int(char[] value) {
		int returnValue = 0;

		int valueLength = value.length;

		for (int i = 0; i < valueLength; i++) {
			returnValue = returnValue * 10;
			returnValue = returnValue + value[i] - '0';
		}
		return returnValue;
	}

	public String int2str(int value) {
		String returnValue = new String();
		while (value > 0) {
			int modValue = value % 10;
			returnValue = modValue + returnValue;
			value = value / 10;
		}
		return returnValue;
	}

	public boolean strInStrBM(char[] stringContainer, char[] inStr) {
		final int containerLength = stringContainer.length - 1;
		final int inStrLength = inStr.length - 1;

		int index = inStrLength;

		int indexOfInStr = inStrLength;
		while (index < containerLength) {

			if (indexOfInStr == 0) {
				return true;
			}
			if (stringContainer[index] == inStr[indexOfInStr]) {
				index--;
				indexOfInStr--;
			} else {
				indexOfInStr = inStrLength;
				index = index + inStrLength;
			}

		}

		return false;
	}

	private boolean searchForwardBackward(char[] stringContainer, char[] inStr,
			int startIndex) {
		final int depth = 3;
		int depthIndex = depth;
		final int containerLength = stringContainer.length - 1;
		final int inStrLength = inStr.length - 1;
		int index = inStrLength;

		return false;
	}

	public int strInStrKnuttMorrisPrat(char[] stringContainer, char[] pattern) {
		int containerLength = stringContainer.length;
		int patternLength = pattern.length;

		int nextPosition = 0;
		int index = -1;
		for (int containerIndex = 0, patternIndex = 0; containerIndex < containerLength
				&& patternIndex < patternLength; containerIndex++, patternIndex++) {

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

	public static void main(String[] args) {
		StrFunctions functions = new StrFunctions();

		/*
		 * String container = "ABC ABCDAB ABCDABCABDE"; String inStr = "ABCABD";
		 */
		String container = "ABABABABABDABABCAB";
		String inStr = "ABC";

		/*
		 * String container = "This  name is my names"; String inStr = "name";
		 */
		int index = functions.strInStrKnuttMorrisPrat(container.toCharArray(),
				inStr.toCharArray());

		System.out.println(index);

	}
}
