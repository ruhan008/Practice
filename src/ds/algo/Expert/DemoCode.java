package ds.algo.Expert;

import java.util.*;

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
		String[] a = {"2","3"};
		List<String> list = new ArrayList<>(Arrays.asList(a));
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
		
		System.out.println("-------------------------");
		System.out.println(func(12));
		factorial1(4);
		factorial2(4);
	}
	
	public static int func(int n) {
	       if (n == 1)
	           return 0;
	       else
	           return 1 + func(n/2);
	   }

	public static void factorial1(int n) {

        int factorial = 1;
        int index = 1;
        for (int i = 0; i <= Math.pow(n, n); i++) {
            if (i == factorial * index) {
                factorial = i;
                index += 1;
                if (index == n + 1) {
                    System.out.println(factorial);
                    break;
                }
            }
        }
    }
	
	public static void factorial2(int n) {
        int[] factorials = new int[n + 1];
        Arrays.fill(factorials, 1);
        for (int i = 0; i <= n - 1; i++) {
            factorials[i + 1] = (i + 1) * factorials[i];
        }
        System.out.println(factorials[n]);

//		System.out.println("Enter input");
//		Scanner input = new Scanner(System.in);
//		int nc = input.nextInt();
//		List<String> tmpString = new ArrayList<>();
//		input.nextLine();
//		for(int i =0; i<nc; i++){
//				 tmpString.add(input.nextLine());
//		}
//
//		List<List<Integer>> graph = tmpString.stream()
//				.map(line -> new ArrayList<>(Arrays.asList(line.split(" ")))
//				.stream().map(Integer::parseInt).collect(Collectors.toList()))
//				.collect(Collectors.toList());
//		System.out.println(graph);

    }

}
