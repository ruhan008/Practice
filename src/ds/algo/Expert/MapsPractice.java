package ds.algo.Expert;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapsPractice {
	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Amit");
		map.put(2, "Vijay");
		map.put(3, "Ravi");
		map.put(3, "Shyam");
		

		System.out.println("Size of map = " + map.size());

		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + ":" + m.getValue());
		}

		System.out.println("Using entryset directly");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

		System.out.println("Using entryset directly in descending order");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEach(System.out::println);

		System.out.println("comparingByValue()");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		System.out.println(map);

		StringBuffer buf = new StringBuffer();
		for (Map.Entry<Integer, String> m : map.entrySet()) {
			buf.append(m.getValue());
			buf.append(" ");
		}
		String str = buf.toString();
		
		System.out.println(str);
		

	}
}
