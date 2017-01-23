/**
 * Write a program that, given an age in seconds, calculates how old someone is in terms of a given planet's solar years.
 * Created by oliver on 12/28/16.
 */
class SpaceAge {
    private final static double EARTH_YEAR_IN_SECONDS = 31557600;
    private static final double MERCURY_ORBITAL_YEAR_IN_EARTH_YEAR = 0.2408467;
    private static final double VENUS_ORBITAL_YEAR_IN_EARTH_YEAR = 0.61519726;
    private static final double MARS_ORBITAL_YEAR_IN_EARTH_YEAR = 1.8808158;
    private static final double JUPITER_ORBITAL_YEAR_IN_EARTH_YEAR = 11.862615;
    private static final double SATURN_ORBITAL_YEAR_IN_EARTH_YEAR = 29.447498;
    private static final double URANUS_ORBITAL_YEAR_IN_EARTH_YEAR = 84.016846;
    private static final double NEPTUNE_ORBITAL_YEAR_IN_EARTH_YEAR = 164.79132;

    private final double seconds;
    private final double earthYears;
    private final double saturnYears;
    private final double uranusYears;
    private final double neptuneYears;
    private final double mercuryYears;
    private final double venusYears;
    private final double marsYears;
    private final double jupiterYears;

    SpaceAge(double seconds) {
        this.seconds = seconds;

        //The solar years are precomputed here, because they will never change during the lifetime
        //of this class and the used memory is negligible.
        earthYears = seconds / EARTH_YEAR_IN_SECONDS;
        mercuryYears = earthYears / MERCURY_ORBITAL_YEAR_IN_EARTH_YEAR;
        venusYears = earthYears / VENUS_ORBITAL_YEAR_IN_EARTH_YEAR;
        marsYears = earthYears / MARS_ORBITAL_YEAR_IN_EARTH_YEAR;
        jupiterYears = earthYears / JUPITER_ORBITAL_YEAR_IN_EARTH_YEAR;
        saturnYears = earthYears / SATURN_ORBITAL_YEAR_IN_EARTH_YEAR;
        uranusYears = earthYears / URANUS_ORBITAL_YEAR_IN_EARTH_YEAR;
        neptuneYears = earthYears / NEPTUNE_ORBITAL_YEAR_IN_EARTH_YEAR;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return earthYears;
    }

    double onMercury() {
        return mercuryYears;
    }

    double onVenus() {
        return venusYears;
    }

    double onMars() {
        return marsYears;
    }

    double onJupiter() {
        return jupiterYears;
    }

    double onSaturn() {
        return saturnYears;
    }

    double onUranus() {
        return uranusYears;
    }

    double onNeptune() {
        return neptuneYears;
    }
}
