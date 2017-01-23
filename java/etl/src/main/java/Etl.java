import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        return old.entrySet().stream()
                .map(entry -> entry.getValue()
                        .stream()
                        .collect(toMap(String::toLowerCase, __ -> entry.getKey(), (key1, __) -> key1)))
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .collect(toMap(Entry::getKey, Entry::getValue));
    }
}