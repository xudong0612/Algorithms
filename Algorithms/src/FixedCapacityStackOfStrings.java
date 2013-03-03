public class FixedCapacityStackOfStrings extends StackOfStrings {
	private String[] s;
	private int N = 0;

	public FixedCapacityStackOfStrings(int capacity) {
		s = new String[capacity];
	}

	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		s[N++] = item;
	}
	
	public String pop() {
		return s[--N];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOfStrings stack = new FixedCapacityStackOfStrings(10);
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("-"))
				StdOut.print(stack.pop() + " ");
			else
				stack.push(s);
		}
	}

}
