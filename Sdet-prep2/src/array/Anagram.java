package array;

import org.junit.Assert;
import org.junit.Test;

public class Anagram {

	public boolean anagram(char[] str1, char[] str2) {
		char[] hash = new char[255];

		for (char c : str1) {
			if (hash[c] == 0) {
				hash[c] = 1;
			} else {
				hash[c] += 1;
			}
		}

		for (char c : str2) {
			hash[c] -= 1;
			if (hash[c] < 0) {
				return false;
			}
		}

		for (char c : str1) {
			if (hash[c] > 0) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testSuccess1() {
		char[] str1 = "ptos".toCharArray();
		char[] str2 = "tsop".toCharArray();
		Anagram anagram = new Anagram();
		Assert.assertTrue(anagram(str1, str2));
	}

	@Test
	public void testSuccess2() {
		char[] str1 = "Eleven plus two".toLowerCase().toCharArray();
		char[] str2 = "Twelve plus one".toLowerCase().toCharArray();
		Anagram anagram = new Anagram();
		Assert.assertTrue(anagram(str1, str2));
	}

	@Test
	public void testFail1() {
		char[] str1 = "Eleven plus twoo".toLowerCase().toCharArray();
		char[] str2 = "Twelve plus one".toLowerCase().toCharArray();
		Anagram anagram = new Anagram();
		Assert.assertFalse(anagram(str1, str2));
	}
}
