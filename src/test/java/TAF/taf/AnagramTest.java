package TAF.taf;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import anagram.Anagram;

public class AnagramTest {

	@Test
	public void testCheckForIsogram() {
		assertEquals(true, Anagram.isAnagram("JAVA", "Java"));
		assertEquals(true, Anagram.isAnagram("a gentleman", "elegant man"));
		assertEquals(true, Anagram.isAnagram("Debit card", "Bad credit"));
		assertEquals(true, Anagram.isAnagram("Dormitory ", "Dirty room"));
		assertEquals(false, Anagram.isAnagram(" Mother-in-law", "Hitler woman"));

	}
}
