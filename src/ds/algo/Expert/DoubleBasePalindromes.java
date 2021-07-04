package ds.algo.Expert;

public class DoubleBasePalindromes {

	public static boolean isPalindrome(int number) {

		int remainder = 0;
		int reverse = 0;
		int check = number;

		while (check > 0) {
			remainder = check % 10;
			reverse = (reverse * 10) + remainder;
			check = check / 10;
		}
//		System.out.println("reverse = " + reverse);
		if (reverse == number) {
			return true;
		}
		return false;

	}

	public static boolean isPalindromeForBinary(String binary) {
		StringBuilder builder = new StringBuilder(binary);
		String revString = builder.reverse().toString();
		if (revString.equals(binary)) {
			return true;
		}
		return false;
	}

	public static String getBinary(int number) {
		String binaryString = "";
		int quotient = 0;
		while (number > 0) {
			quotient = number % 2;
			binaryString = binaryString + String.valueOf(quotient);
			number = number / 2;
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append(binaryString);
		buffer.reverse();
		return buffer.toString();
	}

	public static void main(String[] args) {
		int maximum = 5;
		int sum = 0;
		for (int i = 1; i <= maximum; i++) {
			if (isPalindrome(i)) {
				String binaryString = getBinary(i);
//				System.out.println(binaryString);
				if (isPalindromeForBinary(binaryString)) {
					System.out.println(i);
					sum += i;
				}
			}
		}
		System.out.println("Sum of double base palindromes till " + maximum + " is : " + sum);
//		System.out.println(isPalindrome(maximum));
//		System.out.println(getBinary(maximum));

	}

}
