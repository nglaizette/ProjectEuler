package fr.ng.sedgewick.union;

public class WeightedQuickUnionFind implements IUnionFind {
	private final int[] id;
	private final int[] sz;

	public WeightedQuickUnionFind(int n) {
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];// Path compression
			i = id[i];
		}
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#union(int, int)
	 */
	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) {
			return;
		} else if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#connected(int, int)
	 */
	@Override
	public boolean connected(int p, int q) {

		return root(p) == root(q);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#find(int)
	 */
	@Override
	public int find(int p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
