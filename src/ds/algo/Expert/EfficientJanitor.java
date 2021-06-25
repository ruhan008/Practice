package ds.algo.Expert;

import java.util.List;

public class EfficientJanitor {

	public static void main(String[] args) {

		List<Float> weights = List.of(1.01F, 1.01F, 1.01F, 1.4F, 2.4F);
		int n = weights.size();

		int trips = 0;
		Float tripWeight = 0.00F;

		for (int i = 0; i < n; i++) {
			tripWeight += weights.get(i);
			if (tripWeight > 3.00F) {
				trips += 1;
				System.out.println(tripWeight);
				tripWeight = weights.get(i);
			}
		}
		if (tripWeight > 0.00F) {
			trips += 1;
		}

		System.out.println("No. of trips required = " + trips);

	}

}
