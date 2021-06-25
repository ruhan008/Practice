package ds.algo.Expert.Tabulation;

public class GridTraveller {

	public static int getMaximumWays(int m, int n) {

		int[][] table = new int[m + 1][n + 1];
		table[1][1] = 1;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i + 1 <= m) {
					table[i + 1][j] += table[i][j];
				}
				if (j + 1 <= n) {
					table[i][j + 1] += table[i][j];
				}
			}
		}

		return table[m][n];
	}

	public static void main(String[] args) {
		System.out.println(getMaximumWays(1, 1));
		System.out.println(getMaximumWays(2, 3));
		System.out.println(getMaximumWays(3, 2));
		System.out.println(getMaximumWays(3, 3));
		System.out.println(getMaximumWays(18, 18));
	}

}
