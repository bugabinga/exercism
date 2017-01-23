import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.stream.Collectors.joining;

/**
 * I am Robot.
 * Created by oliver on 12/22/16.
 */
class Robot {
    private String name;

    Robot() {
        reset();
    }

    String getName() {
        return name;
    }

    void reset() {
        //unfortunatelly most of the newer Java-APIs to not include support for the less used types
        //char, short, and byte. That is why there is no random.chars(...) method and we misuse the
        //ints(...) method. This works, because 32bit ints are a superset of 16bit chars.
        //upper bound is exclusive, so we need to add 1 to include Z
        final String twoCharacters = current().ints('A', 'Z' + 1)
                .limit(2)
                //cast is safe because the bounds of random integers lie in range of 16bit chars
                .mapToObj(i -> (char) i)
                //we change the the integer, which is the ascii numeric value of an uppercase character,
                //to a java char and then to a String
                .map(String::valueOf)
                .collect(joining());
        //this format will zero-pad digits with up to 2 zeros. 1 -> 001, 10 -> 010, 100 -> 100
        final String threeDigits = String.format("%03d", current().nextInt(0, 1000));
        name = twoCharacters.concat(threeDigits);
    }
}
