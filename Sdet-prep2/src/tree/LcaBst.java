package tree;

public class LcaBst {

	public void lowestCommonAncestorRecursive(Node root, int lvalue, int rvalue) {

		if (null == root || null == root.getLeft() || null == root.getRight()) {
			return;
		}

		if (lvalue < root.getValue() && rvalue > root.getValue()) {
			System.out.println(root);
		}

		else if (lvalue < root.getValue() && rvalue < root.getValue()) {
			lowestCommonAncestorRecursive(root.getLeft(), lvalue, rvalue);
		}

		else if (lvalue > root.getValue() && rvalue > root.getValue()) {
			lowestCommonAncestorRecursive(root.getRight(), lvalue, rvalue);
		}

	}

	public void lowestCommonAncestorIterative(Node root, int lvalue, int rvalue) {
		if (null == root || null == root.getLeft() || null == root.getRight()) {
			return;
		}

		while (null != root) {
			if (lvalue < root.getValue() && rvalue > root.getValue()) {
				System.out.println(root);
				break;
			}

			if (lvalue < root.getValue() && rvalue < root.getValue()) {
				root = root.getLeft();
			} else if (lvalue > root.getValue() && rvalue > root.getValue()) {
				root = root.getRight();
			}
		}
	}

	public static void insert(Node root, int value) {

		if (root == null) {
			return;
		}

		if (root.getValue() > value) {
			if (root.getLeft() != null) {
				insert(root.getLeft(), value);
			} else {
				root.setLeft(new Node(value));
			}
		}

		if (root.getValue() < value) {
			if (root.getRight() != null) {
				insert(root.getRight(), value);
			} else {
				root.setRight(new Node(value));
			}
		}

	}

	public static void main(String[] args) {
		Node rootnode = new Node(60);
		insert(rootnode, 30);
		insert(rootnode, 15);
		insert(rootnode, 5);
		insert(rootnode, 20);
		insert(rootnode, 45);

		insert(rootnode, 35);
		insert(rootnode, 55);
		insert(rootnode, 90);
		insert(rootnode, 75);
		insert(rootnode, 85);

		insert(rootnode, 110);
		insert(rootnode, 100);
		insert(rootnode, 115);

		LcaBst lcaBst = new LcaBst();

		int lvalue = 15;
		int rvalue = 55;
		lcaBst.lowestCommonAncestorRecursive(rootnode, lvalue, rvalue);
		lcaBst.lowestCommonAncestorIterative(rootnode, lvalue, rvalue);
	}

}
