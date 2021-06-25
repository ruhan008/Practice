package ds.algo.Expert.DynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem {

	public static int getCountRecursively(int arr[], int m, int n) {

		// If n is 0 then there is 1 solution
		// (do not include any coin)
		if (n == 0) {
			return 1;
		}

		// If n is less than 0 then no
		// solution exists
		if (n < 0) {
			return 0;
		}

		// If there are no coins and n
		// is greater than 0, then no
		// solution exist
		if (m <= 0 && n >= 1) {
			return 0;
		}

		// count is sum of solutions (i)
		return getCountRecursively(arr, m - 1, n) + getCountRecursively(arr, m, n - arr[m - 1]);

	}

	public static int getCountDynamicallywith2D(int arr[], int m, int n) {
		int[][] table2 = new int[m][n + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 1; j++) {
				table2[i][j] = 1;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 0) {
					if (j % arr[i] == 0) {
						table2[i][j] = 1;
					} else {
						table2[i][j] = 0;
					}
				} else if (arr[i] > j && i != 0) {
					table2[i][j] = table2[i - 1][j];
				} else {
					table2[i][j] = table2[i - 1][j] + table2[i][j - arr[i]];
				}
			}
		}

		return table2[m - 1][n];
	}

	public static int getCountDynamically(int arr[], int m, int n) {

		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		int[] table = new int[n + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++) {
			for (int j = arr[i]; j <= n; j++) {
				table[j] += table[j - arr[i]];
			}
		}

		return table[n];

	}

	public static int getMinimumCoinsCount(int[] arr, int m, int n) {
		int[] table = new int[n + 1];

		Arrays.fill(table, Integer.MAX_VALUE);

		table[0] = 0;

		for (int i = 0; i < m; i++) {
			for (int j = arr[i]; j <= n; j++) {
				table[j] = Math.min(table[j], (j / arr[i]) + table[j - arr[i]]);
			}
		}

		return table[n];
	}

	public static void main(String[] args) {

		// Getting the maximum number of ways you can get the total sum using the coins
		// given (Infinite supply of coins)

		// Coin denominations
		int[] array = { 2, 3, 5, 10 };
		// No. of array elements
		int m = array.length;
		// Amount
		int n = 15;
		// calling recursive method
		System.out.println("The count of ways for coins array recursively with amount " + n + " is "
				+ getCountRecursively(array, m, n));

		// calling dynamic programming method
		System.out.println("The count of ways for coins array using dynamic programming with amount " + n + " is "
				+ getCountDynamically(array, m, n));

		System.out.println(
				"The count of ways for coins array using dynamic programming (Alternate Method - 2D Array) with amount "
						+ n + " is " + getCountDynamicallywith2D(array, m, n));

		// Getting the minimum count of coins required problem (Infinite supply of
		// coins)
		int[] array2 = { 1, 5, 6, 9 };
		int m2 = array2.length;
		int n2 = 11;
		System.out.println("The minimum number of coins required to get the sum of " + n2
				+ " using dynamic programming is " + getMinimumCoinsCount(array2, m2, n2));

	}

}
