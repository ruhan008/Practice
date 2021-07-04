package ds.algo.Expert;

import java.util.HashMap;
import java.util.Map;

public class MinMaxCharacterOccurence {
	public static void main(String[] args) {

		String str = "abcks ahaaaaadcbdls hilasd";
		str = str.replaceAll("\\s", "");
		int min, max;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		char minChar = ' ';
		char maxChar = ' ';

		//////////////////////////////////////////////////

//		System.out.println(str);
//		char string[] = str.toCharArray();
//		int n = string.length;
//		System.out.println(n);
//		int counterArr[] = new int[n];
//		Arrays.fill(counterArr, 1);
//
//		for (int i = 0; i < n; i++) {
//
//			if (counterArr[i] == 0) {
//				continue;
//			}
//
//			for (int j = i + 1; j < n; j++) {
//
//				if (string[i] == string[j]) {
//					counterArr[j] = 0;
//					counterArr[i] += 1;
//				}
//			}
//			if (counterArr[i] > max) {
//				max = counterArr[i];
//				maxChar = string[i];
//			}
//
//			if (counterArr[i] < min) {
//				min = counterArr[i];
//				minChar = string[i];
//			}
//
//		}

		/////////////////////////////////////////////////////

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				int freq = map.get(ch);
				map.put(str.charAt(i), freq + 1);
			} else {
				map.put(ch, 1);
			}

		}

		for (Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
			if (mapEntry.getValue() > max) {
				max = mapEntry.getValue();
				maxChar = mapEntry.getKey();
			}
			if (mapEntry.getValue() < min) {
				min = mapEntry.getValue();
				minChar = mapEntry.getKey();
			}
		}

		System.out.println(map);

		/////////////////////////////////////////////////////////

		System.out.println("Max char = " + maxChar + " Min char = " + minChar);
	}
}
