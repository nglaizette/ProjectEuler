package fr.ng.projectEuler.utilities;

public class QuadraticFormula {
	int a = 0;
	int b = 0;

	public QuadraticFormula(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int eval(int n) {
		return n * n + a * n + b;
	}
}
