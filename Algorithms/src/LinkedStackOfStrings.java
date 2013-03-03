public class LinkedStackOfStrings extends StackOfStrings {
	private Node first = null;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOfStrings stack = new LinkedStackOfStrings();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("-"))
				StdOut.print(stack.pop() + " ");
			else
				stack.push(s);
		}
	}

}
