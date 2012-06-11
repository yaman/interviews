package arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class SquareRootOf {

	public int sqrrt(int[] array) {

		for (int i = array[0]; i <= array[array.length - 1]; i++) {
			int low = 0;
			int high = i / 2;
			while (low + 1 < high) {
				int mid = low + (high - low) / 2;
				System.out.println("Mid :"+mid);
				if(mid * mid == i){
					return mid;
				}else if(mid * mid < i){
					low = mid;
				}else {
					high = mid;
				}
			} 
		} 
		return -1;
	}

	@Test
	public void testSuccess1() {
		int[] array = { 9, 15 };
		int expected = 3;
		Assert.assertEquals(expected, sqrrt(array));
	}

	@Test
	public void testSuccess2() {
		int[] array = { 12, 24 };
		int expected = 4;
		Assert.assertEquals(expected, sqrrt(array));
	}
}
