package fr.ng.sedgewick.union;

import fr.ng.sedgewick.utilities.StdIn;
import fr.ng.sedgewick.utilities.StdOut;

public class QuickFindUnionFind implements IUnionFind {

	private final int[] id;

	/**
	 * Initialize union-find data structure with N objects.
	 */
	public QuickFindUnionFind(int n) {
		this.id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#union(int, int)
	 */
	@Override
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == qid) {
				id[i] = qid;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#connected(int, int)
	 */
	@Override
	public boolean connected(int p, int q) {

		return id[p] == id[q];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#find(int)
	 */
	@Override
	public int find(int p) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#count()
	 */
	@Override
	public int count() {
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = StdIn.readInt();
		IUnionFind uf = new QuickFindUnionFind(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();

			if (!uf.connected(p, q)) {
				uf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}

	}

}
