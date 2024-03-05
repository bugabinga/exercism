import java.util.ArrayList;
import java.util.List;

class Series
{
  private final String input;
  private final int    length;

  Series( final String input )
  {
    this.input = input;
    this.length = input.length();
  }

  List<String> slices( final int num )
  {
    if ( num <= 0 )
    {
      throw new IllegalArgumentException( "Slice size is too small." );
    }

    if ( num > length )
    {
      throw new IllegalArgumentException( "Slice size is too big." );
    }

    final var slices = new ArrayList<String>();
    for ( int index = 0; index <= length - num; index++ )
    {
      slices.add( input.substring( index, index + num ) );
    }
    return slices;
  }
}
