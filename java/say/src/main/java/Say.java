import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Say
{
  private static final Map<Integer, String> TENS = new HashMap<>();

  static
  {
    TENS.put( 0, "zero" );
    TENS.put( 1, "one" );
    TENS.put( 2, "two" );
    TENS.put( 3, "three" );
    TENS.put( 4, "four" );
    TENS.put( 5, "five" );
    TENS.put( 6, "six" );
    TENS.put( 7, "seven" );
    TENS.put( 8, "eight" );
    TENS.put( 9, "nine" );
    TENS.put( 10, "ten" );
    TENS.put( 11, "eleven" );
    TENS.put( 12, "twelve" );
    TENS.put( 13, "thirteen" );
    TENS.put( 14, "fourteen" );
    TENS.put( 15, "fifteen" );
    TENS.put( 16, "sixteen" );
    TENS.put( 17, "seventeen" );
    TENS.put( 18, "eighteen" );
    TENS.put( 19, "nineteen" );
    TENS.put( 20, "twenty" );
    TENS.put( 30, "thirty" );
    TENS.put( 40, "forty" );
    TENS.put( 50, "fifty" );
    TENS.put( 60, "sixty" );
    TENS.put( 70, "seventy" );
    TENS.put( 80, "eighty" );
    TENS.put( 90, "ninety" );
  }

  private static final String[] SCALE = {
      "hundred",
      "thousand",
      "million",
      "billion"
  };

  public static String say( final long number )
  {
    if ( number < 0 )
    {
      throw new IllegalArgumentException( "Given number to say must be larger or equal to zero. Given: " + number );
    }
    if ( number > 999_999_999_999L )
    {
      throw new IllegalArgumentException(
          "Given number to say must be smaller or equal to a trillion. Given: " + number );
    }
    if ( number <= 99 )
    {
      return sayTens( Math.toIntExact( number ) );
    }
    if ( number <= 999 )
    {
      return sayHundreds( number );
    }

    return sayThousands( number );
  }

  private static String sayTens( final int number )
  {
    return TENS.computeIfAbsent( number, missingNumber ->
    {
      final int rest = missingNumber % 10;
      return sayTens( missingNumber - rest ) + "-" + sayTens( rest );
    } );
  }

  private static String sayHundreds( final long number )
  {
    final long hundreds = number / 100;
    final long rest = number % 100;

    final var sentence = new StringBuilder();
    sentence.append( say( hundreds ) );
    sentence.append( " " );
    sentence.append( SCALE[ 0 ] );
    if ( rest != 0 )
    {
      sentence.append( " " );
      sentence.append( say( rest ) );
    }
    return sentence.toString();
  }

  private static String sayThousands( final long number )
  {
    final int number_of_digits = (int) ( Math.log10( number ) + 1 );
    final int number_of_thousands = (int) Math.ceil( number_of_digits / 3.0 );

    final var words = new ArrayDeque<String>();
    long rest = number;
    for ( int index = 0; index < number_of_thousands; ++index )
    {
      final int chunk = (int) ( rest % 1000 );
      if ( chunk != 0 )
      {
        if ( index != 0 )
        {
          //skip the first scale (hundreds),because it is already handled in `sayHundreds`
          words.addFirst( SCALE[ index ] );
        }
        words.addFirst( say( chunk ) );
      }
      rest = rest / 1000;
    }

    return String.join( " ", words );
  }
}
