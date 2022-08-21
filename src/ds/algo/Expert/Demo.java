package ds.algo.Expert;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Demo {

	public static void main(String[] args) {

//		String string = "00111001101111000011111111";
//		int maxLengthSubstringOf1 = 0;
//		String maxString = "";
//		for (int i = 0; i < string.length(); i++) {
//			if (string.charAt(i) == '1') {
//				maxString = maxString + string.charAt(i);
//			} else {
//				if (maxLengthSubstringOf1 < maxString.length()) {
//					maxLengthSubstringOf1 = maxString.length();
//				}
//				maxString = "";
//			}
//		}
//
//		if (maxLengthSubstringOf1 < maxString.length()) {
//			maxLengthSubstringOf1 = maxString.length();
//		}
//
//		System.out.println(maxLengthSubstringOf1);
//		LocalTime openingTime = LocalTime.of(17, 45, 30);
//		System.out.println(LocalTime.now() + "," + openingTime);
//		System.out.println(LocalTime.now().compareTo(openingTime));
//
//		List<Integer> list = new ArrayList<>(Arrays.asList(2, 2, 4, 5, 6, 7, 8, 10, 5, 7, 11, 12));
//		List<Integer> unique = new ArrayList<>();
//
//		for (int i = 0; i < list.size(); i++) {
//			int flag = 0;
//			for (int j = 0; j < unique.size(); j++) {
//				if (list.get(i) == unique.get(j)) {
//					flag = 1;
//				}
//			}
//			if (flag == 1) {
//				System.out.println("Duplicate ID: " + list.get(i));
//			} else {
//				unique.add(list.get(i));
//			}
//
//		}
//		
//		List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,null,5));
//		list2.stream().forEach(System.out::println); 
//		
//		Stack<Integer> stack = new Stack<>();
//		stack.push(2);
//		stack.push(4);
//		System.out.println(stack);
		
		Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int in[] = new int[len];
        int pre[] = new int[len];
        for(int i=0;i<len;i++){
            in[i] = scanner.nextInt();            
        }
        for(int i=0;i<len;i++){
            pre[i] = scanner.nextInt();
        }
        BinaryTree tree = new BinaryTree();
        Node root = tree.constructTree(in, pre, 0, len - 1);
        tree.sumBinaryTree(root);
        int inSumTree[] = new int[len];
        tree.inOrder(root, inSumTree);
        Arrays.sort(inSumTree);
        Node bstRoot = tree.ArrayToBST(inSumTree, 0, len-1);
        tree.printPostorder(bstRoot);
		
		
	}

}

class Node 
{
    int value;
    Node leftchild, rightchild;
  
    Node(int item) 
    {
        value = item;
        leftchild = rightchild = null;
    }
}

class BinaryTree 
{
    Node root;
    static int preIndex = 0;
    static int index=0;
    
    Node constructTree(int in[], int pre[], int inStrt, int inEnd) 
    {
        if (inStrt > inEnd) 
            return null;
  
        Node tNode = new Node(pre[preIndex++]);
  
        if (inStrt == inEnd)
            return tNode;
  
        int inIndex = search(in, inStrt, inEnd, tNode.value);
  
        tNode.leftchild = constructTree(in, pre, inStrt, inIndex - 1);
        tNode.rightchild = constructTree(in, pre, inIndex + 1, inEnd);
        

        return tNode;
    }
     
    int search(int arr[], int strt, int end, int value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
    
    int sumBinaryTree(Node node)
    {   
        // Write the logic to recursively create Binary Tree consisting of sum of all its children
        if(node == null){
            return 0;
        }
        
		int oldValue = node.value;
		int leftTreeSum = sumBinaryTree(node.leftchild);
		int rightTreeSum = sumBinaryTree(node.rightchild);

		node.value = leftTreeSum + rightTreeSum + oldValue;

		return node.value;
    }
    
    void printPostorder(Node node)
    {
        if (node == null)
            return;
 
        // first recur on left subtree
        printPostorder(node.leftchild);
 
        // then recur on right subtree
        printPostorder(node.rightchild);
 
        // now deal with the node
        System.out.print(node.value + " ");
    }
    
    void inOrder(Node node, int array[])
    {
        if (node == null)
            return;
        inOrder(node.leftchild, array);
        array[index++] = node.value;
        inOrder(node.rightchild, array);
        
    }
    
    Node ArrayToBST(int arr[], int start, int end) {
        // Write logic to convert the array representing Binary Tree to Binary Search Tree
    	  if (start > end) {
              return null;
          }

          int mid = (start + end) / 2;
          Node node = new Node(arr[mid]);
 
          node.leftchild = ArrayToBST(arr, start, mid - 1);
          node.rightchild = ArrayToBST(arr, mid + 1, end);
           
          return node;
    }
    
}
