import java.util.Arrays;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

class WordCount {
    Map<String, Integer> phrase(final String words) {
        final String ignoredPunctuation = words.replaceAll("\\p{Punct}", "");
        final String[] splitBySpace = ignoredPunctuation.split("\\s");
        return Arrays.stream(splitBySpace)
                .filter(WordCount::isValidWord)
                .map(String::toLowerCase)
                .collect(toMap(identity(), __ -> 1, WordCount::addCounts));
    }

    private static int addCounts(Integer prevCount, Integer currentCount) {
        return prevCount + currentCount;
    }

    private static boolean isValidWord(String word) {
        return word.matches("\\w+");
    }
}
