package ds.algo.Expert.Tabulation;

import java.util.Arrays;

public class CanSum {

	public static boolean isSumPossible(int target, int[] array) {
		boolean[] table = new boolean[target + 1];
		Arrays.fill(table, false);
		table[0] = true;

		for (int j = 0; j <= target; j++) {

			for (int i = 0; i < array.length; i++) {

				if ((j + array[i]) <= target && table[j] == true) {
					table[j + array[i]] = table[j];
				}
			}
		}

//		for(boolean b: table) {
//			System.out.println(b);
//		}

		return table[target];

	}

	public static void main(String[] args) {

		int[] a1 = { 5, 3, 4, 7 };
		System.out.println(isSumPossible(7, a1));

		int[] a2 = { 2, 4 };
		System.out.println(isSumPossible(7, a2));

		int[] a3 = { 2, 3, 5 };
		System.out.println(isSumPossible(8, a3));

	}

}
