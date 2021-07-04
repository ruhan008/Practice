package ds.algo.Expert;

import java.util.ArrayList;
import java.util.List;

public class BuySellStockMaxProfit {

	public static void main(String[] args) {
		List<Integer> stockPrices = new ArrayList<>(List.of(15, 10, 18, 35, 55, 50, 45, 8, 10));

		int min = Integer.MAX_VALUE;
		int profit = 0;

		for (Integer price : stockPrices) {
			if (price < min) {
				min = price;
			} else if (price - min > profit) {
				profit = price - min;
			}
		}
		System.out.println("The max profit obtained is : " + profit);
	}

}
