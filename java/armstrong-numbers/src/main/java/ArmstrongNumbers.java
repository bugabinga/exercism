import java.util.ArrayList;
import java.util.List;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		int number = numberToCheck;
		final List<Integer> digits = new ArrayList<>();
		while (number > 0) {
			// technically, this adds the digits in reverse order to the list
			// order however, does not matter here since we are after a sum
			digits.add(number % 10);
			number = number / 10;
		}
		int length = digits.size();
		// this number is a double so we can delay the cast to int ater the loop
		double armstrong = 0;
		for (int digit : digits) {
			armstrong = armstrong + Math.pow(digit, length);
		}
		return (int) armstrong == numberToCheck;
	}

}
