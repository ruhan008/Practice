package ds.algo.Expert;

public class BinarySearchTree {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	void insert(int key) {
		root = insertRecursive(root, key);
	}

	Node insertRecursive(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key > root.key) {
			root.right = insertRecursive(root.right, key);
		}

		else if (key < root.key) {
			root.left = insertRecursive(root.left, key);
		}
		return root;
	}

	void inorder() {
		inorderRecursive(root);
	}

	void inorderRecursive(Node root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.println(root.key);
			inorderRecursive(root.right);
		}
	}

	public static boolean search(Node root, int key) {
		if (root == null) {
			return false;
		}

		else if (root.key == key) {
			return true;
		}

		else if (key > root.key) {
			return search(root.right, key);
		}

		return search(root.left, key);

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);

		bst.inorder();

		int searchValue = 10;

		System.out.println(
				"Is the value " + searchValue + " present in Binary Search Tree: " + search(bst.root, searchValue));

	}

}
