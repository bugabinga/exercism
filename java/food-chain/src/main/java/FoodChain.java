import java.util.StringJoiner;

class FoodChain
{
  private static final String[] ANIMALS =
      { "fly", "spider", "bird", "cat", "dog", "goat", "cow", "horse" };

  private static String getAnimal( final int number )
  {
    assert number >= 1 && number <= ANIMALS.length;

    return ANIMALS[ number - 1 ];
  }

  private static String firstSentence( final int number )
  {
    assert number >= 1 && number <= ANIMALS.length;

    return "I know an old lady who swallowed a %s.\n".formatted( getAnimal( number ) );
  }

  private static String animalSentence( final int number )
  {
    assert number >= 1 && number <= ANIMALS.length;

    return switch ( number )
        {
          case 1, 8 -> "";
          case 2 -> "It wriggled and jiggled and tickled inside her.\n";
          case 3 -> "How absurd to swallow a bird!\n";
          case 4 -> "Imagine that, to swallow a cat!\n";
          case 5 -> "What a hog, to swallow a dog!\n";
          case 6 -> "Just opened her throat and swallowed a goat!\n";
          case 7 -> "I don't know how she swallowed a cow!\n";
          default -> throw new IllegalArgumentException(
              "Given number '%d' has no corresponding animal.".formatted( number ) );
        };
  }

  private static String swallowSentence( final int number )
  {
    assert number >= 1 && number <= ANIMALS.length;

    if ( number == 1 )
    {
      return "";
    }
    final var wriggler_and_tickler = number == 3 ? " that wriggled and jiggled and tickled inside her" : "";
    return "She swallowed the %s to catch the %s%s.\n".formatted( getAnimal( number ), getAnimal( number - 1 ),
        wriggler_and_tickler );
  }

  private static String lastSentence( final int number )
  {
    assert number >= 1 && number <= ANIMALS.length;

    if ( number == ANIMALS.length )
    {
      return "She's dead, of course!";
    }
    return "I don't know why she swallowed the fly. Perhaps she'll die.";
  }

  String verse( final int number )
  {
    final var builder = new StringBuilder();
    builder.append( firstSentence( number ) );
    builder.append( animalSentence( number ) );
    if ( number != ANIMALS.length )
    {
      //reverse loop
      for ( int verse = number; verse > 0; --verse )
      {
        builder.append( swallowSentence( verse ) );
      }
    }
    builder.append( lastSentence( number ) );
    return builder.toString();
  }

  String verses( final int start, final int end )
  {
    final var joiner = new StringJoiner( "\n\n" );
    for ( int verse = start; verse <= end; verse++ )
    {
      joiner.add( verse( verse ) );
    }
    return joiner.toString();
  }
}