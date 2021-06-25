package ds.algo.Expert.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

	private static Map<Integer, Boolean> map = new HashMap<>();

	public static boolean isSumPossible(int targetSum, int[] array) {

		if (map.containsKey(targetSum)) {
			return map.get(targetSum);
		}
		
		if (targetSum == 0) {
			return true;
		}

		if (targetSum < 0) {
			return false;
		}

		for (int i = 0; i < array.length; i++) {
			if (isSumPossible(targetSum - array[i], array) == true) {
				map.put(targetSum, true);
				return true;
			}
		}

		map.put(targetSum, false);
		return false;
	}

	public static void main(String[] args) {

		int[] a1 = { 2, 3 };
		System.out.println(isSumPossible(7, a1));
		int[] a2 = { 5, 3, 4, 7 };
		map.clear();
		System.out.println(isSumPossible(7, a2));
		int[] a3 = { 2, 4 };
		map.clear();
		System.out.println(isSumPossible(7, a3));
		int[] a4 = { 2, 3, 5 };
		map.clear();
		System.out.println(isSumPossible(8, a4));
		int[] a5 = { 7, 14 };
		map.clear();
		System.out.println(isSumPossible(300, a5));
	}

}
