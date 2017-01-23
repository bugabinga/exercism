import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Bob the Teenager.
 * Created by oliver on 12/21/16.
 */
class Bob {
    String hey(String text) {
        //in practice the input text should probably be trimmed in any case
        //but trimming here is the minimal change necessary to satisfy the tests
        if (text.trim().isEmpty())
            return "Fine. Be that way!";

        //the first condition is necessary, because the allMatch
        //method returns true in case of empty stream.
        if (text.chars().anyMatch(Character::isLetter)
                && text.equals(text.toUpperCase()))
            return "Whoa, chill out!";

        if (text.endsWith("?"))
            return "Sure.";

        return "Whatever.";
    }
}
