public class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0)
						cnt++;
				}
		return cnt;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] a = In.readInts(args[0]);
		int N = Integer.parseInt("2000");
		int[] a = new int[N];
		for(int i=0;i<N;i++) {
			a[i] = StdRandom.uniform(-1000000, 1000000);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		double time = timer.elapsedTime();
		StdOut.println(cnt + " triples " + time);
	}
}

class Stopwatch {
	private final long start;

	public Stopwatch() {
		start = System.currentTimeMillis();
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
}