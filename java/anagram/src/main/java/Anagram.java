import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

/**
 * Checks lists of canditates for anagramness.
 *
 * @author okr
 * @date 21.12.2016
 */
class Anagram {
    private final String string;

    /**
     * @param string The anagram.
     */
    Anagram(String string) {
        this.string = string.toLowerCase();
    }

    /**
     * @param canditates List of possible anagrams.
     * @return List or actual anagrams in list of possible.
     */
    List<String> match(List<String> canditates) {
        return canditates.stream()
                .filter(candidate -> isAnagram(candidate.toLowerCase()))
                .collect(toList());
    }

    private boolean isAnagram(final String candidate) {
        return !candidate.equals(string) && Arrays.equals(string.chars().sorted().toArray(), candidate.chars().sorted().toArray());
    }
}