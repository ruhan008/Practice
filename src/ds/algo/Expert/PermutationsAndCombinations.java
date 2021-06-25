package ds.algo.Expert;

import java.util.Arrays;

public class PermutationsAndCombinations {

	public static long fact(long n) {
		if (n == 0) {
			return 1;
		}

		return n * fact(n - 1);
	}

	public static void getPermutations(int[] array) {
		System.out.println("List of all array permutations for array " + arrayToString(array) + " are: ");
		helper(array, 0);
	}

	public static String arrayToString(int[] array) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < array.length - 1; i++) {
			builder.append(array[i] + ",");
		}
		if (array.length > 0) {
			builder.append(array[array.length - 1]);
		}
		builder.append("]");
		return builder.toString();
	}

	public static void helper(int[] array, int pos) {
		if (pos > array.length - 1) {
			System.out.print("[");
			for (int i = 0; i < array.length - 1; i++) {
				System.out.print(array[i] + ",");
			}
			if (array.length > 0) {
				System.out.print(array[array.length - 1]);
			}
			System.out.println("]");
		}

		for (int i = pos; i < array.length; i++) {
			int t = array[pos];
			array[pos] = array[i];
			array[i] = t;

			helper(array, pos + 1);

			t = array[pos];
			array[pos] = array[i];
			array[i] = t;

		}
	}

	public static void printAllCombinations(int[] array, int r, int n) {
		// printing all combinations of length r
		int[] data = new int[r];
		Arrays.sort(array);
		combinationUtil(array, r, n, 0, data, 0);
	}

	public static void combinationUtil(int[] array, int r, int n, int index, int[] data, int i) {
		if (index == r) {

			for (int j = 0; j < r; j++) {
				System.out.print(data[j] + " ");
			}
			System.out.println(" ");
			return;
		}

		if (i >= n) {
			return;
		}

		// current is included, put next at next location
		data[index] = array[i];
		combinationUtil(array, r, n, index + 1, data, i + 1);

		// to handle duplicates since in sorted array they are adjacent
		if (i < n - 1) {
			while (array[i] == array[i + 1]) {
				i++;
				if (i == n - 1) {
					break;
				}
			}
		}

		// current is excluded, replace it with next (note i+1 is passed index is not
		// changed
		combinationUtil(array, r, n, index, data, i + 1);
	}

	public static void printDivision() {
		System.out.println("------------------------------------------------");
	}

	public static void main(String[] args) {
		// Get No. of permutations if a string is of length N = 4
		// Permutations without repetitions = n!/(n-r)!
		// Permutations with repetitions = n^r
		String string = "abcd";
		int rString = 4;
		long permutationCount = fact(string.length()) / fact(string.length() - rString);
		System.out.println("Permutation count for " + string + " is: " + permutationCount);
		printDivision();

		// Vowels and Consonants Problem: maxLen = 4 and K = 2 where K denotes the max
		// count of vowels in the string and maxLen denotes
		// the max length of the string
		int k = 2;
		int maxLen = 4;
		long sum = 0;
		int consonants = 21;
		int vowels = 5;
		// Formula = (n^r * n^r) * (Total letters in a string)!/(duplicates)!
		for (int i = 0; i <= k; i++) {
			sum += (Math.pow(consonants, maxLen - i) * Math.pow(vowels, i)) * (fact(maxLen) / fact(maxLen - i));
		}
		long mod = sum % (long) Math.pow(10, 9);
		int a = (int) mod;
		System.out
				.println("Sum of all permutations with vowels upto k = " + k + " and maxLen = " + maxLen + " is: " + a);
		printDivision();

		// Get all permutations of the given Array
		int[] permutationArray = { 1, 9, 4, 3 };
		getPermutations(permutationArray);
		printDivision();

		// Get all possible combinations of the given array
		int[] combinationArray = { 1, 2, 3, 4, 5 };
		int n = combinationArray.length;
		for (int r = 1; r <= combinationArray.length; r++) {
			printAllCombinations(combinationArray, r, n);
		}

	}

}
