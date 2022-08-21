package ds.algo.Expert;

import java.util.ArrayList;
import java.util.List;

public class DisplayOnlyPrimeAndDivisibleByWhichPrimeNumbers {

	public static List<Integer> globalPrimeList = new ArrayList<>();

	public static void checkIfDivisibleByPrimeNumberAndPrint(int number) {

		List<Integer> list = new ArrayList<>();

		boolean primeFlag = true;
		for (int j = 2; j <= number / 2; j++) {
			if (number % j == 0 && globalPrimeList.contains(j)) {
				primeFlag = false;
				list.add(j);
			}
		}

		if (primeFlag) {
			globalPrimeList.add(number);
		}

		if (list.size() == 0) {
			System.out.println(number);
		} else {
			System.out.println(list);
		}

	}

	public static void main(String[] args) {

		int n = 20;

		for (int i = 1; i <= n; i++) {
			checkIfDivisibleByPrimeNumberAndPrint(i);
		}
	}

}
