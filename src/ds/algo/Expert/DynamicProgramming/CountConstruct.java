package ds.algo.Expert.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

	private static Map<String, Integer> map = new HashMap<>();

	public static int getNumberOfWaysToConstruct(String target, String[] array) {

		if (map.containsKey(target)) {
			return map.get(target);
		}

		if (target.equals("")) {
			return 1;
		}

		int totalWays = 0;

		for (int i = 0; i < array.length; i++) {
			if (target.indexOf(array[i]) == 0) {
				String suffix = target.substring(array[i].length(), target.length());
				int count = getNumberOfWaysToConstruct(suffix, array);
				totalWays += count;
			}
		}

		map.put(target, totalWays);
		return totalWays;
	}

	public static void main(String[] args) {

		String string4 = "purple";
		String[] wordBank4 = { "purp", "p", "ur", "le", "purpl" };
		map.clear();
		System.out.println(getNumberOfWaysToConstruct(string4, wordBank4));

		String string = "abcdef";
		String[] wordBank = { "ab", "abc", "cd", "def", "abcd" };
		map.clear();
		System.out.println(getNumberOfWaysToConstruct(string, wordBank));

		String string2 = "skateboard";
		String[] wordBank2 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
		map.clear();
		System.out.println(getNumberOfWaysToConstruct(string2, wordBank2));

		String string3 = "enterapotentpot";
		String[] wordBank3 = { "a", "p", "ent", "enter", "ot", "o", "t" };
		map.clear();
		System.out.println(getNumberOfWaysToConstruct(string3, wordBank3));

		String string5 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
		String[] wordBank5 = { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" };
		map.clear();
		System.out.println(getNumberOfWaysToConstruct(string5, wordBank5));
	}

}
