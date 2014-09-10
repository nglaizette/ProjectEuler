package fr.ng.sedgewick.union;

public interface IUnionFind {

	/**
	 * add connection between p and q
	 * 
	 * @param p
	 * @param q
	 */
	public abstract void union(int p, int q);

	/**
	 * Are p and q in the same component?
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public abstract boolean connected(int p, int q);

	/**
	 * Component identifier for p.
	 */
	public abstract int find(int p);

	/**
	 * Returns the number of components.
	 */
	public abstract int count();

}
