/**
 * Write a program that cleans up user-entered phone numbers so that they can be sent SMS messages.
 * Created by oliver on 12/27/16.
 */
class PhoneNumber {
    private final static String BAD_NUMBER = "0000000000";
    private static final String LOCAL_PREFIX = "1";

    private final String number;

    PhoneNumber(String inputNumber) {
        this.number = sanitizePhoneNumber(inputNumber);
    }

    private static String sanitizePhoneNumber(String inputNumber) {
        //remove everything that is NOT a digit
        final String digits = inputNumber.replaceAll("[^\\d]", "");

        if (digits.length() == 10)
            return digits;
        else if (digits.length() == 11 && digits.startsWith(LOCAL_PREFIX))
            return digits.replaceFirst(LOCAL_PREFIX, "");

        return BAD_NUMBER;
    }

    String getNumber() {
        return number;
    }

    String getAreaCode() {
        return number.substring(0, 3);
    }

    String pretty() {
        //the `getAreaCode` method is not resused here on purpose. the idea is to firstly,
        //make the destructuring of the number via subsrting obvious and easy to follow (from
        //index 0 to index 6 to rest);
        //secondly, keep the display logic seperate from the business logic.
        return String.format("(%s) %s-%s", number.substring(0, 3), number.substring(3, 6), number.substring(6));
    }
}
