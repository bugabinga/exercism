class BeerSong {

    private static String bottles_of_beer(final int number) {
        if (number == -1) {
            return "99 bottles";
        } else if (number == 0) {
            return "No more bottles";
        } else if (number == 1) {
            return "1 bottle";
        }
        return "%d bottles".formatted(number);
    }

    private static String drink_beer(final int number) {
        assert number >= 0;
        if (number == 0) {
            return "Go to the store and buy some more";
        } else if (number == 1) {
            return "Take it down and pass it around";
        }
        return "Take one down and pass it around";
    }

    private static String verse(final int number) {
        assert number >= 0;

        return "%1$s of beer on the wall, %2$s of beer.%n".formatted(bottles_of_beer(number), bottles_of_beer(number).toLowerCase())
                + "%1$s, %2$s of beer on the wall.%n".formatted(drink_beer(number), bottles_of_beer(number - 1).toLowerCase());
    }

    String sing(final int bottles, final int verses) {
        final StringBuilder builder = new StringBuilder();
        int bottle = bottles;
        // reverse loop
        for (int verse = verses; verse > 0; --verse) {
            builder.append(verse(bottle--));
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    String singSong() {
        return sing(99, 100);
    }
}