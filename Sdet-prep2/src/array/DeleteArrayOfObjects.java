package array;

import sdet.SdetUtils;

public class DeleteArrayOfObjects {

	public char[] deleteArray(char[] container, char[] toBeDeleted) {
		int deleteLength = toBeDeleted.length;
		int containerLength = container.length;

		char[] deleteHash = new char[255];

		for (int i = 0; i < deleteLength; i++) {
			deleteHash[toBeDeleted[i]] = 'o';
		}

		int newArrayLength = 0;
		char[] temp = new char[255];
		for (int i = 0; i < containerLength; i++) {
			if (deleteHash[container[i]] != 'o') {
				temp[newArrayLength] = container[i];
				newArrayLength++;
			}
		}

		char[] newArray = new char[newArrayLength];
		for (int i = 0; i < newArrayLength; i++) {
			newArray[i] = temp[i];
		}
		return newArray;
	}

	public static void main(String[] args) {
		String container = "This is my name";
		String delete = "name";
		DeleteArrayOfObjects arrayOfObjects = new DeleteArrayOfObjects();
		
		char [] newArray = arrayOfObjects.deleteArray(container.toCharArray(), delete.toCharArray());
		
		SdetUtils.print(newArray);
	}
}
