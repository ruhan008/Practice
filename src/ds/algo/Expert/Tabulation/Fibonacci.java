package ds.algo.Expert.Tabulation;

import java.util.Arrays;

public class Fibonacci {

	public static long getFib(long n) {

		long[] table = new long[(int) (n + 1)];
		Arrays.fill(table, 0L);
		table[1] = 1L;

		for (int i = 2; i <= (int) n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}

		return table[(int) n];
	}

	public static void main(String[] args) {

		System.out.println(getFib(6));
		System.out.println(getFib(50));
		
	}

}
