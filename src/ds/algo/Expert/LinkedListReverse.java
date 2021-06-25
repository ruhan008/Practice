package ds.algo.Expert;

public class LinkedListReverse {

	class Node {
		int key;
		Node next;

		public Node(int key) {
			this.key = key;
			next = null;
		}
	}

	Node root;

	public LinkedListReverse() {
		root = null;
	}

	public void insert(int element) {
		root = insertRecursive(root, element);
	}

	public Node insertRecursive(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else {
			root.next = insertRecursive(root.next, key);
		}
		return root;
	}

	public Node printList() {
		Node headPointer = root;
		while (root != null) {
			System.out.print(root.key + "->");
			root = root.next;
		}
		System.out.println("");
		root = headPointer;
		return root;
	}

	public void reverse() {
		Node previous = null;
		Node current = root;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;

			previous = current;
			current = next;
		}
		root = previous;
	}

	public static void main(String[] args) {
		LinkedListReverse linkedListReverse = new LinkedListReverse();

		linkedListReverse.insert(4);
		linkedListReverse.insert(6);
		linkedListReverse.insert(5);

		linkedListReverse.printList();

		linkedListReverse.reverse();
		linkedListReverse.printList();

	}

}
