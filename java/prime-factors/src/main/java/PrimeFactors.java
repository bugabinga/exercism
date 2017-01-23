import java.util.List;
import java.util.stream.LongStream;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.LongStream.*;

/**
 * Compute the prime factors of a given natural number.
 * Created by oliver on 12/31/16.
 */
class PrimeFactors {
	static List<Long> getForNumber(final long input) {
		return primeFactors(input).boxed().collect(toList());
	}

	private static LongStream primeFactors(final long number) {
		if (number <= 1L)
			return empty();

		final Long factor = rangeClosed(2, round(sqrt(number)))
				.parallel()
				.filter(possiblePrimeFactor -> isDivisibleBy(number, possiblePrimeFactor))
				.findFirst()
				.orElse(number);

		return concat(of(factor), primeFactors(number / factor));
	}

	private static boolean isDivisibleBy(final long number, final long divisor) {
		return number % divisor == 0;
	}
}