import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;

/**
 * Write a function to convert from normal numbers to Roman Numerals.
 * Created by oliver on 12/31/16.
 */
class RomanNumeral {

	private static final Map<Integer, String> arabicToRomanDigits = new HashMap<>(28);

	static {
		arabicToRomanDigits.put(0, "");
		arabicToRomanDigits.put(1, "I");
		arabicToRomanDigits.put(2, "II");
		arabicToRomanDigits.put(3, "III");
		arabicToRomanDigits.put(4, "IV");
		arabicToRomanDigits.put(5, "V");
		arabicToRomanDigits.put(6, "VI");
		arabicToRomanDigits.put(7, "VII");
		arabicToRomanDigits.put(8, "VIII");
		arabicToRomanDigits.put(9, "IX");
		arabicToRomanDigits.put(10, "X");
		arabicToRomanDigits.put(20, "XX");
		arabicToRomanDigits.put(30, "XX");
		arabicToRomanDigits.put(40, "XL");
		arabicToRomanDigits.put(50, "L");
		arabicToRomanDigits.put(60, "LX");
		arabicToRomanDigits.put(70, "LXX");
		arabicToRomanDigits.put(80, "LXXX");
		arabicToRomanDigits.put(90, "XC");
		arabicToRomanDigits.put(100, "C");
		arabicToRomanDigits.put(200, "CC");
		arabicToRomanDigits.put(300, "CCC");
		arabicToRomanDigits.put(400, "CD");
		arabicToRomanDigits.put(500, "D");
		arabicToRomanDigits.put(600, "DC");
		arabicToRomanDigits.put(700, "DCC");
		arabicToRomanDigits.put(800, "DCCC");
		arabicToRomanDigits.put(900, "CM");
		arabicToRomanDigits.put(1000, "M");
		arabicToRomanDigits.put(2000, "MM");
		arabicToRomanDigits.put(3000, "MMM");
	}

	private final String romanNumeral;

	RomanNumeral(final int arabicNumeral) {
		final char[] numeralCharacters = Integer.toString(arabicNumeral).toCharArray();
		final int length = numeralCharacters.length;
		final StringBuilder romanBuffer = new StringBuilder();

		//This loop iterates through all digits of the numeral,
		//then recreating the decimal value at the position of the digit
		//for example: "1234" becomes "1000", "200", "30" and "4".
		//these numerals can then be easily converted to roman.
		for (int i = 0; i < length; ++i) {
			final int numericValue = Character.getNumericValue(numeralCharacters[i]);

			final int positionalDecimal = toIntExact(round(numericValue * pow(10, length - i - 1)));
			romanBuffer.append(arabicToRomanDigits.getOrDefault(positionalDecimal, ""));
		}

		romanNumeral = romanBuffer.toString();
	}

	String getRomanNumeral() {
		return romanNumeral;
	}
}
