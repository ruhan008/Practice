package ds.algo.Expert;

public class RecursiveStringReverse {
	public static void main(String[] args) {
		String a = "apple";
		String string = a.replace("ppl", "3");
		System.out.println(string);

		String reverseString = reverse(a);
		System.out.println(reverseString);
	}

	private static String reverse(String original) {
		if (original.isEmpty()) {
			return original;
		}

		return reverse(original.substring(1)) + original.charAt(0);
	}
}
