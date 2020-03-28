import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

	Map<String, Integer> wordCounter;

	public DuplicateCounter() {
		wordCounter = new HashMap<String, Integer>();
	}

	void count(String dataFile) {

		Scanner inputFile = null;

		try {
			inputFile = new Scanner(new File(dataFile));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}

		while (inputFile.hasNext()) {
			String text = inputFile.next().toLowerCase();
			Integer count = wordCounter.get(text);
			if (count == null) {
				count = 1;
			} else {
				count = count + 1;
			}
			wordCounter.put(text, count);
		}
		inputFile.close();

	}

	void write(String outputFile) {
		try {
			PrintWriter output = new PrintWriter(new File(outputFile));
			for (String s : wordCounter.keySet()) {
				output.println(s + " : shows up" + " " + wordCounter.get(s) + " times");
			}
				output.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
