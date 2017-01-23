import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Write a program that calculates the moment when someone has lived for 10^9 seconds.
 * Created by oliver on 12/28/16.
 */
class Gigasecond {
    private static final long GIGA_SECOND = 1000000000;
    private final LocalDateTime gigaDate;

    Gigasecond(LocalDateTime startDateTime) {
        gigaDate = startDateTime.plusSeconds(GIGA_SECOND);
    }

    Gigasecond(LocalDate startDate) {
        this(startDate.atStartOfDay());
    }

    LocalDateTime getDate() {
        return gigaDate;
    }
}
