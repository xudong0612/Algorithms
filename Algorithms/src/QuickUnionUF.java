public class QuickUnionUF {
	private int[] id;
	private int count;
	
	public QuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public int count() {
		return count;
	}
	
	private int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		id[i] = j;
		count--;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		QuickUnionUF qu = new QuickUnionUF(N);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			/* Terminal condition
			if( p == -1) {
				break;
			}
			*/
			int q = StdIn.readInt();
			if(qu.connected(p, q))
				continue;
			qu.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(qu.count + " components");
	}
}