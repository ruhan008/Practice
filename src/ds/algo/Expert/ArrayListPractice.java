package ds.algo.Expert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListPractice {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("ruhan");
		list.add("farhan");
		list.add("maaz");

		System.out.println("Print using sysout");
		System.out.println(list.get(0));

		System.out.println("Print using iterator");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		list.set(2, "saumya");
		System.out.println(list);

		list.forEach(a -> System.out.println(a));
		
		Collections.reverse(list);
		System.out.println(list);

		System.out.println("Hey There");

	}
}
