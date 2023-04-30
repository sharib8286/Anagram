package anagram;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first String :");
		String inputFirstString = scan.nextLine();

		System.out.println("Enter Second String :");
		String inputSecondString = scan.nextLine();

		boolean isAnagram = isAnagram(inputFirstString, inputSecondString);
	
		System.out.printf("Is Input String %s and %s are Anagrams ? %b %n", inputFirstString, inputSecondString, isAnagram);

	}

	/**
	 * @param str1 {String}
	 * @param str2 {String}
	 * @return true or false as per comparison
	 */
	public static boolean isAnagram(String str1, String str2) {
		// TODO Auto-generated method stub
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		} else if (str1.length() == str2.length()) {
			//First convert to lower case to ignore upper case and lower case difference
			char[] firstString = str1.toLowerCase().toCharArray();
			char[] secondString = str2.toLowerCase().toCharArray();
			// sort arrays
			Arrays.sort(firstString);
			Arrays.sort(secondString);
			// check if arrays are equal
			if (Arrays.equals(firstString, secondString)) {
				return true;
			}
		}
		return false;
	}

}
