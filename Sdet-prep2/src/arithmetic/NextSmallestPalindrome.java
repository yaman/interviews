package arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class NextSmallestPalindrome {

	public int nextPalindrome(int number) {

		while (true) {
 
			String str = int2str(number); 
			System.out.println(str);
			if (palindrome(str)) {
				break;
			}
			number++;
		}

		return number;
	}

	public boolean palindrome(String number) {

		char[] palStr = number.toCharArray();
		int start = 0;
		int end = palStr.length - 1;

		while (start <= end) {
			if (palStr[start] != palStr[end]) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

	public String int2str(int number) {
		String str = new String();
		int tmp = number;
		while (tmp > 0) {
			str = (tmp % 10)+str;
			tmp = tmp / 10;
		}
		return str;
	}

	@Test
	public void testSuccess() {
		int number = 125;
		int expected = 131;
		NextSmallestPalindrome nsp = new NextSmallestPalindrome();
		Assert.assertEquals(expected, nsp.nextPalindrome(number));
	}

	@Test
	public void testInt2Str() {
		int number = 121;
		String str = "121";

		Assert.assertEquals(str, int2str(number));
	}

	@Test
	public void testPalindromeSuccess() {
		String pal = "121";
		Assert.assertTrue(palindrome(pal));

	}

	@Test
	public void testPalindromeFailure() {
		String pal = "122";
		Assert.assertFalse(palindrome(pal));

	}
}
