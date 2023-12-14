package com.jayasanka.algo.search.binary;

public class BinarySearchTree {

	public static void main(String[] args) {
		int[] nodeData = new int[] { 3, 5, 2, 1, 4, 6, 7 };

		Node root = null;
		Tree tree = new Tree();

		for (int data : nodeData) {
			root = tree.insert(root, data);
		}

		System.out.print("Print pre-order Tree \t:: ");
		tree.printPreOrder(root);
		System.out.println();

		System.out.print("Print ordered Tree \t:: ");
		tree.printTree(root);
		System.out.println();

		System.out.print("Print post-order Tree \t:: ");
		tree.printPostOrder(root);
		System.out.println();

		int nodeHeight = tree.getHeightByNodes(root);
		System.out.println("Hight of the Tree by Node count \t:: " + nodeHeight);

		int linkHeight = tree.getHeightByLinks(root);
		System.out.println("Hight of the Tree by Link count \t:: " + linkHeight);

	}

}

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Tree {

	public Node insert(Node parentNode, int data) {
		if (parentNode == null) {
			return new Node(data);
		} else {
			if (data <= parentNode.data) {
				parentNode.left = insert(parentNode.left, data);
			} else {
				parentNode.right = insert(parentNode.right, data);
			}
			return parentNode;
		}
	}

	public int getHeightByNodes(Node root) {
		if (root == null) {
			return 0;
		}

		int lDepth = getHeightByNodes(root.left);
		int rDepth = getHeightByNodes(root.right);

		if (lDepth > rDepth) {
			return lDepth + 1;
		} else {
			return rDepth + 1;
		}
	}

	public int getHeightByLinks(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}

		int lDepth = getHeightByLinks(root.left);
		int rDepth = getHeightByLinks(root.right);

		if (lDepth > rDepth) {
			return lDepth + 1;
		} else {
			return rDepth + 1;
		}
	}

	/**
	 * InOrder traversal:
	 * 
	 * In case of binary search trees (BST), InOrder traversal gives nodes in non-decreasing order. We visit the left
	 * child first, then the root, and then the right child.
	 */
	public void printTree(Node root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.data + " ");
			printTree(root.right);
		}
	}

	/**
	 * PreOrder traversal:
	 * 
	 * PreOrder traversal first visits the root node and then traverses the left and the right subtree. It is used to
	 * create a copy of the tree. PreOrder traversal is also used to get prefix expression on of an expression tree.
	 */
	public void printPreOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	/**
	 * PostOrder traversal:
	 * 
	 * PostOrder traversal first traverses the left and the right subtree and then visits the root node. It is used to
	 * delete the tree. In simple words, visit the root of every subtree last.
	 */
	public void printPostOrder(Node root) {
		if (root != null) {
			printPostOrder(root.left);
			printPostOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(" " + root.data);
		else if (level > 1) {
			// Recursive Call
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
}
