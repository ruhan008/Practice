package ds.algo.Expert.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CanConstructString {

	private static Map<String, Boolean> map = new HashMap<>();

	public static boolean isStringConstructionPossible(String target, String[] array) {

		if (map.containsKey(target)) {
			return map.get(target);
		}

		if (target.equals("")) {
			return true;
		}

		for (int i = 0; i < array.length; i++) {
			if (target.indexOf(array[i]) == 0) {
				String suffix = target.substring(array[i].length(), target.length());
				if (isStringConstructionPossible(suffix, array) == true) {
					map.put(target, true);
					return true;
				}

			}
		}

		map.put(target, false);
		return false;
	}

	public static void main(String[] args) {

		// m = target length
		// n = array length
		// time complexity: O(n^m*m)
		// space complexity: O(m^2 )

		String string = "abcdef";
		String[] wordBank = { "ab", "abc", "cd", "def", "abcd" };
		map.clear();
		System.out.println(isStringConstructionPossible(string, wordBank));

		String string2 = "skateboard";
		String[] wordBank2 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
		map.clear();
		System.out.println(isStringConstructionPossible(string2, wordBank2));

		String string3 = "enterapotentpot";
		String[] wordBank3 = { "a", "p", "ent", "enter", "ot", "o", "t" };
		map.clear();
		System.out.println(isStringConstructionPossible(string3, wordBank3));

		String string4 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
		String[] wordBank4 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
		map.clear();
		System.out.println(isStringConstructionPossible(string4, wordBank4));

	}

}
