import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/**
 * Implement the `accumulate` operation, which, given a collection and an operation to perform on each element of the collection, returns a new collection containing the result of applying that operation to each element of the input collection.
 * Created by oliver on 1/29/17.
 */
interface Accumulate {
	static <T, R> Collection<R> accumulate(final Collection<T> collection, final Function<T, R> transformer)
	{
		final Collection<R> transformed = new ArrayList<R>(collection.size());

		for (final T item : collection)
			transformed.add(transformer.apply(item));

		return transformed;
	}
}
