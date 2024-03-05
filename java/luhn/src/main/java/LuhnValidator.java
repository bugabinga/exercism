import java.util.regex.Pattern;

class LuhnValidator
{
  private static final Pattern WHITESPACE        = Pattern.compile( "\\s" );
  private static final Pattern SINGLE_CHARACTERS = Pattern.compile( "" );

  static boolean isValid( final String candidate )
  {
    final var strippedCandidate = WHITESPACE.matcher( candidate ).replaceAll( "" );
    if ( strippedCandidate.length() > 1 )
    {
      final var digits = SINGLE_CHARACTERS.split( strippedCandidate );
      long sum = 0;
      for ( int index = digits.length - 1; index >= 0; index-- )
      {
        final var digit = digits[ index ];
        try
        {
          var number = Integer.parseUnsignedInt( digit );
          if ( ( digits.length - index ) % 2 == 0 )
          {
            number = number + number;
            if ( number > 9 )
            {
              number = number - 9;
            }
          }
          sum = sum + number;
        }
        catch ( final NumberFormatException __ )
        {
          return false;
        }
      }
      return sum % 10 == 0;
    }
    return false;
  }
}
