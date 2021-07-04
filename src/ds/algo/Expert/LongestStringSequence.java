package ds.algo.Expert;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestStringSequence {

	public static void main(String[] args) {
		String string = "abcdefabcg";

		Map<String, Integer> map = new LinkedHashMap<>();

		Map<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());

		for (int i = 0; i < string.length(); i++) {
			String tmpString = "";
			for (int j = i; j < string.length(); j++) {
				tmpString = tmpString + string.charAt(j);
				if (map.containsKey(tmpString)) {
					int newValue = map.get(tmpString);
					map.put(tmpString, newValue + 1);
				} else {
					map.put(tmpString, 1);
				}
			}
		}

		System.out.println(map);

		for (Map.Entry<String, Integer> mEntry : map.entrySet()) {
			if (mEntry.getValue() > 1) {
				treeMap.put(mEntry.getKey().length(), mEntry.getKey());
			}
		}
		
		System.out.println(treeMap);
		for (Map.Entry<Integer, String> mEntry : treeMap.entrySet()) {
			System.out.println(mEntry.getValue());
			break;
		}

	}

}
