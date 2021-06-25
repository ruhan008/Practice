package ds.algo.Expert;
import java.util.ArrayDeque;
import java.util.Deque;

public class BracketsOrderProcessing {

	public static void main(String[] args) {

//		String sample = "[{([]{()}[]]";
		String sample = "{{[](}}";
		int n = sample.length();
		int flag = 1;
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < n; i++) {
			char a = sample.charAt(i);
			if (a == '{' || a == '[' || a == '(') {
				System.out.println("Pushed " + a);
				stack.push(a);
			}
			if (a == '}' || a == ']' || a == ')') {
				if (stack.isEmpty()) {
					flag = 0;
					break;
				}
				char check = stack.pop();
				System.out.println("Popped " + check);
				switch (check) {
				case '{':
					if (a == ']' || a == ')') {
						flag = 0;

					}
					break;
				case '[':
					if (a == '}' || a == ')') {
						flag = 0;
					}
					break;
				case '(':
					if (a == '}' || a == ']') {
						flag = 0;
						System.out.println(check + "," + a);
					}
					break;
				}

				if (flag == 0) {
					break;
				}

			}

		}
		if (!stack.isEmpty()) {
			flag = 0;
		}

		if (flag == 1) {
			System.out.println("Sample String " + sample + " maintains the order");
		}

		else {
			System.out.println("Sample String " + sample + " does not maintain the order");
		}

	}
}
