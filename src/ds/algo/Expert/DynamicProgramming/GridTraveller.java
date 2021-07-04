package ds.algo.Expert.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

	private static Map<Map<Long, Long>, Long> map = new HashMap<>();

	private static Map<String, Long> map2 = new HashMap<>();

	public static long getMaximumWaysToTravell(long m, long n) {

		if (m == 1 && n == 1) {
			return 1;
		}

		if (m == 0 || n == 0) {
			return 0;
		}

		Map<Long, Long> tmpMap = new HashMap<>();
		tmpMap.put(m, n);

		if (map.containsKey(tmpMap)) {
			return map.get(tmpMap);
		}

		map.put(tmpMap, getMaximumWaysToTravell(m - 1, n) + getMaximumWaysToTravell(m, n - 1));

		return map.get(tmpMap);
	}

	public static long getMaximumWaysToTravelAlternate(long m, long n) {

		if (m == 1 && n == 1) {
			return 1;
		}

		if (m == 0 || n == 0) {
			return 0;
		}

		if (map2.containsKey(m + "," + n) || map2.containsKey(n + "," + m)) {
			return map2.get(m + "," + n);
		}

		map2.put(m + "," + n, getMaximumWaysToTravell(m - 1, n) + getMaximumWaysToTravell(m, n - 1));

		return map2.get(m + "," + n);
	}

	public static void main(String[] args) {
		//remember to reinitialize the Map before every recursive call so that its empty for next calculation
		
		System.out.println(getMaximumWaysToTravell(1, 1));
		map.clear();
		System.out.println(getMaximumWaysToTravell(2, 3));
		map.clear();
		System.out.println(getMaximumWaysToTravell(3, 2));
		map.clear();
		System.out.println(getMaximumWaysToTravell(3, 3));
		map.clear();
		long start1 = System.currentTimeMillis();
		System.out.println(getMaximumWaysToTravell(18, 18));
		System.out.println(System.currentTimeMillis() - start1 + " ms");
		long start2 = System.currentTimeMillis();
		System.out.println(getMaximumWaysToTravelAlternate(18, 18));
		System.out.println(System.currentTimeMillis() - start2 + " ms");
	}

}
