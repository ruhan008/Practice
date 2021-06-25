package ds.algo.Expert.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

	private static List<Integer> list = new ArrayList<>();
	private static Map<Integer, List<Integer>> map = new HashMap<>();

	public static List<Integer> inWhichCombinationIsitPossible(int targetSum, int[] array) {

		if (map.containsKey(targetSum)) {
			return map.get(targetSum);
		}

		if (targetSum == 0) {
			return list;
		}

		if (targetSum < 0) {
			return null;
		}

		for (int i = 0; i < array.length; i++) {
			List<Integer> tmpResult = inWhichCombinationIsitPossible(targetSum - array[i], array);
			if (tmpResult != null) {
				tmpResult.add(array[i]);
				map.put(targetSum, tmpResult);
				return map.get(targetSum);
			}
		}

		map.put(targetSum, null);
		return null;
	}

	public static void main(String[] args) {

		int[] a1 = { 2, 3 };
		System.out.println(inWhichCombinationIsitPossible(7, a1));

		int[] a2 = { 5, 3, 4, 7 };
		list.clear();
		map.clear();
		System.out.println(inWhichCombinationIsitPossible(7, a2));

		int[] a3 = { 2, 4 };
		list.clear();
		map.clear();
		System.out.println(inWhichCombinationIsitPossible(7, a3));

		int[] a4 = { 3, 5, 2 };
		list.clear();
		map.clear();
		System.out.println(inWhichCombinationIsitPossible(8, a4));

		int[] a5 = { 7, 14 };
		list.clear();
		map.clear();
		System.out.println(inWhichCombinationIsitPossible(300, a5));
	}

}
