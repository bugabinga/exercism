import java.util.Collection;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

/**
 * Write a program that, given a person's allergy score, can tell them whether or not they're allergic to a given item, and their full list of allergies.
 * Created by oliver on 1/22/17.
 */
class Allergies {
	private final List<Allergen> list;

	Allergies(final int score) {
		list = stream(Allergen.values())
				//"score" is a bitmask. Learn more at "http://vipan.com/htdocs/bitwisehelp.html"
				.filter(allergen -> (score & allergen.getScore()) == allergen.getScore())
				.collect(toList());
	}

	boolean isAllergicTo(final Allergen allergen) {
		return getList().contains(allergen);
	}

	Collection<Allergen> getList() {
		return list;
	}
}
