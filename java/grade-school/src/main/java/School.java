import java.util.*;
import java.util.function.BiFunction;

/**
 * Write a small archiving program that stores students' names along with the grade that they are in.
 * Created by oliver on 12/27/16.
 */
class School {
    private final Map<Integer, List<String>> internalDb = new HashMap<>();

    Map<Integer, List<String>> db() {
        return Collections.unmodifiableMap(internalDb);
    }

    void add(String name, int grade) {
        internalDb.compute(grade, addToNames(name));
    }

    List<String> grade(int grade) {
        return internalDb.getOrDefault(grade, Collections.emptyList());
    }

    Map<Integer, List<String>> sort() {
        return Collections.unmodifiableMap(new TreeMap<>(internalDb));
    }

    private static BiFunction<Integer, List<String>, List<String>> addToNames(String name) {
        return (__, value) -> {

            //If the value is null, no name has been added yet
            if (value == null)
                return Collections.singletonList(name);

            //Since we cannot know how the list is going to be used,
            //we are choosing the most common, general purpose implementation
            final ArrayList<String> listOfNames = new ArrayList<>();
            //This ordering of adds puts the new name at the front of the list
            //as is required by the specs.
            listOfNames.add(name);
            listOfNames.addAll(value);
            return Collections.unmodifiableList(listOfNames);
        };
    }
}
