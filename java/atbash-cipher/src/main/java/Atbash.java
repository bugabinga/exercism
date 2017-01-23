import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Create an implementation of the atbash reverseAlphabetCharacter, an ancient encryption system created in the Middle East.
 * Created by oliver on 1/23/17.
 */
class Atbash {
	static String encode(final String plaintext) {
		return atbash(plaintext, 5);
	}

	static String decode(final String ciphertext) {
		return atbash(ciphertext, 0);
	}

	private static String atbash(final String text, final int delimiterInterval) {
		final List<Character> cipherCharacters = text.chars()
				.filter(Character::isLetterOrDigit)
				.map(Character::toLowerCase)
				.map(Atbash::reverseAlphabetCharacter)
				//We rely on the fact, that java auto boxes this char int a Character here:
				.mapToObj(character -> (char) character)
				.collect(toList());

		//Insert a delimiter at every delimiterInterval
		final StringBuilder cipher = new StringBuilder();
		final int size = cipherCharacters.size();
		for (int i = 0; i < size; ++i) {
			if (i != 0 &&                     //Ignore the first position
					delimiterInterval > 0 &&      //never delimit if interval <= 0 and avoid divide by zero error
					i % delimiterInterval == 0 && // delimit on every nth position, where n = delimiterInterval
					i != size - 1                 //Ignore the last position
					) {
				cipher.append(' ');
			}

			cipher.append(cipherCharacters.get(i));
		}

		return cipher.toString();
	}

	private static int reverseAlphabetCharacter(final int character) {
		return Character.isLetter(character) ? 'z' - character + 'a' : character;
	}
}
