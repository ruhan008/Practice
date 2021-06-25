package ds.algo.Expert;

public class DemoCode {

	public static void main(String[] args) {

//		This program is to reverse a string;
		String S1 = "Ce";
		String S2 = "iJ";
		String finalString = S1.concat(S2);
		char[] arr = finalString.toCharArray();
		int n = finalString.length();
		String rev = "";
		for (int i = n - 1; i >= 0; i--) {
			rev = rev + arr[i];
		}

		System.out.println(rev);

//		This Program is to find the sum of integers in a string
		String intString = "1abc23";
		int nLength = intString.length();
		int sum = 0;
		String temp = "0";
		for (int i = 0; i < nLength; i++) {
			char check = intString.charAt(i);
			if (Character.isDigit(check)) {
				temp += check;
			} else {
				sum = sum + Integer.parseInt(temp);
				temp = "0";
			}
		}
		sum = sum + Integer.parseInt(temp);
		System.out.println(sum);

		/*
		 * This Program is to Find the number of goals on penalties 1 - goal 0 - No goal
		 * 2 - penalty
		 */
		String S = "1012012112110";
		int ngop = S.length();
		int gop = 0;
		for (int i = 0; i < ngop; i++) {
			char ch = S.charAt(i);
			if (ch == '2' && (i + 1) < ngop) {
				if (S.charAt(i + 1) == '1') {
					gop += 1;
				}
			}
		}
		System.out.println("gop = " + gop);

	}

}
