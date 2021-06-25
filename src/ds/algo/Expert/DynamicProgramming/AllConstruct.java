package ds.algo.Expert.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {

	private static Map<String, List<List<String>>> map = new HashMap<>();

	public static List<List<String>> getAllCombinations(String target, String[] array) {

//		if (map.containsKey(target)) {
//			return map.get(target);
//		}

		if (target.equals("")) {
			return null;
		}

		List<List<String>> result = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {
			if (target.indexOf(array[i]) == 0) {
				String suffix = target.substring(array[i].length(), target.length());
				List<List<String>> suffixWays = getAllCombinations(suffix, array);

				if (suffixWays == null) {
					suffixWays = new ArrayList<>();
					suffixWays.add(new ArrayList<>(Arrays.asList(array[i])));
				} else {
					for (List<String> s : suffixWays) {
						s.add(0, array[i]);
					}
				}

				List<List<String>> totalWays = new ArrayList<>(suffixWays);
				for (List<String> strings : totalWays) {
					result.add(strings);
				}
				
			}
		}

//		map.put(target, result);
		return result;
	}

	public static void main(String[] args) {

		String string4 = "purple";
		String[] wordBank4 = { "purp", "p", "ur", "le", "purpl" };
		map.clear();
		System.out.println(getAllCombinations(string4, wordBank4));

		String string = "abcdef";
		String[] wordBank = { "ab", "abc", "cd", "def", "abcd", "ef", "c" };
		map.clear();
		System.out.println(getAllCombinations(string, wordBank));

		String string2 = "skateboard";
		String[] wordBank2 = { "bo", "rd", "ate", "t", "ska", "sk", "boar" };
		map.clear();
		System.out.println(getAllCombinations(string2, wordBank2));

		String string5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz";
		String[] wordBank5 = { "a", "aa", "aaa", "aaaa", "aaaaa" };
		map.clear();
		System.out.println(getAllCombinations(string5, wordBank5));

	}

}
