package ds.algo.Expert.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
	
	private static Map<Integer, List<Integer>> map = new HashMap<>();

	public static List<Integer> getSmallestCombinationOfArrayforSum(int targetSum, int[] array) {
		
		if(map.containsKey(targetSum)) {
			return map.get(targetSum);
		}

		if (targetSum == 0) {
			return new ArrayList<>();
		}

		if (targetSum < 0) {
			return null;
		}

		List<Integer> shortestCombination = null;

		for (int i = 0; i < array.length; i++) {
			List<Integer> tmpCombination = getSmallestCombinationOfArrayforSum(targetSum - array[i], array);
			if (tmpCombination != null) {
				List<Integer> finalCombination = new ArrayList<>(tmpCombination);
				finalCombination.add(array[i]);
				if (shortestCombination == null) {
					shortestCombination = new ArrayList<>();
					shortestCombination.addAll(finalCombination);
				}
				if (finalCombination.size() < shortestCombination.size()) {
					shortestCombination.clear();
					shortestCombination.addAll(finalCombination);
				}
			}
			
		}
		
		map.put(targetSum, shortestCombination);
		return shortestCombination;
	}

	public static void main(String[] args) {
		
		//m = target sum
		//n = array.length
		
		//Brute Force
		//time: O(n^m *m)
		//space: O(m^2)

		int[] a1 = { 5, 3, 4, 7 };
		map.clear();
		System.out.println(getSmallestCombinationOfArrayforSum(7, a1));

		int[] a2 = { 2, 3, 5 };
		map.clear();
		System.out.println(getSmallestCombinationOfArrayforSum(8, a2));

		int[] a3 = { 1, 4, 5 };
		map.clear();
		System.out.println(getSmallestCombinationOfArrayforSum(8, a3));

		int[] a4 = { 1, 2, 5, 25 };
		map.clear();
		System.out.println(getSmallestCombinationOfArrayforSum(100, a4));
		
	}

}
