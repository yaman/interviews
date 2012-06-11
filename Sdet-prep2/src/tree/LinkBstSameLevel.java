package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LinkBstSameLevel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node rootnode = new Node(60);
		LcaBst.insert(rootnode, 30);
		LcaBst.insert(rootnode, 15);
		LcaBst.insert(rootnode, 5);
		LcaBst.insert(rootnode, 20);
		LcaBst.insert(rootnode, 45);

		LcaBst.insert(rootnode, 35);
		LcaBst.insert(rootnode, 55);
		LcaBst.insert(rootnode, 90);
		LcaBst.insert(rootnode, 75);
		LcaBst.insert(rootnode, 85);
		LcaBst.insert(rootnode, 75);

		LcaBst.insert(rootnode, 110);
		LcaBst.insert(rootnode, 100);
		LcaBst.insert(rootnode, 115);

		TreeUtils treeUtils = new TreeUtils();
		Map<Integer, ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();
		// treeUtils.traverseInOrder(rootnode, map);
		
		boolean result = treeUtils.isBinaryTree(rootnode);
		System.out.println(result);
		// System.out.println(map);

	}

}
