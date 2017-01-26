enum Allergen {
    EGGS(1),
    PEANUTS(2),
    SHELLFISH(4),
    STRAWBERRIES(8),
    TOMATOES(16),
    CHOCOLATE(32),
    POLLEN(64),
    CATS(128);

    private final int score;

    Allergen(final int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    boolean isAllergicTo( final int allergyScore )
    {
      //"score" is a bitmask. Learn more at "http://vipan.com/htdocs/bitwisehelp.html"
      //This depends on the fact, that the score values are base 2!
      return (allergyScore & score) == score;
    }
}
