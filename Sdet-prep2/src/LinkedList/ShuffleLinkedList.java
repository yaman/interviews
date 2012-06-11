package LinkedList;

import java.util.LinkedList;
import java.util.Random;

public class ShuffleLinkedList {

	public void shuffle(LinkedList<String> linkedList) {
		Random random = new Random();

		for (int i = linkedList.size(); i > 0; i--) {
			swap(linkedList, i - 1, random.nextInt(i));
		}
	}

	private void swap(LinkedList<String> linkedList, int index1, int index2) {
		String tmp = linkedList.get(index1);
		linkedList.set(index1, linkedList.get(index2));
		linkedList.set(index2, tmp);
	}

	public static void main(String[] args) {
		LinkedList<String> strLnk = new LinkedList<String>();
		
		strLnk.add("a");
		strLnk.add("b"); 
		strLnk.add("c");
		strLnk.add("d");
		
		System.out.println(strLnk);
		
		ShuffleLinkedList shuffle = new ShuffleLinkedList();
		shuffle.shuffle(strLnk);
		System.out.println(strLnk);
	}
}
