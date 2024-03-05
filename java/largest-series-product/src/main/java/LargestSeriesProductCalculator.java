import java.util.Map;
import java.util.regex.Pattern;

class LargestSeriesProductCalculator
{
  private static final Pattern SINGLE_CHARACTERS = Pattern.compile( "" );
  private static final int[]   NO_NUMBERS        = new int[ 0 ];

  private final int[] inputNumber;

  LargestSeriesProductCalculator( final String inputNumber )
  {
    if ( inputNumber.isBlank() )
    {
      this.inputNumber = NO_NUMBERS;
    }
    else
    {
      final var digits = SINGLE_CHARACTERS.split( inputNumber );
      this.inputNumber = new int[ digits.length ];
      for ( int index = 0; index < digits.length; ++index )
      {
        try
        {
          this.inputNumber[ index ] = Integer.parseInt( digits[ index ] );
        }
        catch ( final NumberFormatException nfe )
        {
          throw new IllegalArgumentException( "String to search may only contain digits.", nfe );
        }
      }
    }
  }

  long calculateLargestProductForSeriesLength( final int numberOfDigits )
  {
    if ( numberOfDigits < 0 )
    {
      throw new IllegalArgumentException(
          "Series length must be non-negative." );
    }

    if ( numberOfDigits == 0 )
    {
      return 1;
    }

    if ( numberOfDigits > inputNumber.length )
    {
      throw new IllegalArgumentException(
          "Series length must be less than or equal to the length of the string to search." );
    }

    long product = 0;
    for ( int index = 0; index < inputNumber.length; ++index )
    {
      final long[] candidateFactors = new long[ numberOfDigits ];
      for ( int subIndex = index; subIndex < index + numberOfDigits && subIndex < inputNumber.length; ++subIndex )
      {
        candidateFactors[ subIndex - index ] = inputNumber[ subIndex ];
      }

      long candidateProduct = 1;
      for ( int factorsIndex = 0; factorsIndex < numberOfDigits; ++factorsIndex )
      {
        candidateProduct = candidateProduct * candidateFactors[ factorsIndex ];
      }

      product = Math.max( product, candidateProduct );
    }
    return product;
  }
}