package ds.algo.Expert;

import java.util.Arrays;

public class MergeSortAtlernateMethod {

	public static void mergeNew(int[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		System.out.println(n1 + "," + n2);

		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArray[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArray[j] = arr[m + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (leftArray[i] < rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public static void mergeSortNew(int[] arr, int l, int r) {

		if (l < r) {
			int m = l + (r - l) / 2;

			mergeSortNew(arr, l, m);
			mergeSortNew(arr, m + 1, r);
			mergeNew(arr, l, m, r);
		}
	}

	public static void main(String[] args) {

		int[] array = { 3, 4, 2, 7, 1, 6, 8 };

		System.out.println("Array before merge sort: " + Arrays.toString(array));
		mergeSortNew(array, 0, array.length - 1);

		System.out.println("Array after merge sort: " + Arrays.toString(array));
	}

}
