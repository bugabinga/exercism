/**
 * Determine if a sentence is a pangram.
 * Created by oliver on 12/20/16.
 */
class Pangrams {
	static boolean isPangram(final String pangram) {
		return pangram
				.toLowerCase()
				.chars()
				//Filtering out any non-ASCII character
				.filter(Pangrams::isBetweenAandZ)
				//eliminating duplicates
				.distinct()
				//because the lowercase ASCII alphabet has 26 unique characters,
				//we are guaranteed to have the characters from 'a' yo 'z' if
				//there are 26 of them
				.count() == 26;
	}

	private static boolean isBetweenAandZ(final int character) {
		return character >= 'a' && character <= 'z';
	}
}