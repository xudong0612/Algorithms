public class WeightedQuickUnion {
	private int[] id;
	private int[] sz;
	private int count;

	public WeightedQuickUnion(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
		}
	}

	public int count() {
		return count;
	}

	private int find(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = StdIn.readInt();
		WeightedQuickUnion wqu = new WeightedQuickUnion(N);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			/* Terminal condition
			if( p == -1) {
				break;
			}
			*/
			int q = StdIn.readInt();
			if(wqu.connected(p, q))
				continue;
			wqu.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(wqu.count + " components");
	}

}
