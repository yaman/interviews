package tree;
 
public class Node {
	private Node left;
	private Node right;
	private int value;

	public Node(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		builder.append(value); 
		return builder.toString();
	}

}
