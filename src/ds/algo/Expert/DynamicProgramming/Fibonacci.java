package ds.algo.Expert.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Long, Long> map = new HashMap<>();

	public static long fibonacci(long n) {

		if (map.containsKey(n)) {
			return map.get(n);
		}

		if (n == 2) {
			return 1L;
		}

		if (n == 1) {
			return 1L;
		}

		map.put(n, fibonacci(n - 1) + fibonacci(n - 2));
		return map.get(n);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(50));
	}

}
