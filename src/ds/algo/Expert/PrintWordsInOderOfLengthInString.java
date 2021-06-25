package ds.algo.Expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PrintWordsInOderOfLengthInString {

	public static void main(String[] args) {
		String sample = "Lorem ipsum dolor sit amet, consectetur adipiscing sit";
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(sample.split(" ")));
//		int n = sample.length();
//		int i = 0;
//		int lastWordAt = 0;
//		while (i < n) {
//			if (sample.charAt(i) == (' ')) {
//				list.add(sample.substring(lastWordAt, i));
//				lastWordAt = i + 1;
//			}
//			i++;
//		}
//
//		for (String s : list) {
//			System.out.println(s);
//		}
//
//		ArrayList<String> sorted = new ArrayList<String>();
//		int size = list.size();
//		System.out.println(size);

		list.stream().sorted(Comparator.comparing(s -> s.length())).forEach(System.out::println);
		String s1 = "hello";
		String s2 = "helle";
		System.out.println(list.stream().collect(Collectors.toMap(s->s, s-> (1),Integer::sum)));
		System.out.println(s1.compareTo(s2));
	}
}
