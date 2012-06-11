package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class TreeUtils {

	private int level = 0;

	public void traverseInOrder(Node root, Map<Integer, ArrayList<Node>> map) {

		if (root == null) {
			return;
		}
		level++;

		traverseInOrder(root.getLeft(), map);
		ArrayList<Node> list = map.get(level);
		if (null == list) {
			list = new ArrayList<Node>();
		}
		list.add(root);
		map.put(level, list);
		traverseInOrder(root.getRight(), map);
		level--;

	}

	public void traversePreOrder(Node root, Map<Integer, ArrayList<Node>> map) {
		level++;
		if (root == null) {
			return;
		}
		ArrayList<Node> list = map.get(level);
		if (null == list) {
			list = new ArrayList<Node>();
		}
		list.add(root);
		map.put(level, list);
		traverseInOrder(root.getLeft(), map);
		traverseInOrder(root.getRight(), map);
		level--;
	}

	public void traversePostOrder(Node root, Map<Integer, ArrayList<Node>> map) {
		level++;
		if (root == null) {
			return;
		}
		traverseInOrder(root.getLeft(), map);
		traverseInOrder(root.getRight(), map);
		ArrayList<Node> list = map.get(level);
		if (null == list) {
			list = new ArrayList<Node>();
		}
		list.add(root);
		map.put(level, list);
		level--;
	}

	public void bfs(Node root) {
		Queue<Node> queue = new java.util.LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			System.out.println(node);

			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
		}
	}

	public static int reverseLevel = -1;

	public void traverseTreeReverse(Node root, List<List<Node>> list) {

		if (root == null) {
			return;
		}
		reverseLevel++;

		List<Node> nodes;
		if (list.get(reverseLevel) == null) {
			nodes = new ArrayList<Node>();
			list.set(reverseLevel, nodes);
		} else {
			nodes = list.get(reverseLevel);
		}

		traverseTreeReverse(root.getLeft(), list);
		nodes.add(root);
		traverseTreeReverse(root.getRight(), list);
		reverseLevel--;
	}

	public boolean isBinaryTree(Node root) {

		List<Node> sortedList = new ArrayList<Node>();

		traverseInOrder(root, sortedList);

		Node tmpNode = sortedList.get(0);
		for (int i = 1; i < sortedList.size(); i++) {
			if (tmpNode.getValue() > sortedList.get(i).getValue()) {
				return false;
			}
			tmpNode = sortedList.get(i);
		}

		return true;
	}

	public void traverseInOrder(Node root, List<Node> sortedList) {
		if (root == null) {
			return;
		}

		traverseInOrder(root.getLeft(), sortedList);
		sortedList.add(root);
		traverseInOrder(root.getRight(), sortedList);
	}

	public void traversePreOrder(Node root, List<Node> sortedList) {
		if (root == null) {
			return;
		}

		sortedList.add(root);
		traverseInOrder(root.getLeft(), sortedList);
		traverseInOrder(root.getRight(), sortedList);
	}

	public void traversePostOrder(Node root, List<Node> sortedList) {
		if (root == null) {
			return;
		}

		traverseInOrder(root.getLeft(), sortedList);
		traverseInOrder(root.getRight(), sortedList);
		sortedList.add(root);
	}

	@Test
	public void testBinaryTreeFailure1() {
		Node root = new Node(3);
		root.setLeft(new Node(2));
		root.getLeft().setLeft(new Node(1));
		root.getLeft().setRight(new Node(4));
		root.setRight(new Node(5));
		Assert.assertFalse(isBinaryTree(root));

	}

	@Test
	public void testBinaryTreeFailure2() {
		Node root = new Node(3);
		root.setLeft(new Node(2));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(3));
		root.setRight(new Node(5));
		Assert.assertFalse(isBinaryTree(root));

	}

	@Test
	public void testBinaryTreeSuccess1() {
		Node root = new Node(4);
		root.setLeft(new Node(2));
		root.getLeft().setLeft(new Node(1));
		root.getLeft().setRight(new Node(3));
		root.setRight(new Node(5));
		Assert.assertTrue(isBinaryTree(root));

	}

	@Test
	public void testBfsReverse() {
		Node root = new Node(4);
		root.setLeft(new Node(2));
		root.getLeft().setLeft(new Node(1));
		root.getLeft().setRight(new Node(3));
		root.setRight(new Node(5));

		List<List<Node>> map = new ArrayList<List<Node>>();

		traverseTreeReverse(root, map);

		while (reverseLevel > 0) {
			System.out.println(map);
			reverseLevel--;
		}

	}
}
