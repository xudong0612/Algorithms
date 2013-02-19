public class QuickFindUF {
	private int[] id;
	private int count;

	public QuickFindUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public int find(int p) {
		return id[p];
	}

	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		if (qid == pid)
			return;
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid)
				id[i] = qid;
		}
		count--;
	}

	public void print() {
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + "\t");
		}
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		QuickFindUF qf = new QuickFindUF(N);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			/* Terminal condition
			if( p == -1) {
				break;
			}
			*/
			int q = StdIn.readInt();
			if(qf.connected(p, q))
				continue;
			qf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(qf.count + " components");
	}
}
