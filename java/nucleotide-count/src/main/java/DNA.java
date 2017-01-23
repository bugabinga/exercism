import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Desoxyribonukleinsäure
 * @author okr
 *
 */
public class DNA
{
  private final HashMap<Character, Integer> acids;
  private final Character[]                      ACIDS = new Character[]{ 'A', 'C', 'G', 'T' };

  /**
   * Constructs a strand of DNA consisting of {@code nucleotides}.
   * @param nucleotides A String of nucleotides.
   */
  public DNA( final String nucleotides )
  {
    acids = new HashMap<>( 4 );

    for ( char acid : ACIDS )
      acids.put( acid, 0 );

    for ( char nucleotide : nucleotides.toCharArray() )
      acids.merge( nucleotide, 1, ( a, b ) -> a + b );
  }

  long count( final Character acid )
  {
    if ( !Arrays.asList( ACIDS ).contains( acid ))
      throw new IllegalArgumentException( "The acid " + acid + " is not a nucleotide." );

    return acids.getOrDefault( acid, 0 );
  }

  Map<Character, Integer> nucleotideCounts()
  {
    return acids;
  }
}