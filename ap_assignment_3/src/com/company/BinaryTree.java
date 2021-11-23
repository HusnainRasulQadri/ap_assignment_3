package com.company;

public class BinaryTree {
	private Node root;
	public Node getRoot() {
		return root;
	}
	void insert(String key) {
		root = insertRec(root,key);
	}
	Node insertRec(Node root, String key) {
       if (root == null) {
			root = new Node(key);
			return root;
	   }
	   if (key.charAt(0) < root.getData().charAt(0))
		   root.left = insertRec(root.getLeft(), key);
	   else
		   root.right = insertRec(root.getRight(), key);
		return root;
	}
	public Node search(Node root, String key, Node parent) {
		if (root == null) {
			return null;
		}
		if (root.getData().equals(key)) {
			return root;
		}
		if (key.charAt(0) < root.getData().charAt(0)) {
			search(root.getLeft(), key, root);
		} else {
			search(root.getRight(), key, root);
		}
		return null;
	}
	static void getDataInInorderFunc(Node root,StringBuilder arr) {
		// return if the current node is empty
		if (root == null) {
			return;
		}

		// Traverse the left subtree
		getDataInInorderFunc(root.getLeft(),arr);

		// Display the data part of the root (or current node)
		//System.out.print(root.getData() + " ");
		arr.append(root.getData());
		arr.append(" ");

		// Traverse the right subtree
		getDataInInorderFunc(root.getRight(),arr);
	}

}