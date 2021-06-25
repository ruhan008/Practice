package ds.algo.Expert;

public class RemovingDuplicatesFromArray {

	public static void main(String[] args) {
		int arr[] = { 4, 6, 2, 6, 7, 8, 8, 9, 10, 7 };
		int[] uniqueArray = uniqueArray(arr);

		System.out.println("Result from uniqueArray method: ");

		for (int j : uniqueArray) {
			System.out.println(j);
		}
		System.out.println("Length of unique array is: " + uniqueArray.length);

	}

	public static int[] uniqueArray(int[] original) {
		int length = original.length;
		int[] arrayWithoutDuplicates = new int[length];
		int k = 0;
		for (int i = 0; i < length; i++) {
			int flag = 1;
			for (int j = 0; j <= k; j++) {
				if (arrayWithoutDuplicates[j] == original[i]) {
					flag = 0;
				}
			}
			if (flag == 1) {
				arrayWithoutDuplicates[k] = original[i];
				k++;
			}
		}
		int[] uniqueList = new int[k];
		for (int l = 0; l < k; l++) {
			uniqueList[l] = arrayWithoutDuplicates[l];
		}

		return uniqueList;
	}

}
