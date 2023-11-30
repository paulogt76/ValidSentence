package validSentence;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testValidSentence {
	 @Test
	    public void testHasCapitalLetter() {
	        assertTrue(ValidSentence.hasCapitalLetter("The quick brown fox said “hello Mr lazy dog”."));
	        assertFalse(ValidSentence.hasCapitalLetter("the quick brown fox said “hello Mr lazy dog”."));
	    }

	    @Test
	    public void testHasEvenQuotationMarks() {
	        assertTrue(ValidSentence.hasEvenQuotationMarks("The quick brown fox said “hello Mr lazy dog”."));
	        assertFalse(ValidSentence.hasEvenQuotationMarks("\"The quick brown fox said “hello Mr lazy dog.\""));
	    }

	    @Test
	    public void testEndsWithCorrectTermination() {
	        assertTrue(ValidSentence.endsWithCorrectTermination("The quick brown fox said “hello Mr lazy dog”."));
	        assertFalse(ValidSentence.endsWithCorrectTermination("The quick brown fox said “hello Mr lazy dog"));
	    }

	    @Test
	    public void testCheckForOnePeriod() {
	        assertTrue(ValidSentence.checkForonePeriod("One lazy dog is too few, 13 is too many."));
	        assertFalse(ValidSentence.checkForonePeriod("The quick brown fox said \"hello Mr. lazy dog\"."));
	        assertFalse(ValidSentence.checkForonePeriod("There is no punctuation in this sentence"));
	        
	       
	    }

	    @Test
	    public void testChecksForNumbersBelow13() {
	        assertTrue(ValidSentence.checksForNumbersBelow13("One lazy dog is too few, 13 is too many."));
	        assertFalse(ValidSentence.checksForNumbersBelow13("One lazy dog is too few, 12 is too many."));
	    }
	}