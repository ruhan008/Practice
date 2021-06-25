package ds.algo.Expert;

public class ShellSort {

	public static void main(String[] args) {

		int[] array = { 25, 35, -15, 7, 55, 1, -22 };

		for (int gap = array.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < array.length; i++) {
				int newElement = array[i];
				int k = i;
				while (k >= gap && array[k - gap] > newElement) {
					array[k] = array[k - gap];
					k -= gap;
				}
				array[k] = newElement;
			}
		}

		for (int j : array) {
			System.out.println(j);
		}
	}

}
