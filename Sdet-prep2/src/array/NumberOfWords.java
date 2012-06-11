package array;
public class NumberOfWords {

	public int numberOfWords(char[] words) {
		int returnValue = 0;
		int startIndex = 0;
 
		while (isEndOfWord(words[startIndex])) {
			startIndex++;
		}
		System.out.println("Start index is :" + startIndex);

		for (int i = startIndex; i < words.length; i++) {
			char letter = words[i];
			if (isEndOfWord(letter)) {
				returnValue++;

				while (i < words.length && isEndOfWord(words[i]) ) {
					i++;
				}
			}
		}
		return returnValue;
	}

	public boolean isEndOfWord(char letter) {
		String str = new String("" + letter);
		return str.matches("[,. ]");
	}

	public static void main(String[] args) {
		NumberOfWords calc = new NumberOfWords();
		String words = ",.,.,. My ,.Name is ";
		int count = calc.numberOfWords(words.toCharArray());

		System.out.println(count);
	}
}
