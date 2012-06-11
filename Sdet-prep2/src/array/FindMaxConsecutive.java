package array;

public class FindMaxConsecutive {

	public int findMax(int[] array) {
		int arrayLength = array.length;

		int maxSum = 0;
		int maxSoFar = 0;

		for (int i = 0; i < arrayLength; i++) {
			maxSum = maxSum + array[i];
			if (maxSum < 0) {
				maxSum = 0;
			} 
			
			maxSoFar = Math.max(maxSoFar, maxSum); 
			 
		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 5, -10,8,1,-11,1,2,3,4,5};

		FindMaxConsecutive max = new FindMaxConsecutive();

		int maxSum = max.findMax(array);

		System.out.println(maxSum);
	}
}
