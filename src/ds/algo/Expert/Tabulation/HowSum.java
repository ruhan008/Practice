package ds.algo.Expert.Tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowSum {

	public static List<Integer> findIfAnyCombinationPossible(int target, int[] array) {
		int tableLength = target + 1;

		List<List<Integer>> list = new ArrayList<>(tableLength);
		for (int i = 0; i < tableLength; i++) {
			list.add(null);
		}

		list.set(0, new ArrayList<>());

		for (int i = 0; i < tableLength; i++) {
			if (list.get(i) != null) {
				List<Integer> tmpCheck = list.get(i);
				for (int j = 0; j < array.length; j++) {
					if ((i + array[j]) < tableLength) {
						List<Integer> tmp = new ArrayList<>(tmpCheck);
						tmp.add(array[j]);
						list.set((i + array[j]), tmp);
//						System.out.println(list.get(i+array[j]));
					}
				}
//				System.out.println(list);
			}
		}

//		System.out.println(list);

		return list.get(target);
	}

	public static void main(String[] args) {

		int[] a1 = { 2, 3 };
		System.out.println(findIfAnyCombinationPossible(7, a1));

		int[] a2 = { 5, 3, 4, 7 };
		System.out.println(findIfAnyCombinationPossible(7, a2));

		int[] a3 = { 7, 14 };
		System.out.println(findIfAnyCombinationPossible(300, a3));

		int[] a4 = { 2, 3, 5 };
		System.out.println(findIfAnyCombinationPossible(8, a4));
	}

}
