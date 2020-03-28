public class Application {
	
	public static void main(String[] args) {
		    DuplicateRemover duplicateRemover = new DuplicateRemover();
		    duplicateRemover.remove("problem1.txt");
		    duplicateRemover.write("unique_words.txt");
			System.out.println("Added non duplicated words to unique_word.txt file");
	}

}
