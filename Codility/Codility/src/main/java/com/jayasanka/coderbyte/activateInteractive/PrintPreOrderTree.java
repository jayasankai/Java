package com.jayasanka.coderbyte.activateInteractive;

public class PrintPreOrderTree {
	
	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class Tree {

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
		
		public void printPreOrder(Node root) {
			if (root != null) {
				System.out.print(root.data + " ");
				printPreOrder(root.left);
				printPreOrder(root.right);
			}
		}
	}

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

	}

}
