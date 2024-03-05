import java.util.ArrayList;

class House
{
  private static final String   FIRST_LINE_FORMAT  = "This is the %s";
  private static final String   OTHER_LINES_FORMAT = "that %s the %s";
  private static final String   END                = "that Jack built.";
  private static final String[] THINGS             = {
      "house",
      "malt",
      "rat",
      "cat",
      "dog",
      "cow with the crumpled horn",
      "maiden all forlorn",
      "man all tattered and torn",
      "priest all shaven and shorn",
      "rooster that crowed in the morn",
      "farmer sowing his corn",
      "horse and the hound and the horn"
  };
  private static final String[] ACTIONS            = {
      "lay in",
      "ate",
      "killed",
      "worried",
      "tossed",
      "milked",
      "kissed",
      "married",
      "woke",
      "kept",
      "belonged to",
  };

  static String verse( final int number )
  {
    final var verse = new StringBuilder();
    final int maxVerseIndex = number - 1;
    for ( int verseIndex = maxVerseIndex; verseIndex >= 0; --verseIndex )
    {
      if ( verseIndex == maxVerseIndex )
      {
        verse.append( FIRST_LINE_FORMAT.formatted( THINGS[ verseIndex ] ) );
      }
      else
      {
        verse.append( OTHER_LINES_FORMAT.formatted( ACTIONS[ verseIndex ], THINGS[ verseIndex ] ) );
      }
      verse.append( " " );
    }
    verse.append( END );
    return verse.toString();
  }

  static String verses( final int from, final int to )
  {
    final var verses = new ArrayList<String>();
    for ( int verse = from; verse <= to; ++verse )
    {
      verses.add( verse( verse ) );
    }
    return String.join( "\n", verses );
  }

  static String sing()
  {
    return verses( 1, 12 );
  }
}