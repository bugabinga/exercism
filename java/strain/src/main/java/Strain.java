import java.util.Collection;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Implement the `keep` and `discard` operation on collections. Given a collection and a predicate on the collection's elements, `keep` returns a new collection containing those elements where the predicate is true, while `discard` returns a new collection containing those elements where the predicate is false.
 * <p>
 * Created by oliver on 1/23/17.
 */
class Strain {
	static <T> Collection<T> keep(final Collection<T> collection, final Predicate<T> predicate) {
		return collection.stream().filter(predicate).collect(toList());
	}

	static <T> Collection<T> discard(final Collection<T> collection, final Predicate<T> predicate) {
		return keep(collection, predicate.negate());
	}
}
