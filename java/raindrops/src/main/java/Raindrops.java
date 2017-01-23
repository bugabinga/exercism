import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Write a program that converts a number to a string, the contents of which depend on the number's factors.
 * Created by oliver on 1/22/17.
 */
class Raindrops {
	static String convert(final Integer number) {

		final Entry<Integer, String> pling = new SimpleEntry<>(3, "Pling");
		final Entry<Integer, String> plang = new SimpleEntry<>(5, "Plang");
		final Entry<Integer, String> plong = new SimpleEntry<>(7, "Plong");

		final String raindrops = Stream.of(pling, plang, plong)
				.parallel()
				.filter(entry -> isDivisibleBy(number, entry.getKey()))
				.map(Entry::getValue)
				.collect(joining());

		return raindrops.isEmpty() ? number.toString() : raindrops;
	}

	private static boolean isDivisibleBy(final int number, final int divisor) {
		return number % divisor == 0;
	}
}
