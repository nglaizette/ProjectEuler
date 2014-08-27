package fr.ng.projectEuler.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyTextReader {

	private final String fileToRead;

	public MyTextReader(String fileToRead) {
		this.fileToRead = fileToRead;
	}

	public String[] readFileLineByLine() {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileToRead));
			while (true) {
				String line;
				try {
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
				if (line == null) {
					break;
				} else {
					lines.add(line);
				}
			}

			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lines.toArray(new String[lines.size()]);

	}

}
