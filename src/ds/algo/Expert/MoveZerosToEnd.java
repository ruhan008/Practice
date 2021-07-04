package ds.algo.Expert;

import java.util.Scanner;

public class MoveZerosToEnd {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		s.close();
		moveZerosToEnd(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	// Method to find move all zeros to the end of the array
	static void moveZerosToEnd(int[] arr) {
		// Write your code here
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 0) {
				int k = i + 1;
				while (arr[k] == 0 && k < arr.length - 1) {
					k++;
				}
				int tmp = arr[i];
				arr[i] = arr[k];
				arr[k] = tmp;
				k++;
			}
		}
	}

}
