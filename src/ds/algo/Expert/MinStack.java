package ds.algo.Expert;

import java.util.Stack;

class StackElement {

	private Stack<Integer> stack = new Stack<>();
	private int minEle;

	public Stack<Integer> getStack() {
		return this.stack;
	}

	public void push(int element) {
		if (stack.isEmpty()) {
			minEle = element;
			stack.push(element);
			return;
		} else {
			int top = stack.peek();
			if (element > top) {
				stack.push(element);
			} else {
				int modifiedEle = (2 * element) - minEle;
				minEle = element;
				stack.push(modifiedEle);
			}
		}
	}

	public int getMin() {
		return minEle;
	}

	public int pop() {
		int top = stack.peek();
		if (top > minEle) {
			top = stack.pop();
		} else {
			int previousMin = (2 * minEle) - top;
			minEle = previousMin;
			top = stack.pop();
			int actualElement = (top + minEle) / 2;
			top = actualElement;
		}
		return top;
	}

}

public class MinStack {

	public static void main(String[] args) {

		StackElement stackElement = new StackElement();
		System.out.println(stackElement.getMin());
		stackElement.push(4);
		stackElement.push(3);
		stackElement.push(2);
		System.out.println(stackElement.getMin());
		System.out.println(stackElement.getStack());
		System.out.println(stackElement.pop());
		System.out.println(stackElement.getStack());
		System.out.println(stackElement.getMin());

	}

}
