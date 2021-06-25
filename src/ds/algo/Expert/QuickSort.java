package ds.algo.Expert;

import java.util.Arrays;

public class QuickSort {

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int partitionAlgo(int[] arr, int low, int high) {
		int i = low - 1;
		int pivot = arr[high];

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	public static void quickSortAlgo(int[] array, int low, int high) {

		if (low < high) {
			int partition = partitionAlgo(array, low, high);

			quickSortAlgo(array, low, partition - 1);
			quickSortAlgo(array, partition + 1, high);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 10, 7, 9, 6, 1, 5 };
		quickSortAlgo(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
