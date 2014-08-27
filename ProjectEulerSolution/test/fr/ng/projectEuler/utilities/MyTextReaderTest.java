package fr.ng.projectEuler.utilities;

public class MyTextReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyTextReader toto = new MyTextReader(
		        "/Users/nicolasglaizette/git/ProjectEuler/ProjectEulerSolution/Data/DataProject13.txt");
		String[] tutu = toto.readFileLineByLine();

		int count = 0;
		for (String string : tutu) {
			count++;
			System.out.println(count + ": " + string);
		}
	}

}
