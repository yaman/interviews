package sdet;

import java.util.ArrayList;
import java.util.List;

public class SdetUtils {

	public static String toString(char[] input) {
		if (null == input || 0 == input.length) {
			return null;
		}
		StringBuffer stringBuffer = new StringBuffer("");
		for (int i = 0; i < input.length; i++) {
			stringBuffer.append(input[i]);
		}
		return stringBuffer.toString();
	}

	public static String toString(int[] input, boolean ignoreZero) {
		if (null == input || 0 == input.length) {
			return null;
		}
		StringBuffer stringBuffer = new StringBuffer("");
		for (int i = 0; i < input.length; i++) {
			int value = input[i];

			if (value >= 0 && ignoreZero) {
				stringBuffer.append("'");
				stringBuffer.append(input[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			} else if (!ignoreZero) {
				stringBuffer.append("'");
				stringBuffer.append(input[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			}
		}

		return stringBuffer.toString();
	}

	public static String toString(int[] input) {
		return toString(input, false);
	}

	public static void print(char[] input) {
		System.out.println(toString(input));
	}

	public static void print(int[] input) {
		System.out.println(toString(input));
	}

	public static void print(int[] input, boolean ignoreZero) {
		System.out.println(toString(input, ignoreZero));
	}

	public static void print2arrayReverse(char[] text, char[] pattern,
			int textIndex) {
		List<Character> patternList = new ArrayList<Character>();
		List<Character> textList = new ArrayList<Character>();

		for (int i = 0; i <= textIndex - pattern.length; i++) {
			patternList.add(' ');
		}
		for (int i = 0; i < pattern.length; i++) {
			patternList.add(pattern[i]);
		}
		for (int i = 0; i < text.length; i++) {
			textList.add(text[i]);
		}
		System.out.println(patternList);
		System.out.println(textList);
	}

	public static void print2array(char[] text, char[] pattern, int textIndex) {
		List<Character> patternList = new ArrayList<Character>();
		List<Character> textList = new ArrayList<Character>();

		for (int i = 0; i < textIndex; i++) {
			patternList.add(' ');
		}
		for (int i = 0; i < pattern.length; i++) {
			patternList.add(pattern[i]);
		}
		for (int i = 0; i < text.length; i++) {
			textList.add(text[i]);
		}
		System.out.println(patternList);
		System.out.println(textList);
	}
}
