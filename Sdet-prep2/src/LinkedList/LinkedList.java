package LinkedList;

public class LinkedList {

	private int data;
	private LinkedList next;
	private LinkedList previous;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList nextElement) {
		this.next = nextElement;
	}

	public LinkedList getPrevious() {
		return previous;
	}

	public void setPrevious(LinkedList previous) {
		this.previous = previous;
	}

	public boolean hasNext() {
		return (null == next) ? false : true;
	}

	public boolean hasPrevious() {
		return (null == previous) ? false : true;
	}

	public static void main(String[] args) {
		int i = 10;

		LinkedList head = new LinkedList();
		head.setData(-1);

		LinkedList temp = new LinkedList();
		head.setNext(temp);
		temp.setPrevious(head);

		for (int j = 0; j < i; j++) {

			LinkedList l = new LinkedList();
			temp.setData(j);
			temp.setNext(l);
			l.setPrevious(temp);
			temp = l;
		}

		while (head.hasNext()) {
			System.out.println("" + head.getData());
			head = head.getNext();
		}

		while (head.hasPrevious()) {
			System.out.println("" + head.getData());
			head = head.getPrevious();
		}
	}
}
