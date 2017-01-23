import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Convert a long phrase to its acronym
 * Created by oliver on 12/28/16.
 */
class Acronym {
    static String generate(String phrase) {
        //We clean the phrase by replacing all problematic parts with whitespace
        //so that the processng logic can be simpler.
        final String cleanPhrase = phrase
                //Replace any uppercase letter that directy follows any lowercase letter with itself and
                //whitespace prepended. This deals with CamelCase words,
                .replaceAll("[a-z]([A-Z])", " $1")
                .replaceAll("-", " ");

        return Arrays.stream(cleanPhrase.split("\\s"))
                .map(Acronym::tofirstCharacter)
                .map(String::toUpperCase)
                .collect(joining());
    }

    private static String tofirstCharacter(String word) {
        return word.substring(0, 1);
    }
}
