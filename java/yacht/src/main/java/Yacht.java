import java.util.stream.IntStream;

class Yacht
{

  private final int[]         dice;
  private final YachtCategory yachtCategory;

  Yacht( final int[] dice, final YachtCategory yachtCategory )
  {
    this.dice = dice;
    this.yachtCategory = yachtCategory;
  }

  int score()
  {
    return switch ( yachtCategory )
        {
          case YACHT -> yacht( dice );
          case ONES -> ones( dice );
          case TWOS -> twos( dice );
          case THREES -> threes( dice );
          case FOURS -> fours( dice );
          case FIVES -> fives( dice );
          case SIXES -> sixes( dice );
          case FULL_HOUSE -> fullHouse( dice );
          case FOUR_OF_A_KIND -> fourOfAKind( dice );
          case LITTLE_STRAIGHT -> littleStraight( dice );
          case BIG_STRAIGHT -> bigStraight( dice );
          case CHOICE -> choice( dice );
        };
  }

  private static int choice( final int[] dice )
  {
    return IntStream.of( dice ).sum();
  }

  private static int bigStraight( final int[] dice )
  {
    return straight( dice, ( 2 + 3 + 4 + 5 + 6 ) );
  }

  private static int littleStraight( final int[] dice )
  {
    return straight( dice, ( 1 + 2 + 3 + 4 + 5 ) );
  }

  private static int straight( final int[] dice, final int expectedSum )
  {
    final var countOfUniqueDice = IntStream.of( dice ).distinct().count();
    final var sum = IntStream.of( dice ).sum();
    return countOfUniqueDice == 5 && sum == expectedSum ? 30 : 0;
  }

  private static int fourOfAKind( final int[] dice )
  {
    final var countOfUniqueDice = IntStream.of( dice ).distinct().count();
    if ( countOfUniqueDice == 2 )
    {
      final var firstValue = IntStream.of( dice ).max().orElse( 0 );
      final var secondValue = IntStream.of( dice ).min().orElse( 0 );
      if ( IntStream.of( dice ).filter( value -> value == firstValue ).count() == 4 )
      {
        return IntStream.of( dice ).filter( value -> value == firstValue ).sum();
      }
      if ( IntStream.of( dice ).filter( value -> value == secondValue ).count() == 4 )
      {
        return IntStream.of( dice ).filter( value -> value == secondValue ).sum();
      }
    }
    else if ( countOfUniqueDice == 1 )
    {
      return IntStream.of( dice ).limit( 4 ).sum();
    }
    return 0;
  }

  private static int fullHouse( final int[] dice )
  {
    final var countOfUniqueDice = IntStream.of( dice ).distinct().count();
    final var countOfAnyDie = IntStream.of( dice ).filter( value -> value == dice[ 0 ] ).count();
    if (
        countOfUniqueDice == 2
            && ( countOfAnyDie == 2 || countOfAnyDie == 3 )
    )
    {
      return IntStream.of( dice ).sum();
    }
    return 0;
  }

  private static int sixes( final int[] dice )
  {
    return countValue( dice, 6 );
  }

  private static int fives( final int[] dice )
  {
    return countValue( dice, 5 );
  }

  private static int fours( final int[] dice )
  {
    return countValue( dice, 4 );
  }

  private static int threes( final int[] dice )
  {
    return countValue( dice, 3 );
  }

  private static int twos( final int[] dice )
  {
    return countValue( dice, 2 );
  }

  private static int ones( final int[] dice )
  {
    return countValue( dice, 1 );
  }

  private static int countValue( final int[] dice, final int value )
  {
    final var count = IntStream.of( dice ).filter( diceValue -> diceValue == value ).count();
    return Math.toIntExact( value * count );
  }

  private static int yacht( final int[] dice )
  {
    if ( IntStream.of( dice ).distinct().count() == 1 )
    {
      return 50;
    }
    return 0;
  }
}
