/**
 * 
 */
package fr.ng.sedgewick.union;

/**
 * @author nicolasglaizette
 * 
 */
public class QuickUnionUnionFind implements IUnionFind {

	private final int[] id;

	public QuickUnionUnionFind(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
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
		id[i] = j;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.ng.sedgewick.union.IUnionFind#count()
	 */
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
