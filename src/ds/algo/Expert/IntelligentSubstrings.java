package ds.algo.Expert;

import java.util.ArrayList;
import java.util.List;

public class IntelligentSubstrings {

	static int maxNormalSubString(char[] P, char[] Q, int K, int N) {

		if (K == 0)
			return 0;

// keeps count of normal characters
		int count = 0;

// indexes of subString
		int left = 0, right = 0;

// maintain length of longest subString
// with at most K normal characters
		int ans = 0;

		while (right < N) {

			while (right < N && count <= K) {

				// get position of character
				int pos = P[right] - 'a';

				// check if current character is normal
				if (Q[pos] == '0') {

					// check if normal characters
					// count exceeds K
					if (count + 1 > K)

						break;

					else
						count++;
				}

				right++;

				// update answer with subString length
				if (count <= K)
					ans = Math.max(ans, right - left);
			}

			while (left < right) {

				// get position of character
				int pos = P[left] - 'a';

				left++;

				// check if character is
				// normal then decrement count
				if (Q[pos] == '0')

					count--;

				if (count < K)
					break;
			}
		}

		return ans;
	}

	public static void getMaxSubString(String checkString,String qString, int k) {
//		String checkString = "giraffe";
		char[] checkChar = checkString.toCharArray();

		int maxLength = 0;
//		String qString = "01111001111111111011111111";
		char[] qChar = qString.toCharArray();
//		int k = 2;
		List<String> maxSubstrings = new ArrayList<>();

		for (int i = 0; i < checkChar.length; i++) {
			int counter = 0;
			int length = 0;
			String string = "";
			for (int j = i; j < checkChar.length; j++) {
				string = string + checkChar[j];
				int index = checkChar[j] - (int) 'a';
				if (qChar[index] == '0') {
					if ((counter + 1) > k) {
						if (length > maxLength) {
							maxLength = length;
						}
						maxSubstrings.add(string.substring(0, length));
						break;
					}
					counter++;
				}
				length++;
				if (counter <= k && j == checkChar.length - 1) {
					if (length > maxLength) {
						maxLength = length;
					}
					maxSubstrings.add(string.substring(0, length));
				}
			}

		}

		final int maxLengthForStream = maxLength;

		System.out.println("The max length of a substring having k = " + k + " normal characters is: " + maxLength);
		maxSubstrings.stream().filter(s -> s.length() == maxLengthForStream).forEach(System.out::println);
	}

//Driver code
	public static void main(String[] args) {
// initialise the String
		String P = "giraffe", Q = "01111001111111111011111111";

		int K = 2;

		int N = P.length();
		// GeeksForGeeksSolution
		System.out.print("GeeksForGeeksSolution: ");
		System.out.println(maxNormalSubString(P.toCharArray(), Q.toCharArray(), K, N));
		System.out.println("-----------------------------------------");
		//Ruhan's Solution for Intelligent sub strings
		System.out.println("Ruhan's solution for Intelligent sub strings:");
		getMaxSubString(P,Q,K);
	}

}
