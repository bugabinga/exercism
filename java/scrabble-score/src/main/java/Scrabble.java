import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Character.toUpperCase;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * Write a program that, given a word, computes the scrabble score for that word.
 * Created by oliver on 12/30/16.
 */
class Scrabble {

	private final static Map<List<Character>, Integer> POINTS = new HashMap<>(7);

	static {
		POINTS.put(asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'), 1);
		POINTS.put(asList('D', 'G'), 2);
		POINTS.put(asList('B', 'C', 'M', 'P'), 3);
		POINTS.put(asList('F', 'H', 'V', 'W', 'Y'), 4);
		POINTS.put(singletonList('K'), 5);
		POINTS.put(asList('J', 'X'), 8);
		POINTS.put(asList('Q', 'Z'), 10);
	}

	private final int score;

	Scrabble(final String scrabbleInput) {
		final String input = cleanupInput(scrabbleInput);
		score = !input.isEmpty() ?
				input.chars()
						.mapToObj(character -> (char) character)
						.mapToInt(Scrabble::scoreCharacter)
						.sum()
				: 0;
	}

	private static Integer scoreCharacter(final Character character) {
		final List<Character> relevantCharacterSet = POINTS.keySet().stream()
				.filter(characterList -> containsIgnoringCase(character, characterList))
				.findFirst()
				.orElse(emptyList());
		//Should the given character not exist in our set, it gets a score of zero, effectively ignoring it.
		return POINTS.getOrDefault(relevantCharacterSet, 0);
	}

	private static boolean containsIgnoringCase(final Character character, final List<Character> characterList) {
		return characterList.contains(character) || characterList.contains(toUpperCase(character));
	}

	private static String cleanupInput(final String input) {
		return input == null || input.trim().isEmpty() ? "" : input;
	}

	int getScore() {
		return score;
	}
}
