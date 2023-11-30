package validSentence;

public class ValidSentence {

	public static void main(String[] args) {

		String[] validSentences = { "The quick brown fox said “hello Mr lazy dog”.",
				"The quick brown fox said hello Mr lazy dog.", "One lazy dog is too few, thirteen is too many.",
				"One lazy dog is too few, 13 is too many.", "How many lazy dogs are there?" };

		String[] invalidSentences = { "The quick brown fox said \"hello Mr. lazy dog\".",
				"the quick brown fox said “hello Mr lazy dog\".", "\"The quick brown fox said “hello Mr lazy dog.\"",
				"One lazy dog is too few, 12 is too many.", "Are there 11, 12, or 13 lazy dogs?",
				"There is no punctuation in this sentence" };

		// calls the checkIfValid method
		for (int i = 0; i < validSentences.length; i++) {
			checkIfValid(validSentences[i]);
		}
		//calls the checkIfmethod to the non valid sentences
		for (int i = 0; i < invalidSentences.length; i++) {
			checkIfValid(invalidSentences[i]);
		}
	}

	// method to call all methods into one method and check if they are valid or not
	public static boolean checkIfValid(String sentence) {
		boolean valid = true;

		if (!hasCapitalLetter(sentence)) {
			valid = false;
		}
		if (!hasEvenQuotationMarks(sentence)) {
			valid = false;
		}
		if (!endsWithCorrectTermination(sentence)) {
			valid = false;
		}
		if (!checksForNumbersBelow13(sentence)) {
			valid = false;
		}
		// if sentence is valid then print valid
		if (valid) {
			System.out.println(sentence + " - Valid");
		} else {
			// else print invalid
			System.out.println(sentence + " - Invalid");
		}

		return valid;
	}

	// Method to check first letter is Capital - boolean so it returns true/false
	public static boolean hasCapitalLetter(String sentence) {
		// checks the first character of the word is upper case
		return Character.isUpperCase(sentence.charAt(0));
	}

	// Method to check for even quotation marks
	public static boolean hasEvenQuotationMarks(String sentence) {
		// count the quotations
		int count = 0;
		boolean insideQuotation = false;

		// loop to traverse through the string
		for (int i = 0; i < sentence.length(); i++) {
			char current = sentence.charAt(i);
			// cheacks if current index is ""
			if (current == '"') {
				// changes the state to false if it was true
				insideQuotation = !insideQuotation;
				// if false it will increment the count as it has encountered the opening
				// quotation
				if (!insideQuotation) {
					count++;
				}
			}
		}
		// Use mod to check if there is no remainder, making it even
		return count % 2 == 0;
	}

	// Method to check it ends with '.' , '!' or '?'
	public static boolean endsWithCorrectTermination(String sentence) {
		// gets the last index and returns its character
		char lastLetter = sentence.charAt(sentence.length() - 1);
		// check if it ends with correct termnation so returns true
		return lastLetter == '.' || lastLetter == '?' || lastLetter == '!';
	}

	// use to check for at least one period or ending termination
	public static boolean checkForonePeriod(String sentence) {
		// loop through sentence
		for (int i = 0; i < sentence.length(); i++) {
			char current = sentence.charAt(i);
			// checks if current at index i is equal to .
			if (current == '.') {
				// checks if the last index is .
				if (i == sentence.length() - 1) {
					// call method to make sure it will return true with other cases such as ! or ?
					return endsWithCorrectTermination(sentence);
				} else {
					// if the . is not at the end then its false
					return false;
				}
			}
		}
		// if no . is found then will return this method
		return endsWithCorrectTermination(sentence);
	}

	// checks that numbers below 13 are not spelled with numbers and not letters
	public static boolean checksForNumbersBelow13(String sentence) {
		// create an array called words and stores it in words
		// .spilt to spilt each word of the array while handling punctuation and spaces
		String[] words = sentence.split("[\\s,\\.\\?]+");
		// loop through array
		for (int i = 0; i < words.length; i++) {
			// get the current word in the words array
			String word = words[i];
			// use try catch to parse the word as an int
			try {
				// get the int of the word
				int numericValue = Integer.parseInt(word);
				// check if int is less tahn 13
				if (numericValue < 13) {
					return false;
				}
				// use catch and if the word is not an int it will ignore the exception
			} catch (NumberFormatException e) {

			}
		}
		// if loop completes without errors, means int values are 13 or above
		return true;
	}
}
