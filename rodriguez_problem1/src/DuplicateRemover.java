import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

	Set<String> uniqueWords;
	
	public DuplicateRemover () {
		uniqueWords = new HashSet<>();
	}

	void remove(String dataFile) {

		Scanner inputFile = null;

		try {
			inputFile = new Scanner(new File(dataFile));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}

		while (inputFile.hasNext()) {
			String text = inputFile.next().toLowerCase();
			uniqueWords.add(text);
		}
		   inputFile.close();
	}

	void write(String outputFile) {
		try {
			PrintWriter output = new PrintWriter(new File(outputFile));
			for (String s : uniqueWords) {
				output.println(s);
			}
				output.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
